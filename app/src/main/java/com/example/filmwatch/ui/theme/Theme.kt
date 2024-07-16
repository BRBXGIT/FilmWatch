package com.example.filmwatch.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = Charcoal,
    onBackground = AlmostWhite,
    surface = RaisinBlack,
    onSecondaryContainer = LavenderBlush,
    onSurface = LavenderBlush,
    secondaryContainer = CharcoalPurple,
    onSurfaceVariant = CharcoalGray,
    primary = AlmostWhite,
    secondary = NeutralGray,
    tertiary = SlateGray,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
)

@Composable
fun FilmWatchTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

val mColors @Composable get() = MaterialTheme.colorScheme
val mTypography @Composable get() = MaterialTheme.typography
val mShapes @Composable get() = MaterialTheme.shapes