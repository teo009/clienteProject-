package com.example.clientes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "clientes")
data class Cliente (

    val nombre:String,
    val apellido:String,
    val servicio:String,
    val celular:String,
    val nap:String,
    val direccion:String,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0

) : Serializable