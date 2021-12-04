package com.hypernova.bottomsheet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hypernova.bottomsheet.*
import com.hypernova.bottomsheet.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.LandingPage.route
    ) {
        composable(route = Screens.LandingPage.route) {
            LandingPage(navController)
        }
        composable(route = Screens.SecondPage.route) {
           SecondPage(navController)
        }
        composable(route = Screens.SheetScreen1.route) {
            FirstScreen(navController)
        }
        composable(route = Screens.SheetScreen2.route) {
            SecondScreen(navController)
        }
        composable(route = Screens.SheetScreen3.route) {
            ThirdScreen(navController)
        }
        composable(route = Screens.SheetScreen4.route) {
            FourthScreen(navController)
        }
    }
}

