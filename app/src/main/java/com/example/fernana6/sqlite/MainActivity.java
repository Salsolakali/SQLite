package com.example.fernana6.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConexionSQLHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view){
        switch (view.getId()){

            case R.id.viewUsers:
                Intent viewUsers = new Intent(MainActivity.this, ViewUsersActivity.class);
                startActivity(viewUsers);break;
            case R.id.addUser:
                Intent addUser = new Intent(MainActivity.this, RegisterUsersActivity.class);
                startActivity(addUser);break;

            default:break;

        }



    }

}
