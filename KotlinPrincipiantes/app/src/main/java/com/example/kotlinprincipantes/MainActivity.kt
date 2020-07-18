package com.example.kotlinprincipantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variablesYConstantes()
        tiposDeDatos()
    }

    /*
    Variables y Constantes
    */
    private fun variablesYConstantes(){
        //Declarar variable
        var myFirstVariable = "Hello Android"

        //Declarar una constante
        val myFirstConstant = 3
    }

    /*
    Tipos de datos (Data Types)
    */
    private fun tiposDeDatos(){
        //String
        val myFirstString = "Hello Android"
        val myFirstString2 : String = "Empezamos con Android Studio"
        val myFirstString3 = myFirstString + " " + myFirstString2
        println(myFirstString3)
        //Enteros (Byte, Short, Int, Long)
        val myFirstInt = 1
        //Decimales (Float, Double)
        val myFirstDec = 1.5
        //Boolean (Bool)
        val myFirstBool  = true
    }


}

