package com.example.clientes

import java.io.Serializable

class Cliente (val nombre:String, val apellido:String, val servicio:String,
               val celular:String, val nap:String, val direccion:String) : Serializable