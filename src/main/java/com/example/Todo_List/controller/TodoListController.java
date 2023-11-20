package com.example.Todo_List.controller;

import com.example.Todo_List.model.TodoList;
import com.example.Todo_List.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tareas")
public class TodoListController {
    private TodoListService service;
    @Autowired
    public TodoListController(TodoListService service) {
        this.service = service;
    }
    @GetMapping()
    public String prueba(){
        return "Pueba de conexion";
    }
    @PostMapping("/tarea")
    public TodoList creeTarea (@RequestBody TodoList todoList){
        return this.service.creaTarea(todoList);
    }
    @GetMapping("/list")
    public List<TodoList>listTareas(){
        return this.service.listarTareas();
    }
    @GetMapping("/list-incomp")
    public List<TodoList>ListaIncompletas(){
        return this.service.tareasIncompletas();
    }
    @GetMapping("/list-comp")
    public List<TodoList>ListaCompletas(){
        return this.service.tareasCompletas();
    }
    @PutMapping("/list/{id}/{tiempo}")
    public TodoList completarTarea (@PathVariable("id") int id, @PathVariable("tiempo") String min){
       return this.service.completarTarea(id,min);
    }
    @GetMapping("/list-det/{id}")
    public TodoList obtnerDetalle(@PathVariable ("id") int id){
        return this.service.detalleTarea(id);
    }
    @DeleteMapping("list/{id}")
    public boolean eliminaTarea (@PathVariable ("id") int id){
        return this.service.eliminarTarea(id);
    }

    @PutMapping("/list-tar/{id}/{descripcion}/{min}")
    public boolean actualizaTarea (@PathVariable ("id") int id, @PathVariable("descripcion") String descripcion, @PathVariable ("min")String min){
        return this.service.actualizarTarea(id,descripcion,min);
    }
}
