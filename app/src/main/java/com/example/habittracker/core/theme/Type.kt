package com.example.habittracker.core.theme

import com.example.habittracker.R
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val obviouslyFontFamily = FontFamily(
        Font(R.font.obviously_regular, FontWeight.Normal),
        Font(R.font.obviously_semibold, FontWeight.SemiBold),
        Font(R.font.obviously_bold, FontWeight.Bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = obviouslyFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
        lineHeight = 40.sp,
    ),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = obviouslyFontFamily),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = obviouslyFontFamily),
    bodySmall = Typography().bodySmall.copy(fontFamily = obviouslyFontFamily)
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)