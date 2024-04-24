package com.devstromo.customtransitionsjetpackcompose.presentation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTransitionsScreen(
    modifier: Modifier = Modifier
) {
    val gradientColors = listOf(
        Color(0xFFF88379),
        Color(0xFFEE4B2B),
        Color(0xFF000000)
    )

    val limit = 1.5f

    val transition = rememberInfiniteTransition(label = "shimmer")
    val progressAnimated by transition.animateFloat(
        initialValue = -limit,
        targetValue = limit,
        animationSpec = infiniteRepeatable(
            animation = tween(3500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "shimmer"
    )

    BoxWithConstraints(
        modifier = modifier
    ) {

        Text(
            text = "Custom Transitions",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
        RoundRectangle(
            modifier = Modifier
                .align(Alignment.Center)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF000000), Color(0xFF343434))
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        )
//        Box(
//            modifier = Modifier
//                .width(150.dp)
//                .height(250.dp)
//                .align(Alignment.Center)
//                .drawWithCache {
//                    val width = size.width
//
//                    val offset = width * progressAnimated
//                    val gradientWidth = width
//
//                    val brush = Brush.verticalGradient(
//                        colors = gradientColors,
//                        startY = 0f,
//                        endY = offset + gradientWidth
//
//                    )
//                    onDrawBehind {
//                        drawRoundRect(
//                            topLeft = Offset(0f,0f),
//                            cornerRadius = CornerRadius(x = 50f, y = 50f),
//                            brush = brush
//                        )
//                    }
//                }
//        )
    }


}

@Composable
fun RoundRectangle(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(150.dp)
            .height(250.dp)
    )
}

