package com.example.myfirstapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//fun add(x:int, y:int) : Int = x + y
class test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

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
        }
        val p = Person("Borja",29)
        val d = Developer("Borja Dev", 7)

        d.name = "Developer person"
        println("Ejemplo de developers")
        println(p.name)
        println(d.name)
        println("Fin de ejemplo")
    }

    fun toast (textToast: String) = Toast.makeText(this, textToast, Toast.LENGTH_SHORT).show()
}

open class Person(name: String, val age: Int){

    var name = name
        set(value) {
            field = "$value Person"
        }
        get() = "Name: $field"
}

class Developer(name: String, age: Int) : Person(name, age) {


}

