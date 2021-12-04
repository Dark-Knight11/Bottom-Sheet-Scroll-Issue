package com.hypernova.bottomsheet.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.hypernova.bottomsheet.LandingPage
import com.hypernova.bottomsheet.screens.*
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@Composable
fun NavGraph(navController: NavHostController) {
    AnimatedNavHost(
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

