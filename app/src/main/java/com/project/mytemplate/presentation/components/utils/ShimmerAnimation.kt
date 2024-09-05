package com.project.mytemplate.presentation.components.utils

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun ShimmerAnimation(modifier: Modifier){
    val colors = listOf(
        Color(0xFFE1E1E1),
        Color(0xFFAFACAC),
        Color(0xFFE1E1E1),
    )

    val transition = rememberInfiniteTransition(label = "")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 980f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 800, easing = FastOutSlowInEasing),
            RepeatMode.Restart
        ), label = ""
    )

    Box(modifier = modifier.drawBehind {
        drawRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(10f, 10f),
                end = Offset(translateAnim, translateAnim)
            ),
        )
    })
}