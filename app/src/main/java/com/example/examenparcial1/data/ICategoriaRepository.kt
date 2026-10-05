package com.example.examenparcial1.data

import com.example.examenparcial1.model.Categoria

interface ICategoriaRepository {
    fun obtenerTodasLasCategorias(): List<Categoria>
}