package com.example.examenparcial1.model

data class Categoria(
    val id: String,
    val nombre: String,
    val descripcion: String,
    val icono: Int
) {
    fun obtenerResumen(): String {
        return "$nombre: $descripcion"
    }
}