package vin.pam.praktikum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.EditProfileRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.P1DetailRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.P1HomeRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.ProfileRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.TaskDetailRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.TaskListRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.YouTubeStreamPagerScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.navigations.YouTubeStreamRoute
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.EditProfileScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.P1DetailScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.P1HomeScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.ProfileScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.TaskDetailScreen
import vin.pam.praktikum.praktikum_6.appnavigasi.screens.TaskListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigationP3()
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
fun AppNavigationP2() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TaskListRoute
    ) {
        composable<TaskListRoute> {
            TaskListScreen(
                onNavigateToDetail = { id, title, description, isCompleted ->
                    navController.navigate(
                        TaskDetailRoute(
                            id = id,
                            title = title,
                            description = description,
                            isCompleted = isCompleted
                        )
                    )
                }
            )
        }

        composable<TaskDetailRoute> { backStackEntry ->
            val routeArgs: TaskDetailRoute = backStackEntry.toRoute()

            TaskDetailScreen(
                id = routeArgs.id,
                title = routeArgs.title,
                description = routeArgs.description,
                isCompleted = routeArgs.isCompleted,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun AppNavigationP3() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ProfileRoute
    ) {
        composable<ProfileRoute> { backStackEntry ->
            // Mengamati Return-Back Data dari EditProfileScreen
            val userProfileState = backStackEntry.savedStateHandle
                .getStateFlow("user_profile_key", null)
                .collectAsState()

            ProfileScreen(
                userProfile = userProfileState.value,
                onEditClick = { navController.navigate(EditProfileRoute) }
            )
        }

        composable<EditProfileRoute> {
            EditProfileScreen(
                onSave = { updatedProfile ->
                    // Mengirimkan data balik ke backStackEntry sebelumnya
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("user_profile_key", updatedProfile)

                    navController.popBackStack()
                },
                onCancel = { navController.popBackStack() }
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
