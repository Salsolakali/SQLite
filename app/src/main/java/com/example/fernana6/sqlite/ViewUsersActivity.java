package com.example.fernana6.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewUsersActivity extends AppCompatActivity {

    ConexionSQLHelper conexion;
    EditText consultarID;
    TextView consultarNombre, consultarTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        consultarID = findViewById(R.id.consultaID);
        consultarNombre = findViewById(R.id.consultaNombre);
        consultarTelefono = findViewById(R.id.consultaTelefono);

        conexion = new ConexionSQLHelper(getApplicationContext(),"dbUsuarios", null, 1);
    }

    public void onClick (View view){
        switch (view.getId()){
            case R.id.btnBuscar:consultar();break;
            case R.id.btnLimpiar:limpiarInput();break;
        }



    }

    public void consultar(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        String[] params = {consultarID.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO};

        Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos,Utilidades.CAMPO_ID+"=?",params,null,null,null);

        try {
            cursor.moveToFirst();
            consultarNombre.setText(cursor.getString(0));
            consultarTelefono.setText(cursor.getString(1));
            cursor.close();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "El id introducido no existe", Toast.LENGTH_SHORT).show();
            limpiarInput();
        }
    }

    public void limpiarInput(){
        consultarID.setText("");
        consultarNombre.setText("");
        consultarTelefono.setText("");
    }
}
