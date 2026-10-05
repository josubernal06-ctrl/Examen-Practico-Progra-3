package com.example.examenparcial1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examenparcial1.model.Medicamento
import com.example.examenparcial1.viewmodel.FarmaciaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarritoScreen(viewModel: FarmaciaViewModel, onBack: () -> Unit) {
    val productos by viewModel.estadoProductos.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.cargarProductosPorCategoria("C1")
    }

    val medicamentosEnCarrito = productos.filterIsInstance<Medicamento>()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Carrito", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White) }
                },
                actions = {
                    IconButton(onClick = { }) { Icon(Icons.Default.Delete, contentDescription = "Vaciar", tint = Color.White) }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2E7D32))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(medicamentosEnCarrito) { medicamento ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.Top
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(text = medicamento.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                    Text(text = medicamento.principioActivo, color = Color.Gray, fontSize = 14.sp)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(text = "Bs. ${medicamento.precio}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                }

                                Surface(
                                    color = if (medicamento.esVentaLibre()) Color(0xFFE8F5E9) else Color(0xFFFFEBEE),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(
                                        text = if (medicamento.esVentaLibre()) "Venta Libre" else "Receta Médica",
                                        color = if (medicamento.esVentaLibre()) Color(0xFF2E7D32) else Color(0xFFC62828),
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }

                            if (!medicamento.esVentaLibre()) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "*Atención: Se requerirá adjuntar receta médica*",
                                    color = Color(0xFFC62828),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }

            Surface(
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    val total = medicamentosEnCarrito.sumOf { it.precio }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total a Pagar:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("Bs. $total", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32))
                    ) {
                        Text("Proceder al Pago", fontSize = 16.sp, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}