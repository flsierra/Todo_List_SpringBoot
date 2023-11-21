package com.example.Todo_List.service;

import com.example.Todo_List.exceptions.ApiRequestException;
import com.example.Todo_List.model.TodoList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoListService {
   List<TodoList> lista;

    public TodoListService() {
        this.lista = lista = new ArrayList<>();
    }
    public TodoList creaTarea (TodoList todoList){
        if (todoList.getDescripcionTarea() ==null || todoList.getDescripcionTarea().equals("")){
            throw new ApiRequestException(" El parametro descripción es obligatorio");
        }
        todoList.setIndice(lista.size()+1);
        this.lista.add(todoList);
        return todoList;
    }
    public List<TodoList> listarTareas(){
        if(lista.isEmpty()){
            throw new ApiRequestException("La lista esta vacia");
        }
        return this.lista;
    }
    public List<TodoList> tareasCompletas(){
        List<TodoList> filtroTareas = lista.stream()
                .filter(p -> p.getEstadoTarea().equals("Completada"))
                .collect(Collectors.toList());
        return filtroTareas;
    }
    public List<TodoList> tareasIncompletas(){
        List<TodoList> filtroTareasincompletas = lista.stream()
                .filter(p -> p.getEstadoTarea().equals("Pendiente"))
                .collect(Collectors.toList());
        return filtroTareasincompletas;
    }
    public TodoList completarTarea(int id, String min){
        Optional<TodoList> todoList = lista.stream().filter(l ->l.getIndice()==id).findFirst();
            if (todoList.isPresent() && (todoList.get().getEstadoTarea() == "Pendiente")){
                todoList.get().setEstadoTarea("Completada");
                todoList.get().setTiempoGastado(min);
                return todoList.get();
            }
        throw  new ApiRequestException("No se ha encontrado ninguna tarea con ese indice o ya se completo, verifique "+ id);
  }
  public TodoList detalleTarea(int id){
       Optional <TodoList> todo = this.lista.stream().filter(t -> t.getIndice()==id)
               .findFirst();
       if(todo.isEmpty()){
       throw new ApiRequestException("No se ha encontrado datos para esta tarea "+ id);
       }
       return todo.get();
  }
  public boolean eliminarTarea (int id){
        Optional<TodoList> existeTarea = this.lista.stream().filter(t -> t.getIndice()==id).findFirst();
        if (existeTarea.isPresent()){
            this.lista.remove(existeTarea.get());
            return true;
        }
        throw new ApiRequestException("La tarea no existe, por favor verifique "+id);
  }
  public boolean actualizarTarea (int id, String descripcion, String min ){
      Optional<TodoList> existeTarea = this.lista.stream().filter(t -> t.getIndice()==id).findFirst();
      if (existeTarea.isPresent()){
          TodoList tareaAModificar = existeTarea.get();
          tareaAModificar.setDescripcionTarea(descripcion);
          tareaAModificar.setTiempoGastado(min);
          return true;
      }
      return false;
  }
}
