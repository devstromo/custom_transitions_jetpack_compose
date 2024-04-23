package com.devstromo.customtransitionsjetpackcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTransitionsScreen(
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
    ) {

        Text(
            text = "Custom Transitions",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .align(Alignment.Center)
                .background(
                    color = Color.Red,
                    shape = ShapeDefaults.Large
                )
        ) {

        }
    }


}