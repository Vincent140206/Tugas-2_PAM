package vin.pam.praktikum.praktikum_6.appnavigasi.model

data class YouTubeStreamItem (
    val id: Int,
    val title: String,
    val videoId: String
)

data class TaskItem(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)