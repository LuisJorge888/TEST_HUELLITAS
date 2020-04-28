package com.example.huellitas.model;

import java.sql.Blob;
import java.util.Map;

public class usuario {

    //private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private int telefono1;
    private int telefono2;
    private String contrasenia;
    //private String imgPerfil;
    private Blob imagenPerfil;
    private boolean bloqueado;
    private Map<Integer, mascota> mascotas;

    public usuario(String nombre, String apellido, String email, String direccion, int telefono1, int telefono2, String contrasenia, Blob imagenPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.contrasenia = contrasenia;
        this.imagenPerfil = imagenPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Blob getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(Blob imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Map<Integer, mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Map<Integer, mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
