package com.example.fernana6.sqlite.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fernana6.sqlite.ConexionSQLHelper;
import com.example.fernana6.sqlite.R;
import com.example.fernana6.sqlite.Utilidades;
import com.example.fernana6.sqlite.models.Usuario;

import java.util.ArrayList;

public class SpinnerViewUsersActivity extends AppCompatActivity {

    Spinner spinnerPersonas;
    TextView id, name, phone;
    ArrayList<String> listaPersonas;
    ArrayList<Usuario> listaUsuarios;
    ConexionSQLHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_view_users);

        spinnerPersonas = findViewById(R.id.spinnerPersonas);
        id = findViewById(R.id.tvIdUser);
        name = findViewById(R.id.tvNameUser);
        phone = findViewById(R.id.tvPhoneUser);

        conexion = new ConexionSQLHelper(getApplicationContext(), "dbUsuarios", null,1);
        consultarListaPersonas();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaPersonas);
        spinnerPersonas.setAdapter(adapter);

        spinnerPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0) {
                    id.setText("ID: " + listaUsuarios.get(i -1).getId().toString());
                    name.setText("Nombre: " + listaUsuarios.get(i -1).getNombre().toString());
                    phone.setText("Telefono: " + listaUsuarios.get(i -1).getTelefono().toString());
                }else {
                    id.setText("ID");
                    name.setText("Nombre");
                    phone.setText("Telefono");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void consultarListaPersonas() {
        //Acceso a nuestra tabla
        SQLiteDatabase db = conexion.getReadableDatabase();

        Usuario persona;

        persona = null;

        listaUsuarios = new ArrayList<Usuario>();
        //SELECT * FROM usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO, null);

        while (cursor.moveToNext()){
            persona = new Usuario();
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getString(2));

            listaUsuarios.add(persona);
        }
        obtenerLista();
    }

    private void obtenerLista(){
        listaPersonas = new ArrayList<String>();
        listaPersonas.add("Selecciona un usuario para ver sus datos");

        for(int i = 0; i < listaUsuarios.size(); i++){
            listaPersonas.add(listaUsuarios.get(i).getId() + " - "+ listaUsuarios.get(i).getNombre());
        }
    }
}
