package com.example.fernana6.sqlite;

/**
 * Created by FernanA6 on 24-Apr-18.
 */

public class Utilidades {
    public static final String TABLA_USUARIO = "Usuario";
    public static final String TABLA_USUARIOS_REGISTRADOS = "UsuariosRegistrados";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_PASSWORD = "password";
    public static final String CREATE_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + " (" + CAMPO_ID +" INTEGER PRIMARY KEY, "+CAMPO_NOMBRE+" TEXT NOT NULL, "+CAMPO_TELEFONO+" TEXT NOT NULL)";
    public static final String CREATE_TABLA_USUARIOS_REGISTRADOS = "CREATE TABLE " + TABLA_USUARIOS_REGISTRADOS + " (" + CAMPO_ID +" INTEGER PRIMARY KEY, "+CAMPO_EMAIL+" TEXT NOT NULL, "+CAMPO_PASSWORD+" TEXT NOT NULL)";
    public static final String VER_USUARIOS_REGISTRADOS = "SELECT "+CAMPO_EMAIL+","+CAMPO_PASSWORD+"  FROM " + TABLA_USUARIOS_REGISTRADOS;
    public String insertarUsuario(String nombre, String telefono){
        return "INSERT INTO "
                + TABLA_USUARIO
                + " ("
                + CAMPO_NOMBRE
                + ","
                + CAMPO_TELEFONO
                + ")"
                + " VALUES('"
                + nombre
                + "','"
                + telefono
                +"')";
    }

    public String registrarUsuario(String email, String password){
        return "INSERT INTO "
                + TABLA_USUARIOS_REGISTRADOS
                + " ("
                + CAMPO_EMAIL
                + ","
                + CAMPO_PASSWORD
                + ")"
                + " VALUES('"
                + email
                + "','"
                + password
                +"')";
    }


}

