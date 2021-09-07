package com.example.clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cliente = Cliente("Kevin", "Black", "Cable", "88888888", "098H", "Zona5")
        val cliente2 = Cliente("Teo", "Obando", "Cable", "77777777", "097G", "Zona4")

        val listaClientes = listOf(cliente, cliente2)

        val adapter = ClienteAdapter(this, listaClientes)

        lista.adapter = adapter

    }
}