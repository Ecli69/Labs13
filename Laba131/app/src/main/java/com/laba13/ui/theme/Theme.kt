package com.laba13.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val Blue600 = Color(0xFF0000F3)
val Blue700 = Color(0xFF1976D2)
val Gray = Color(0xFF9E9E9E)
val Green = Color(0xFF4CAF50)
val Red = Color(0xFFF44336)
val GreenDark = Color(0xFF2E7D32)
val BlueText = Color(0xFF0000FF)

private val LightColors = lightColorScheme(
    primary = Blue600,
    onPrimary = Color.White,
    primaryContainer = Blue700,
    secondary = Gray,
    background = Color.White,
    surface = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(
    primary = Blue600,
    onPrimary = Color.White,
    primaryContainer = Blue700,
    secondary = Gray,
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun Laba13Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    // Делаем все кнопки прямоугольными (скругление 0dp)
    val shapes = Shapes(
        small = RoundedCornerShape(0.dp),
        medium = RoundedCornerShape(0.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        shapes = shapes,
        content = content
    )
}