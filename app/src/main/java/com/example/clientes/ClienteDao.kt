package com.example.clientes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ClienteDao {

    @Query("SELECT * FROM clientes")
    fun getAll() : LiveData<List<Cliente>>

    @Query("SELECT * FROM clientes WHERE idCliente = :id")
    fun get(id: Int): LiveData<Cliente>

    @Insert
    fun insertAll(vararg cliente: Cliente)

    @Update
    fun update(cliente: Cliente)

    @Delete
    fun delete(cliente: Cliente)

}