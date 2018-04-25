package com.example.fernana6.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FernanA6 on 23-Apr-18.
 */

public class ConexionSQLHelper extends SQLiteOpenHelper{


    public ConexionSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creacion de la tabla usuario
        sqLiteDatabase.execSQL (Utilidades.CREATE_TABLA_USUARIO);

        //Creacion de la tabla usuarios registrados
        sqLiteDatabase.execSQL (Utilidades.CREATE_TABLA_USUARIOS_REGISTRADOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIOS_REGISTRADOS);
        onCreate(sqLiteDatabase);
    }


}
