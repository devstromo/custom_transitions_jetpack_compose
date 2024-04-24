package com.devstromo.customtransitionsjetpackcompose.presentation

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTransitionsScreen(
    modifier: Modifier = Modifier
) {

    var rotated by remember {
        mutableStateOf(false)
    }

    val rotateAnimation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(1500, 0, easing = EaseIn),
        label = "rotation"
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
                .align(Alignment.Center)
                .clickable { rotated = !rotated }
                .graphicsLayer {
                    rotationY = rotateAnimation
                    cameraDistance = 6 *  density
                },
            content = {
                if (rotated) {
                    RoundRectangle(
                        colors = listOf(
                            Color(0xFF343434),
                            Color(0xFF000000),
                        )
                    )
                } else {
                    RoundRectangle(
                        colors = listOf(
                            Color(0xFFF76767),
                            Color(0xFFEE4B2B),
                        )
                    )

                }
            }
        )

    }

}

@Composable
fun RoundRectangle(
    modifier: Modifier = Modifier,
    colors: List<Color> = emptyList()
) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(300.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = colors
                ),
                shape = RoundedCornerShape(20.dp)
            )
    )
}

