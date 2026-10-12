package vin.pam.praktikum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.P1DetailRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.P1HomeRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.YouTubeStreamPagerScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.YouTubeStreamRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.P1DetailScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.P1HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigationP1()
                }
            }
        }
    }
}

@Composable
fun AppNavigationP1() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = P1HomeRoute
    ) {
        composable<P1HomeRoute> {
            P1HomeScreen(
                onNavigateToDetail = { navController.navigate(P1DetailRoute) }
            )
        }
        composable<P1DetailRoute> {
            P1DetailScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun AppNavigationP4() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = YouTubeStreamRoute
    ) {
        composable<YouTubeStreamRoute> {
            YouTubeStreamPagerScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
