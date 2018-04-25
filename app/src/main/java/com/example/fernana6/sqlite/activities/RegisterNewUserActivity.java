package com.example.fernana6.sqlite.activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fernana6.sqlite.ConexionSQLHelper;
import com.example.fernana6.sqlite.R;
import com.example.fernana6.sqlite.Utilidades;

import com.example.fernana6.sqlite.models.Usuario;

public class RegisterNewUserActivity extends AppCompatActivity {

    ConexionSQLHelper conexion;

    EditText registerEmail, registerPassword;

    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_user);

        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        btnRegister = findViewById(R.id.registerUsersBtn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser(){
        conexion = new ConexionSQLHelper(this, "dbUsuarios", null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String query = new Utilidades().registrarUsuario(registerEmail.getText().toString(),registerPassword.getText().toString());
        db.execSQL(query);

        db.close();

        Toast.makeText(this, "Se ha registrado correctamente el usuario " + registerEmail.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
