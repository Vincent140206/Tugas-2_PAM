package vin.pam.praktikum.praktikum_4.ticket_page

import androidx.benchmark.traceprocessor.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatusBox(
    state: BookingState,
    modifier: Modifier = Modifier
) {
    val bgColor = when (state) {
        BookingState.IDLE -> LightGrayBg
        BookingState.LOADING -> Color(0xFFEAF4FF)
        BookingState.SUCCESS -> Color(0xFFE8F5E9)
        BookingState.ERROR -> Color(0xFFFFEBEE)
    }

    val textColor = when (state) {
        BookingState.IDLE -> Color.DarkGray
        BookingState.LOADING -> BluePrimary
        BookingState.SUCCESS -> Color(0xFF4CAF50)
        BookingState.ERROR -> Color(0xFFD32F2F)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(bgColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            when (state) {
                BookingState.LOADING -> CircularProgressIndicator(modifier = Modifier.size(20.dp), color = BluePrimary, strokeWidth = 2.dp)
                BookingState.SUCCESS -> Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = textColor, modifier = Modifier.size(20.dp))
                BookingState.ERROR -> Icon(Icons.Filled.Error, contentDescription = null, tint = textColor, modifier = Modifier.size(20.dp))
                BookingState.IDLE -> {}
            }

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Status: ") }
                    append(
                        when (state) {
                            BookingState.IDLE -> "Silakan pesan tiket"
                            BookingState.LOADING -> "Memproses pesanan..."
                            BookingState.SUCCESS -> "Tiket berhasil dipesan!"
                            BookingState.ERROR -> "Nama harus diisi!"
                        }
                    )
                },
                fontSize = 15.sp,
                color = textColor
            )
        }
    }
}