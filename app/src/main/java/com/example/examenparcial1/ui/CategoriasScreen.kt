package com.example.examenparcial1.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examenparcial1.viewmodel.FarmaciaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriasScreen(viewModel: FarmaciaViewModel, onNavigateToCarrito: () -> Unit) {
    // Observamos la lista de categorías desde el ViewModel
    val categorias by viewModel.estadoCategorias.collectAsState()

    // Cargar datos al iniciar la pantalla
    LaunchedEffect(Unit) {
        viewModel.cargarCategorias()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Farmacia Central", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2E7D32)),
                actions = {
                    IconButton(onClick = { }) { Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.White) }
                    IconButton(onClick = { }) { Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White) }
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFE8F5E9)) {
                NavigationBarItem(selected = true, onClick = { }, icon = { Text("💊") }, label = { Text("Categorías") })
                NavigationBarItem(selected = false, onClick = onNavigateToCarrito, icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito") }, label = { Text("Carrito") })
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categorias) { categoria ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Acción futura para ver detalles */ },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "📦", fontSize = 40.sp, modifier = Modifier.padding(end = 16.dp))
                        Column {
                            Text(text = categoria.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = categoria.descripcion, color = Color.Gray, fontSize = 14.sp)
                            Text(text = "Ver productos", color = Color(0xFF2E7D32), fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
                        }
                    }
                }
            }
        }
    }
}