package com.example.myfirstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()

        toast("Hello World")
    }
//    fsdafdsafdsa
//    fdsa
//    fdsa
//    fdsa


    fun toast (textToast: String) = Toast.makeText(this, textToast, Toast.LENGTH_SHORT).show()
}

