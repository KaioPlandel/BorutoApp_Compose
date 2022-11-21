package com.plandel.borutoapp_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.plandel.borutoapp_compose.presentation.home.HomeScreen
import com.plandel.borutoapp_compose.presentation.splash.SplashScreen
import com.plandel.borutoapp_compose.presentation.welcome.WelcomeScreen
import com.plandel.borutoapp_compose.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(Screen.Home.route) {
             HomeScreen(navController)
        }
        composable(Screen.Details.route, arguments = listOf(
            navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )) {

        }
    }
}