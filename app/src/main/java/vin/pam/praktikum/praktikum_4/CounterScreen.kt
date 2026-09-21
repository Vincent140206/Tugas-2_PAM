package vin.pam.praktikum.praktikum_4

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CounterScreen(
    modifier: Modifier,
    number: Int,
    label: String,
    onButtonClick: () -> Unit
) {
    // var number by remember { mutableStateOf(0) }
    // val label by remember { mutableStateOf(&quot;Increment&quot;) }
    Column(modifier) {
        Text(text = "$number", fontSize = 72.sp)
        Button(onClick = onButtonClick) {
            Text(text = "$label"
            )
        }
    }
}