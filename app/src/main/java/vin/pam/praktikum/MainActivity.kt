package vin.pam.praktikum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import vin.pam.praktikum.praktikum_5.screen.navigation.AppNavHost
import vin.pam.praktikum.ui.theme.PraktikumTheme

// Main Entrance
class MainActivity : ComponentActivity() {
//    val gadgets = listOf(
//        Gadget(1, "Smartphone", "Perangkat komunikasi genggam"),
//        Gadget(2, "Laptop", "Komputer portabel untuk bekerja"),
//        Gadget(3, "Tablet", "Perangkat layar sentuh antara hp dan laptop"),
//        Gadget(4, "Smartwatch", "Jam tangan pintar pelacak kesehatan"),
//        Gadget(5, "Earbuds", "Perangkat audio nirkabel"),
//    )
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumTheme {
                val navController = rememberNavController()

                Scaffold { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        AppNavHost(navController = navController)
                    }
                }
            }
        }
    }
}