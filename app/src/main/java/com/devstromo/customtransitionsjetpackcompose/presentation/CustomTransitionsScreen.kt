package com.devstromo.customtransitionsjetpackcompose.presentation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
            fontSize = 32.sp,
        )
    }


}