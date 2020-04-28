package com.example.huellitas.model;

import java.sql.Blob;

public class mascota {
    //private int id;
    private String nombre;
    private int edad;
    private boolean genero;
    private String tipoMascota;
    private String raza;
    private String descripcion;
    private Blob fotoMascota;
    private usuario duenioMascota;
    //private int dueniomascota;


    public mascota(String nombre, int edad, boolean genero, String tipoMascota, String raza, String descripcion, Blob fotoMascota, usuario duenioMascota) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.tipoMascota = tipoMascota;
        this.raza = raza;
        this.descripcion = descripcion;
        this.fotoMascota = fotoMascota;
        this.duenioMascota = duenioMascota;
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

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Blob getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(Blob fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public usuario getDuenioMascota() {
        return duenioMascota;
    }

    public void setDuenioMascota(usuario duenioMascota) {
        this.duenioMascota = duenioMascota;
    }
}
