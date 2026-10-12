package vin.pam.praktikum.praktikum_6.appnavigasi.model

import kotlinx.serialization.Serializable

@Serializable
data class YouTubeStreamItem(
    val id: Int,
    val title: String,
    val videoId: String
)

@Serializable
data class TaskItem(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)

@Serializable
data class UserProfile(
    val username: String,
    val email: String,
    val role: String
)
