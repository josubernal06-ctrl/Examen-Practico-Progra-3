package com.example.examenparcial1.data

import com.example.examenparcial1.model.Medicamento
import com.example.examenparcial1.model.ProductoFarmaceutico

class MockProductoRepository : IProductoRepository {
    private val productos = listOf(
        Medicamento("M1", "Paracetamol", 15.50, 100, "C1", "Paracetamol 500mg", false, "1 cada 8 horas"),
        Medicamento("M2", "Ibuprofeno", 22.00, 50, "C1", "Ibuprofeno 400mg", false, "1 cada 8 horas"),
        Medicamento("M3", "Amoxicilina", 45.00, 30, "C2", "Amoxicilina 500mg", true, "1 cada 12 horas")
    )

    override fun obtenerTodosLosProductos(): List<ProductoFarmaceutico> {
        return productos
    }

    override fun obtenerProductosPorCategoria(idCategoria: String): List<ProductoFarmaceutico> {
        return productos.filter { it.idCategoria == idCategoria }
    }
}