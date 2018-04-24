package com.example.fernana6.sqlite

import android.support.v7.app.AppCompatActivity;;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUsersActivity extends AppCompatActivity {

    ConexionSQLHelper conexion;

    EditText inputNombre, inputTelefono;

    Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_users);

        inputNombre = findViewById(R.id.inputNombre);
        inputTelefono = findViewById(R.id.inputTelefono);
        btnRegistrar =findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario(){
        conexion = new ConexionSQLHelper(this, "dbUsuarios", null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String query = new Utilidades().insertarUsuario(inputNombre.getText().toString(),inputTelefono.getText().toString());
        db.execSQL(query);

        db.close();

        Toast.makeText(this, "Se ha añadido correctamente el usuario" + inputNombre.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
