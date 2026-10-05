package com.example.examenparcial1.data

import com.example.examenparcial1.model.ProductoFarmaceutico

interface IProductoRepository {
    fun obtenerTodosLosProductos(): List<ProductoFarmaceutico>
    fun obtenerProductosPorCategoria(idCategoria: String): List<ProductoFarmaceutico>
}