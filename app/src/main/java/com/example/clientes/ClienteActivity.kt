package com.example.clientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_cliente.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClienteActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var cliente: Cliente
    private lateinit var clienteLiveData: LiveData<Cliente>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        database = AppDatabase.getDatabase(this)

        val idCliente = intent.getIntExtra("id", 0)

        clienteLiveData = database.clientes().get(idCliente)

        clienteLiveData.observe(this, Observer {

            cliente = it

            nombre_cliente.text = cliente.nombre
            servicio_cliente.text = cliente.servicio
            direccion_cliente.text = cliente.direccion

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cliente_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            R.id.editar_item -> {
                val intent = Intent(this, NuevoClienteActivity::class.java)
                intent.putExtra("cliente", cliente)
                startActivity(intent)
            }
            R.id.eliminar_item -> {
                clienteLiveData.removeObservers(this)
                CoroutineScope(Dispatchers.IO).launch {
                    database.clientes().delete(cliente)
                    this@ClienteActivity.finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}