package com.example.myfirstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id.recycler)
//        val manager = LinearLayoutManager(this)
//        recycler.layoutManager = manager
//        recycler.setHasFixedSize(true)
        recycler.adapter = MediaAdapter(getItems())

    }



    fun toast (textToast: String) = Toast.makeText(this, textToast, Toast.LENGTH_SHORT).show()
}


