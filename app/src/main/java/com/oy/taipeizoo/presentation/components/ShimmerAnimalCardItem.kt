package com.oy.taipeizoo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerAnimalCardItem(
    colors:List<Color>,
    cardHeight:Dp,
    xShimmer:Float,
    yShimmer:Float,
    gradientWidth:Float,
    padding:Dp
) {
    //set brush
    val brush = Brush.linearGradient(
        colors,
        //Offset(x1,y1)
        start = Offset(xShimmer - gradientWidth, yShimmer - gradientWidth),
        //Offset(x2,y2)
        end = Offset(xShimmer, yShimmer)
    )

    Column(modifier = Modifier.padding(padding)) {
        Surface(

            shape = MaterialTheme.shapes.small
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(cardHeight)
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
                    .height(cardHeight / 10)
                    .background(brush = brush)
            )

        }
    }
}