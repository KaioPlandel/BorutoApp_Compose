package com.plandel.borutoapp_compose.presentation.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.plandel.borutoapp_compose.R
import com.plandel.borutoapp_compose.ui.theme.starColor

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    scalefactor: Float = 3f,
    spaceBetwen: Dp = 6.dp
) {
    val result = calculateStars(rating = rating)
    val startPathString = stringResource(id = R.string.star)
    val startPath = remember {
        PathParser().parsePathString(pathData = startPathString).toPath()
    }
    val startPathBounds = remember {
        startPath.getBounds()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetwen) //forma de espaçar os items
    ) {
        result["filledStarts"]?.let {
            repeat(it) {
                FilledStart(
                    startPath = startPath,
                    startPathBounds = startPathBounds,
                    scalefactor = scalefactor
                )
            }
        }
        result["halfFilledStarts"]?.let {
            repeat(it) {
                HalfFilledStart(
                    startPath = startPath,
                    startPathBounds = startPathBounds,
                    scalefactor = scalefactor
                )
            }
        }

        result["emptyStars"]?.let {
            repeat(it) {
                EmptyStart(
                    startPath = startPath,
                    startPathBounds = startPathBounds,
                    scalefactor = scalefactor
                )
            }
        }
    }
}

@Composable
fun FilledStart(
    startPath: Path,
    startPathBounds: Rect,
    scalefactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scalefactor) {
            val pathWidth = startPathBounds.width
            val pathHeight = startPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = startPath,
                    color = starColor
                )
            }
        }
    }
}

@Composable
fun HalfFilledStart(
    startPath: Path,
    startPathBounds: Rect,
    scalefactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scalefactor) {
            val pathWidth = startPathBounds.width
            val pathHeight = startPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = startPath,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = startPath) {
                    drawRect(
                        color = starColor,
                        size = Size(
                            width = startPathBounds.maxDimension / 1.7f,
                            height = startPathBounds.maxDimension * scalefactor
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyStart(
    startPath: Path,
    startPathBounds: Rect,
    scalefactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scalefactor) {
            val pathWidth = startPathBounds.width
            val pathHeight = startPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = startPath,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
            }
        }
    }
}

@Composable
fun calculateStars(rating: Double): Map<String, Int> {
    val maxStars by remember { mutableStateOf(5) }
    var filledstars by remember { mutableStateOf(0) }
    var halfFilledStars by remember { mutableStateOf(0) }
    var emptyStars by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = rating) {
        val (firstNumber, lastNumber) = rating.toString()
            .split(".")
            .map { it.toInt() }

        if (firstNumber in 0..5 && lastNumber in 0..9) {
            filledstars = firstNumber
            if (lastNumber in 1..5) {
                halfFilledStars++
            }
            if (lastNumber in 6..9) {
                filledstars++
            }
            if (firstNumber == 5 && lastNumber > 0) {
                emptyStars = 5
                filledstars = 0
                halfFilledStars = 0
            }
        } else {
            Log.d("RatingWidget", "calculateStars: Invalid rating number")
        }
    }
    emptyStars = maxStars - (filledstars + halfFilledStars)
    return mapOf(
        "filledStarts" to filledstars,
        "halfFilledStars" to halfFilledStars,
        "emptyStars" to emptyStars
    )
}

@Composable
@Preview
fun FilledStartPreview() {
    RatingWidget(modifier = Modifier, rating = 1.0)
}