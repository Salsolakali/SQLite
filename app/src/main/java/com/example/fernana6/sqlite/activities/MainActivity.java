package com.example.fernana6.sqlite.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fernana6.sqlite.ConexionSQLHelper;
import com.example.fernana6.sqlite.R;
import com.example.fernana6.sqlite.Utilidades;
import com.example.fernana6.sqlite.models.Usuario;

import java.util.ArrayList;

import static com.example.fernana6.sqlite.Utilidades.TABLA_USUARIOS_REGISTRADOS;
import static com.example.fernana6.sqlite.Utilidades.VER_USUARIOS_REGISTRADOS;

public class MainActivity extends AppCompatActivity {

    ConexionSQLHelper conexion;
    EditText email, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        conexion = new ConexionSQLHelper(getApplicationContext(),"dbUsuarios", null, 1);
    }

    public void onClick(View view){
        switch (view.getId()){

            case R.id.loginUsersBtn:checkRegistedUsers();break;
            case R.id.signInUsersBtn:
                Intent register = new Intent(MainActivity.this,RegisterNewUserActivity.class);
                startActivity(register);
            default:break;

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void checkRegistedUsers() {
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] campos = {Utilidades.CAMPO_EMAIL, Utilidades.CAMPO_PASSWORD};

        Cursor cursor = db.query(Utilidades.TABLA_USUARIOS_REGISTRADOS,campos,null,null,null,null,null);
        //cursor.moveToFirst();

        while(cursor.moveToNext()) {
            if (cursor.getString(0).equals(email.getText().toString())&&cursor.getString(1).equals(password.getText().toString())) {

                Toast.makeText(this, "loggin correcto", Toast.LENGTH_SHORT);
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
            }

        }
    }
}
