package com.csalazar.materialdesign.models;

/**
 * Created by csalazar on 19/09/2017.
 */

public class Imagen {

    private int imagen;
    private String nombre;

    public Imagen(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public Imagen() {

    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
