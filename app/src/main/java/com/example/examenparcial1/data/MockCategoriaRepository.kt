package com.example.examenparcial1.data

import com.example.examenparcial1.model.Categoria

class MockCategoriaRepository : ICategoriaRepository {
    private val categorias = listOf(
        Categoria("C1", "Analgésicos", "Alivio del dolor y fiebre", android.R.drawable.ic_menu_add),
        Categoria("C2", "Antibióticos", "Tratamiento de infecciones bacterianas", android.R.drawable.ic_menu_add)
    )

    override fun obtenerTodasLasCategorias(): List<Categoria> {
        return categorias
    }
}