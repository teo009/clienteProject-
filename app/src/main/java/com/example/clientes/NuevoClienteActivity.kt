package com.example.clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cliente.*
import kotlinx.android.synthetic.main.activity_nuevo_cliente.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_cliente)

        var idCliente: Int? = null

        if (intent.hasExtra("cliente")) {

            val cliente = intent.extras?.getSerializable("cliente") as Cliente

            name_et.setText(cliente.nombre)
            apellido_et.setText(cliente.apellido)
            servicio_et.setText(cliente.servicio)
            cel_et.setText(cliente.servicio)
            nap_et.setText(cliente.servicio)
            direccion_et.setText(cliente.servicio)
            idCliente = cliente.idCliente

        }

        val database = AppDatabase.getDatabase(this)

        guardar_btn.setOnClickListener {
            val nombre = name_et.text.toString()
            val apellido = apellido_et.text.toString()
            val servicio = servicio_et.text.toString()
            val precio = precio_et.text.toString()
            val cel = cel_et.text.toString()
            val nap = nap_et.text.toString()
            val direccion = direccion_et.text.toString()

            val cliente = Cliente(nombre, apellido, servicio, precio, cel, nap, direccion)

            if (idCliente != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    cliente.idCliente = idCliente
                    database.clientes().update(cliente)
                    this@NuevoClienteActivity.finish()
                }
                Toast.makeText(this, "Cliente editado con éxito", Toast.LENGTH_SHORT).show()
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    database.clientes().insertAll(cliente)
                    this@NuevoClienteActivity.finish()
                }
                Toast.makeText(this, "Cliente agregado con éxito", Toast.LENGTH_SHORT).show()
            }
        }
    }
}