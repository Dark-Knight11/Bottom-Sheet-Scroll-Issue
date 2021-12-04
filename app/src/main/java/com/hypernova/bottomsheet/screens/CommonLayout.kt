package com.hypernova.bottomsheet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hypernova.bottomsheet.R

@Composable
fun CommonLayout(modifier: Modifier = Modifier, text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sample),
            contentDescription = "sample",
            modifier = modifier
                .graphicsLayer {
                    shape = CircleShape
                    clip = true
                }
                .size(100.dp)
        )
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = text,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.Black
        )
    }
}