package com.santiago.tsp.models;

public class Projects {
    private int id;
    private String nombre;
    private int tiempo;

    public Projects() {
    }

    public Projects(int id, String nombre, int tiempo) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
