package vin.pam.praktikum.praktikum_6.appnavigasi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun P1HomeScreen(
    onNavigateToDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { padding ->
        Column(
            modifier = modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("P1: Halaman Utama", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToDetail) {
                Text("Ke Detail Screen (P1) >")
            }
        }
    }
}
