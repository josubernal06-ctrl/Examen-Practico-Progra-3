package com.example.examenparcial1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenparcial1.ui.CarritoScreen
import com.example.examenparcial1.ui.CategoriasScreen
import com.example.examenparcial1.ui.theme.ExamenParcial1Theme
import com.example.examenparcial1.viewmodel.FarmaciaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenParcial1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // Instanciamos el ViewModel aquí para que viva durante toda la navegación
    val viewModel = remember { FarmaciaViewModel() }

    NavHost(navController = navController, startDestination = "categorias") {
        composable("categorias") {
            CategoriasScreen(
                viewModel = viewModel,
                onNavigateToCarrito = { navController.navigate("carrito") }
            )
        }
        composable("carrito") {
            CarritoScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}