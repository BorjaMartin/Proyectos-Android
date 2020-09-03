package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    private View btnImplement;


    private Button buttonNext;
    private final String GREETER = "Hello from the other side!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Forzar y cargar icono de APP en el Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);

/*
        //Acceder al botón con id buttonListener
        btn = (Button) findViewById(R.id.buttonListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"ACCION DE BOTON desde OnClickListener del Button",Toast.LENGTH_LONG).show();
            }
        });
*/
        //Acceder al botón con id buttonImplement
        /*
        Esta forma de darle funcionalidad al botón es añadiendo la implementación del OnClickListener a nuestra clase.
        De esta manera solo podremos tener un listener pa lanzar un evento on click, que debebmos sobreescribir
        En caso de tener varios elementos que necesitan implementar metodo, utilizar el método setOnClickListener
        */
        btnImplement = (Button) findViewById(R.id.buttonImplement);
        btnImplement.setOnClickListener(this);


        /*Acceder al segundo activity y enviarle un parametro*/
        buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Acceder a otra Activity
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //intent.putExtra("greeter", GREETER);
                startActivity(intent);
            }
        });


    }

    /*
    Esta forma de darle funcionalidad al botón se le asigna el metodo que debe lanzar el botón desde el diseño del xml del Activity
    */
    public void miMethod(View v){
        Toast.makeText(MainActivity.this,"ACCION DE BOTON desde método declarado desde activity",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"ACCION DE BOTON desde OnClick Implement",Toast.LENGTH_LONG).show();
    }









}