package com.hypernova.bottomsheet.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(35.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
                CommonLayout(text = "Second Screen")
            }
        }
    )
}

