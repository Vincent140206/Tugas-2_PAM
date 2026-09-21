package vin.pam.praktikum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vin.pam.praktikum.praktikum_3.ChangeTextScreen
import vin.pam.praktikum.praktikum_3.EventStateTest
import vin.pam.praktikum.praktikum_3.ImplicitIntentTest
import vin.pam.praktikum.praktikum_3.ticket_screen.TicketScreen
import vin.pam.praktikum.praktikum_4.CounterScreen
import vin.pam.praktikum.praktikum_4.Repo
import vin.pam.praktikum.praktikum_4.ticket_page.TicketScreens
import vin.pam.praktikum.ui.theme.PraktikumTheme
import vin.pam.praktikum.ui_halaman_profile.ProfileScreen

// Main Entrance
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicketScreens()
        }
//            var number by rememberSaveable { mutableStateOf(1) }
//
//            val snackbarHostState = remember {
//                SnackbarHostState()
//            }
//
//            Scaffold(
//                modifier = Modifier.fillMaxSize(),
//                snackbarHost = {
//                    SnackbarHost(
//                        hostState = snackbarHostState
//                    )
//                }
//            ) { innerPadding ->
//
//                CounterScreen(
//                    modifier = Modifier.padding(innerPadding),
//                    number = number,
//                    label = "Double",
//                    onButtonClick = {
//                        number *= 2
//                    }
//                )
//
//                LaunchedEffect(number) {
//                    snackbarHostState.showSnackbar(
//                        "Number $number is shown!"
//                    )
//                }
//
//                LaunchedEffect(Unit) {
//                    number = Repo.getData()
//                }
//            }
//        }
    }
}