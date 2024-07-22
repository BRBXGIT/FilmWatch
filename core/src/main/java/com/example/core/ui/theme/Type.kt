package com.example.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core.R

private val robotoFont = FontFamily(
    Font(R.font.roboto_bold, weight = FontWeight.Bold),
    Font(R.font.roboto_thin, weight = FontWeight.Thin),
    Font(R.font.roboto_black, weight = FontWeight.Black),
    Font(R.font.roboto_light, weight = FontWeight.Light),
    Font(R.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.roboto_blackitalic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(R.font.roboto_regular, weight = FontWeight.Normal),
    Font(R.font.roboto_bolditalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.roboto_lightitalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto_mediumitalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = robotoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = robotoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = robotoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = robotoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = robotoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = robotoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    )
)