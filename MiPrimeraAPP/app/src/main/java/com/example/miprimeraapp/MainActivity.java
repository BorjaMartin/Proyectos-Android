package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "texto de prueba", Toast.LENGTH_LONG).show();

    }

    public void miMethod(View v){
        Toast.makeText(MainActivity.this,"ACCION DE BOTON",Toast.LENGTH_LONG).show();
    }

}