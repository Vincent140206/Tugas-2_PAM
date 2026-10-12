package vin.pam.praktikum.praktikum_5.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import vin.pam.praktikum.praktikum_5.screen.view.AboutScreen
import vin.pam.praktikum.praktikum_5.screen.view.DetailScreen
import vin.pam.praktikum.praktikum_5.screen.view.HomeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onNavigateToDetails = { id, name, isPremium ->
                    navController.navigate(
                        route = Details(locationId = id, locationName = name, isPremium = isPremium)
                    )
                },
                onNavigateToAbout = {
                    navController.navigate("about")
                },
                onNavigateToAbouts = { name ->
                    navController.navigate("about/$name")
                }
            )
        }
        composable<Details> { backStackEntry ->
            // Extract the entire Details object automatically
            val args = backStackEntry.toRoute<Details>()
            DetailScreen(
                locationId = args.locationId,
                locationName = args.locationName,
                isPremium = args.isPremium,
                onBack = { navController.popBackStack() }
            )
        }
        composable("about") {
            AboutScreen()
        }

        composable("about/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            AboutScreen(name)
        }
    }
}