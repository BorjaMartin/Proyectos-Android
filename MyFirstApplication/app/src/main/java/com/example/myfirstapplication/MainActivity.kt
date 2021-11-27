package com.example.myfirstapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()

        //Acceder al id message y cambiar su valor por Kotlin
        val myMessage: TextView = findViewById(R.id.message);
        myMessage.text = "Kotlin";

        //Crear un button y un editText para introducir un texto y mostrarlos en un toast al accionar el button
        val myFirstButton: Button = findViewById(R.id.firstButton);
        val myFirstInputText: EditText = findViewById(R.id.firstInputText);
        //Acceder al button para crear listener y ejecutar función al clickar
        myFirstButton.setOnClickListener {
            //Mostrar mensaje por toast pasando el valor del texto escriot en nuestro input id:firstInputText de nuestro Activity
            toast("Hello ${myFirstInputText.text}")

            val p = Person("Borja",29)
            val d = Developer("Borja Dev", 7)

            println("Ejemplo de developers")
            println(p)
            println(d)
            println("Fin de ejemplo")

        }






    }



    fun toast (textToast: String) = Toast.makeText(this, textToast, Toast.LENGTH_SHORT).show()
}

open class Person(name: String, age: Int)

class Developer(nameDev: String, ageDev: Int) : Person(name, age) {
    override fun toString(): String {
        return nameDev;
    }
}


