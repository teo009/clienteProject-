package com.example.clientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaClientes = emptyList<Cliente>()

        val db = AppDatabase.getDatabase(this)

        db.clientes().getAll().observe(this, Observer {

            listaClientes = it
            val adapter = ClienteAdapter(this, listaClientes)
            lista.adapter = adapter

        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ClienteActivity::class.java)
            intent.putExtra("id", listaClientes[position].idCliente)
            startActivity(intent)
        }

        add_cliente.setOnClickListener{
            val intent = Intent(this, NuevoClienteActivity::class.java)
            startActivity(intent)
        }

    }
}