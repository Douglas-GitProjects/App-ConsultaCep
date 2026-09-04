package com.example.appconsultacep

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editCEP = findViewById<EditText>(R.id.editCEP)
        val btnConsultar = findViewById<Button>(R.id.bntConsultar)
        btnConsultar.setOnClickListener {
            val CEP = editCEP.text.toString()
            if(CEP.length != 8){
                Toast.makeText(this, "CEP Inválido", Toast.LENGTH_LONG).show()
            } else {

            }
        }
    }
}