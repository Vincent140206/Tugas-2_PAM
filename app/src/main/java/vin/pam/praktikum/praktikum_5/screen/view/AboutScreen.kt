package vin.pam.praktikum.praktikum_5.screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AboutScreen() {
    Column {
        Text("Nama: Vincentius Dylan Wangsa Wijaya")
        Text("NIM: 245150401111001")
    }
}

@Composable
fun AboutScreen(name: String) {
    Column {
        Text("Nama: $name")
        Text("NIM: 245150401111001")
    }
}