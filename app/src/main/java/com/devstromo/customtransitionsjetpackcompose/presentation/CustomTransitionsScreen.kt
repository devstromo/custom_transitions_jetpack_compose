package com.devstromo.customtransitionsjetpackcompose.presentation

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTransitionsScreen(
    modifier: Modifier = Modifier
) {
    val colorStops = arrayOf(
        0.0f to Color(0xFFF88379),
        1f to Color(0xFFEE4B2B)
    )

    val gradientColors = listOf(
        Color(0xFFF88379),
        Color(0xFFEE4B2B),
        Color(0xFF000000)
    )
    val color = remember { Animatable(Color.Red) }

    val limit = 1.5f
    var progress by remember {
        mutableFloatStateOf(-limit)
    }

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
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .align(Alignment.Center)
                .drawWithCache {
                    val width = size.width

                    val offset = width * progressAnimated
                    val gradientWidth = width

                    val brush = Brush.verticalGradient(
                        colors = gradientColors,
                        startY = 0f,
                        endY = offset + gradientWidth

                    )
                    onDrawBehind {
                        drawRoundRect(
                            topLeft = Offset(0f,0f),
                            cornerRadius = CornerRadius(x = 50f, y = 50f),
                            brush = brush
                        )
                    }
                }
        )
    }


}