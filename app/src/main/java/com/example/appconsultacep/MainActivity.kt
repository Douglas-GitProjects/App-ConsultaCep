package com.example.appconsultacep

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.appconsultacep.api.ViaCepClient
import kotlinx.coroutines.launch

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
        val editCep = findViewById<EditText>(R.id.editCEP)
        val btnConsultar = findViewById<Button>(R.id.bntConsultar)
        val txtLogradouro = findViewById<EditText>(R.id.txtLogradouro)
        val txtBairro = findViewById<EditText>(R.id.txtBairro)
        val txtUf = findViewById<EditText>(R.id.txtUF)
        val txtDdd = findViewById<EditText>(R.id.txtDDD)
        val txtCidade = findViewById<EditText>(R.id.txtCidade)


        btnConsultar.setOnClickListener {
            val cep = editCep.text.toString()
            if(cep.length != 8){
                Toast.makeText(this, "CEP Inválido", Toast.LENGTH_LONG).show()
            }
            lifecycleScope.launch {
                val endereco = ViaCepClient.instance.buscaEndereco(cep)
                txtLogradouro.setText(endereco.logradouro)
            }
            lifecycleScope.launch {
                val endereco = ViaCepClient.instance.buscaEndereco(cep)
                txtBairro.setText(endereco.bairro)
            }
            lifecycleScope.launch {
                val endereco = ViaCepClient.instance.buscaEndereco(cep)
                txtUf.setText(endereco.uf)
            }
            lifecycleScope.launch {
                val endereco = ViaCepClient.instance.buscaEndereco(cep)
                txtDdd.setText(endereco.ddd)
            }
            lifecycleScope.launch {
                val endereco = ViaCepClient.instance.buscaEndereco(cep)
                txtCidade.setText(endereco.localidade)

            }
        }
    }
}