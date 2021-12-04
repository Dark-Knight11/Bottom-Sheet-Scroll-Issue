package com.hypernova.bottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.hypernova.bottomsheet.navigation.Screens
import com.hypernova.bottomsheet.ui.theme.BottomSheetTheme

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bottomNavItems = listOf(Screens.LandingPage, Screens.SecondPage)
        val bottomSheetItems = listOf(
            Screens.SheetScreen1,
            Screens.SheetScreen2,
            Screens.SheetScreen3,
            Screens.SheetScreen4
        )
        setContent {
            BottomSheetTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen(bottomNavItems, bottomSheetItems)
                }
            }
        }
    }
}
