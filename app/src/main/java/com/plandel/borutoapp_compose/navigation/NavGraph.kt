package com.plandel.borutoapp_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.plandel.borutoapp_compose.presentation.splash.SplashScreen
import com.plandel.borutoapp_compose.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route){
            SplashScreen(navController)
        }

        composable(Screen.Welcome.route){

        }
        composable(Screen.Home.route){

        }
        composable(Screen.Details.route, arguments = listOf(
            navArgument(DETAILS_ARGUMENT_KEY){
               type = NavType.IntType
            }
        )){

        }
    }
}