package com.example.huellitas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Blob;

public class mascota {
    @Expose @SerializedName("id") private int id;
    @Expose @SerializedName("nombre") private String nombre;
    @Expose @SerializedName("edad") private int edad;
    @Expose @SerializedName("genero") private boolean genero;
    @Expose @SerializedName("tipo") private String tipo;
    //@SerializedName("raza") private String raza;
    @Expose @SerializedName("descripcion") private String descripcion;
    //@SerializedName("foto") private Blob foto;
    //@SerializedName("duenio") private usuario duenio;
    //private int dueniomascota;
    //@Expose @SerializedName("imagen") private String imagen;


    public mascota(int id, String nombre, int edad, boolean genero, String tipo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public mascota(String nombre, int edad, boolean genero, String tipo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public mascota (int id, String nombre){
        this.id = id;
        this.nombre = nombre;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //public String getImagen() { return this.imagen; }

}
