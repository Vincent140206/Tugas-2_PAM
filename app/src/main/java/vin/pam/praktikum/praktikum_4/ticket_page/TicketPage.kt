package vin.pam.praktikum.praktikum_4.ticket_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

enum class BookingState {
    IDLE, LOADING, SUCCESS, ERROR
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketScreens() {
    var name by rememberSaveable { mutableStateOf("") }
    var quantity by rememberSaveable { mutableIntStateOf(1) }
    var bookingState by rememberSaveable { mutableStateOf(BookingState.IDLE) }

    val isFormEnabled = bookingState != BookingState.LOADING

    LaunchedEffect(bookingState) {
        if (bookingState == BookingState.LOADING) {
            delay(5000)
            bookingState = BookingState.SUCCESS
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Pemesanan Tiket",
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BluePrimary)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            TextField(
                name = name,
                onNamaChange = {
                    name = it
                    if (bookingState == BookingState.ERROR) bookingState = BookingState.IDLE
                },
                isEnabled = isFormEnabled
            )

            CounterTiketWidget(
                quantity = quantity,
                onDecrease = { if (quantity > 1) quantity-- },
                onIncrease = { quantity++ },
                isEnabled = isFormEnabled
            )

            Button(
                onClick = {
                    if (name.isBlank()) {
                        bookingState = BookingState.ERROR
                    } else {
                        bookingState = BookingState.LOADING
                    }
                },
                isEnabled = isFormEnabled
            )

            StatusBox(state = bookingState)
        }
    }
}

@Preview
@Composable
fun PreviewTicketScreen() {
    TicketScreens()
}