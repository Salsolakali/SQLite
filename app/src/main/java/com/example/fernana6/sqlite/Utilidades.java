package com.example.fernana6.sqlite;

/**
 * Created by FernanA6 on 24-Apr-18.
 */

public class Utilidades {
    public static final String TABLA_USUARIO = "Usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CREATE_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + " (" + CAMPO_ID +" INTEGER PRIMARY KEY, "+CAMPO_NOMBRE+" TEXT NOT NULL, "+CAMPO_TELEFONO+" TEXT NOT NULL)";

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
}

