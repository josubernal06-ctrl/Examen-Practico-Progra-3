package com.example.examenparcial1.model

class Medicamento(
    id: String,
    nombre: String,
    precio: Double,
    stock: Int,
    idCategoria: String,
    val principioActivo: String,
    val requiereReceta: Boolean,
    val dosis: String
) : ProductoFarmaceutico(id, nombre, precio, stock, idCategoria) {

    fun esVentaLibre(): Boolean {
        return !requiereReceta
    }
}