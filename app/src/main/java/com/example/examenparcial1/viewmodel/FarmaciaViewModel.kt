package com.example.examenparcial1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.examenparcial1.data.ICategoriaRepository
import com.example.examenparcial1.data.IProductoRepository
import com.example.examenparcial1.data.MockCategoriaRepository
import com.example.examenparcial1.data.MockProductoRepository
import com.example.examenparcial1.model.Categoria
import com.example.examenparcial1.model.ProductoFarmaceutico
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FarmaciaViewModel(
    private val repositorioCategorias: ICategoriaRepository = MockCategoriaRepository(),
    private val repositorioProductos: IProductoRepository = MockProductoRepository()
) : ViewModel() {

    private val _estadoCategorias = MutableStateFlow<List<Categoria>>(emptyList())
    val estadoCategorias: StateFlow<List<Categoria>> = _estadoCategorias.asStateFlow()

    private val _estadoProductos = MutableStateFlow<List<ProductoFarmaceutico>>(emptyList())
    val estadoProductos: StateFlow<List<ProductoFarmaceutico>> = _estadoProductos.asStateFlow()

    fun cargarCategorias() {
        _estadoCategorias.value = repositorioCategorias.obtenerTodasLasCategorias()
    }

    fun cargarProductosPorCategoria(idCategoria: String) {
        _estadoProductos.value = repositorioProductos.obtenerProductosPorCategoria(idCategoria)
    }
}