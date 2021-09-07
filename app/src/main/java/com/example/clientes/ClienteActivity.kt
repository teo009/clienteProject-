package com.example.clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cliente.*

class ClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        val cliente = intent.getSerializableExtra("cliente") as Cliente

        nombre_cliente.text = cliente.nombre
        servicio_cliente.text = cliente.servicio
        direccion_cliente.text = cliente.direccion

    }
}