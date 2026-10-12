package vin.pam.praktikum.praktikum_6.appnavigasi.navigations

import kotlinx.serialization.Serializable

@Serializable
object P1HomeRoute

@Serializable
object P1DetailRoute

@Serializable
object TaskListRoute

@Serializable
data class TaskDetailRoute(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)

@Serializable
object ProfileRoute

@Serializable
object EditProfileRoute

@Serializable
object YouTubeStreamRoute