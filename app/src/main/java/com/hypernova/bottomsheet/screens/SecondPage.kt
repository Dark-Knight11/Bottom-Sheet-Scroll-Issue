package com.hypernova.bottomsheet.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn

@Composable
fun SecondPage(navHostController: NavHostController) {
    LazyColumn(
        modifier = androidx.compose.ui.Modifier
            .background(androidx.compose.ui.graphics.Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(35.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    ) {
        items(21) {
            CommonLayout(text = "Second Page")
        }
    }
}