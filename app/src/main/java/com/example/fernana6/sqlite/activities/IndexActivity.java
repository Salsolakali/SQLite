package com.example.fernana6.sqlite.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fernana6.sqlite.R;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void onClick(View view){
        switch (view.getId()){

            case R.id.viewUsers:
                Intent viewUsers = new Intent(IndexActivity.this, ViewUsersActivity.class);
                startActivity(viewUsers);break;
            case R.id.addUser:
                Intent addUser = new Intent(IndexActivity.this, RegisterUsersActivity.class);
                startActivity(addUser);break;
            case R.id.viewUsersSpinner:
                Intent viewUsersSpinner = new Intent(IndexActivity.this, SpinnerViewUsersActivity.class);
                startActivity(viewUsersSpinner);break;


            default:break;

        }



    }
}
