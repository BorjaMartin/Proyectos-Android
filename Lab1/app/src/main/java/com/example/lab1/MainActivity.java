package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Forzar y cargar icono de APP en el Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_lab1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Acceder al segundo activity y enviarle un parametro*/
        buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSecond =
            }
        });

    }
}