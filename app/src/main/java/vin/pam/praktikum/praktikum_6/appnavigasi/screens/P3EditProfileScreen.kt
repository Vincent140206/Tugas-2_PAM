package vin.pam.praktikum.praktikum_6.appnavigasi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vin.pam.praktikum.praktikum_6.appnavigasi.model.UserProfile

@Composable
fun ProfileScreen(
    userProfile: UserProfile?,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { padding ->
        Column(
            modifier = modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Profil Pengguna", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Username: ${userProfile?.username ?: "Belum Diatur"}")
            Text("Email: ${userProfile?.email ?: "-"}")
            Text("Role: ${userProfile?.role ?: "-"}")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onEditClick) {
                Text("Edit Profil (navigate) >")
            }
        }
    }
}

@Composable
fun EditProfileScreen(
    onSave: (UserProfile) -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            modifier = modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Form Edit Profil", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(24.dp))
            Row {
                OutlinedButton(onClick = onCancel) {
                    Text("Batal")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { onSave(UserProfile(username, email, "Administrator")) }) {
                    Text("Simpan & Kirim Balik")
                }
            }
        }
    }
}