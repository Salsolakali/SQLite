package com.example.fernana6.sqlite.models;

/**
 * Created by FernanA6 on 23-Apr-18.
 */

public class Usuario {
    private Integer id;
    private String nombre, telefono, email,password;

    public Usuario() {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {return nombre;}

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {return email;}

    public String getPassword() {return password;}


    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {this.email = email;}

    public void setPassword(String password) {this.password = password;}
}
