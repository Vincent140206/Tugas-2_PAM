package vin.pam.praktikum.praktikum_6.appnavigasi.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import vin.pam.praktikum.praktikum_6.appnavigasi.model.TaskItem

@Composable
fun TaskListScreen(
    onNavigateToDetail: (id: Int, title: String, description: String, isCompleted: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val taskList = rememberSaveable {
        mutableStateListOf(
            TaskItem(1, "Belajar Jetpack Compose", "Memahami State Hoisting dan Navigation 2.8+"),
            TaskItem(2, "Mengerjakan Modul Praktikum", "Membuat Percobaan 2 dengan LazyColumn & Checkbox"),
            TaskItem(3, "Setup Kotlin Serialization", "Menambahkan plugin serialization di build.gradle"),
            TaskItem(4, "Diskusi Kelompok", "Membahas konsep SavedStateHandle tanpa ViewModel")
        )
    }

    Scaffold { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "Daftar Tugas (Klik item untuk Detail)",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(taskList, key = { it.id }) { task ->
                    TaskRowItem(
                        task = task,
                        onCheckedChange = { isChecked ->
                            val index = taskList.indexOfFirst { it.id == task.id }
                            if (index != -1) {
                                taskList[index] = taskList[index].copy(isCompleted = isChecked)
                            }
                        },
                        onItemClick = {
                            onNavigateToDetail(
                                task.id,
                                task.title,
                                task.description,
                                task.isCompleted
                            )
                        }
                    )
                }
            }
        }
    }
}



@Composable
fun TaskRowItem(
    task: TaskItem,
    onCheckedChange: (Boolean) -> Unit,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = onCheckedChange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,
                    textDecoration = if (task.isCompleted) TextDecoration.LineThrough else TextDecoration.None
                )
                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = ">",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}