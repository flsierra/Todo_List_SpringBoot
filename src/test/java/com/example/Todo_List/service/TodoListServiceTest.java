package com.example.Todo_List.service;

import com.example.Todo_List.exceptions.ApiRequestException;
import com.example.Todo_List.model.TodoList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListServiceTest {

    @Test
    void creaTareadeFormaSatisfactoria() {
        //Arrange
        TodoList tara1 = new TodoList(1,"Lavar ropa","12","pendiente");
        TodoListService service = new TodoListService();
        // Act
        service.creaTarea(tara1);
        // Assert
        assertTrue(service.listarTareas().contains(tara1));
    }
    @Test
    void creaTareadebeArrojarUnErroCuandoSeCreaUnaTareaConDescripcionNull() {
        //Arrange
        TodoList tara1 = new TodoList(1,null,"12","pendiente");
        // Act
        TodoListService service = new TodoListService();
        // Assert
       try {
           service.creaTarea(tara1);
           fail();
       }catch (ApiRequestException error){
           assertTrue(error.getMessage().contains(" El parametro descripción es obligatorio"));
        }
    }
    @Test
    void creaTareadebeArrojarUnErroCuandoSeCreaUnaTareaConDescripcionVacia() {
        //Arrange
        TodoList tara1 = new TodoList(1,"","12","pendiente");
        // Act
        TodoListService service = new TodoListService();
        // Assert
        assertThrows(ApiRequestException.class, () ->service.creaTarea(tara1));
    }
    @Test
    void listarTareasdeFormaSatisfactoria() {
        //Arrange
        int expectedListSize =2;
        TodoList tara1 = new TodoList(1,"Lavar ropa","12","pendiente");
        TodoList tara2 = new TodoList(2,"Lavar losa","1","pendiente");
        TodoListService service = new TodoListService();
        service.creaTarea(tara1);
        service.creaTarea(tara2);
        //Act
        List<TodoList> task = service.listarTareas();
        // Assert
        assertTrue(task.contains(tara1));
        assertTrue(task.contains(tara2));
        assertEquals(expectedListSize,task.size());
    }
    @Test
    void listarTareasDebeArrojarUnErrorCuandolaListaEstaVacia(){
        // Arrange
        TodoListService service = new TodoListService();
        //Act  && // Assert
        assertThrows(ApiRequestException.class, () -> service.listarTareas());
    }
    @Test
    void tareasCompletas() {
    }

    @Test
    void tareasIncompletas() {
    }

    @Test
    void completarTarea() {
    }

    @Test
    void detalleTarea() {
    }

    @Test
    void eliminarTarea() {
    }

    @Test
    void actualizarTarea() {
    }
}