package com.example.Todo_List.model;

public class TodoList {
   private  int indice;
    private String descripcionTarea;
    private String tiempoGastado= "0" ;
    private String estadoTarea = "Pendiente";


    public TodoList() {
    }

    public TodoList(int indice,String descripcionTarea, String tiempoGastado, String estadoTarea) {
        this.indice = indice;
        this.descripcionTarea = descripcionTarea;
        this.tiempoGastado= tiempoGastado;
        this.estadoTarea = estadoTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public String getTiempoGastado() {
        return tiempoGastado;
    }

    public void setTiempoGastado(String tiempoGastado) {
        this.tiempoGastado = tiempoGastado;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
