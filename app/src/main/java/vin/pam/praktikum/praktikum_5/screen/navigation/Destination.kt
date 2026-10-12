package vin.pam.praktikum.praktikum_5.screen.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Details(
    val locationId: Int,
    val locationName: String,
    val isPremium: Boolean = false
)
