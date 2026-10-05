package com.example.examenparcial1.model

abstract class ProductoFarmaceutico(
    val id: String,
    val nombre: String,
    var precio: Double,
    var stock: Int,
    val idCategoria: String
) {
    fun actualizarStock(cantidad: Int): Boolean {
        if (stock + cantidad < 0) return false
        stock += cantidad
        return true
    }

    fun tieneStockDisponible(): Boolean {
        return stock > 0
    }
}