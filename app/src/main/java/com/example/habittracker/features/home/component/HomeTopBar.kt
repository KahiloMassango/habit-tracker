package com.example.habittracker.features.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.habittracker.core.theme.obviouslyFontFamily

@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        GreetingText(name = "Diana")
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null
            )
        }
    }
}

@Composable
fun GreetingText(
    modifier: Modifier = Modifier,
    name: String
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xFF0b110c),
                fontFamily = obviouslyFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("Good morning, ")
        }
        append("\n")

        withStyle(
            style = SpanStyle(
                color = Color(0xFF0b110c),
                fontFamily = obviouslyFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
        ) {
            append(name)
        }
    }

    Text(
        modifier = modifier,
        text = annotatedText,
        color = Color(0xFF0b110c),
        style = MaterialTheme.typography.bodyMedium,
        lineHeight = 30.sp,
    )
}

