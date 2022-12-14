package com.oy.taipeizoo.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingAnimalShimmer(
    imageHeight:Dp,
    padding:Dp = 16.dp
) {

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {

        val cardWidthPx = with(LocalDensity.current) { (maxWidth - (padding * 2)).toPx() }
        val cardHeightPx = with(LocalDensity.current) { (imageHeight - padding).toPx() }

        val gradientWidth: Float = (0.2f * cardHeightPx)

        val infiniteTransition = rememberInfiniteTransition()

        val xCardShimmer = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = (cardWidthPx + gradientWidth),
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    easing = LinearEasing,
                    delayMillis = 300
                ),
                repeatMode = RepeatMode.Restart
            )
        )
        val yCardShimmer = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = (cardHeightPx + gradientWidth),
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    easing = LinearEasing,
                    delayMillis = 300
                ),
                repeatMode = RepeatMode.Restart
            )
        )

        val colors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.9f)
        )


        LazyColumn {
            item{
                //set brush
                val brush = Brush.linearGradient(
                    colors,
                    //Offset(x1,y1)
                    start = Offset(xCardShimmer.value - gradientWidth, yCardShimmer.value - gradientWidth),
                    //Offset(x2,y2)
                    end = Offset(xCardShimmer.value, yCardShimmer.value)
                )
                Column(modifier = Modifier.padding(padding)) {
                    Surface(

                        shape = MaterialTheme.shapes.small
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(imageHeight)
                                .background(brush = brush)

                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(imageHeight / 10)
                                .background(brush = brush)
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(imageHeight / 10)
                                .background(brush = brush)
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(imageHeight / 10)
                                .background(brush = brush)
                        )

                    }
                }
            }

        }

    }
}