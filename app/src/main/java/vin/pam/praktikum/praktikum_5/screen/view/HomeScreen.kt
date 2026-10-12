package vin.pam.praktikum.praktikum_5.screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onNavigateToDetails: (Int, String, Boolean) -> Unit,
    onNavigateToAbout: () -> Unit,
    onNavigateToAbouts: (String) -> Unit
) {
    val locations = listOf("Paris", "Tokyo", "New York", "London")

    var isPremium by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Travel Journal",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Premium")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = isPremium,
                onCheckedChange = { isPremium = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        locations.forEachIndexed { index, name ->
            Button(
                onClick = {
                    onNavigateToDetails(index, name, isPremium)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(text = "Visit $name")
            }
        }

        Button(
            onClick = onNavigateToAbout,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            Text("About")
        }

        var name by remember { mutableStateOf("") }

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Masukkan nama") }
        )

        Button(onClick = {
            onNavigateToAbouts(name)
        }) {
            Text("Go to About")
        }
    }
}
