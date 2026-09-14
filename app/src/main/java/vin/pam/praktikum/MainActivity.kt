package vin.pam.praktikum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import vin.pam.praktikum.praktikum_3.ChangeTextScreen
import vin.pam.praktikum.praktikum_3.EventStateTest
import vin.pam.praktikum.praktikum_3.ImplicitIntentTest
import vin.pam.praktikum.praktikum_3.ticket_screen.TicketScreen
import vin.pam.praktikum.ui.theme.PraktikumTheme
import vin.pam.praktikum.ui_halaman_profile.ProfileScreen

// Main Entrance
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicketScreen()
        }
    }
}