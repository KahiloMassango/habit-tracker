package com.example.habittracker.features.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.core.theme.obviouslyFontFamily

val colors = listOf(Color(0xFFf8ce63), Color(0xFFb8eb6a), Color(0xFFa3c7fd), Color(0xFFfc8fc6))

@Composable
fun HabitCard(
    modifier: Modifier = Modifier
) {
    val done = listOf(true, false).random()
    val backgroudColor = if(done) Color(0xFFf6f8fa) else colors.random()
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .size(250.dp, 125.dp)
            .background(backgroudColor),
        colors = CardDefaults.cardColors(
            containerColor = backgroudColor,
            contentColor = Color(0xFF0b110c)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Book,
                    contentDescription = null,
                    tint = if(done) Color(0xFFc5c4c7) else Color(0xFF0b110c)
                )

                RadioButton(
                    selected = done,
                    onClick = {},
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(0xFF0b110c),
                        unselectedColor = Color(0xFF0b110c)
                    )
                )
            }
            HabitSummary(
                modifier = Modifier.padding(16.dp),
                title = "Daily",
                description = "Read a book",
                color = if(done) Color(0xFFc5c4c7) else Color(0xFF0b110c)
            )
        }
    }
}

@Composable
private fun HabitSummary(
    modifier: Modifier = Modifier,
    title: String,
    color: Color = Color(0xFF0b110c),
    description: String
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = obviouslyFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append(title)
        }
        append("\n")

        withStyle(
            style = SpanStyle(
                fontFamily = obviouslyFontFamily,
            )
        ) {
            append(description)
        }
    }

    Text(
        modifier = modifier,
        text = annotatedText,
        color = color,
        style = MaterialTheme.typography.bodySmall,
    )
}

