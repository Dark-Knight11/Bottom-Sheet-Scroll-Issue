package com.hypernova.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.hypernova.bottomsheet.navigation.Screens
import com.hypernova.bottomsheet.screens.CommonLayout

@Composable
fun LandingPage(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
        CommonLayout(text = "Landing Page")
    }
}






