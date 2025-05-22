package com.example.habittracker.features.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

val colors = listOf(
    Color(0xff4e55e0),
    Color(0xFFbBeb6c),
    Color(0xFFf7cd63),
    Color(0xFFfc8fc6)
)

@Composable
fun HabitCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val done = listOf(true, false).random()
    val backgroudColor = if (done) Color(0xFFf6f8fa) else colors.random()
    Card(
        onClick = onClick,
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
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
                    tint = if (done) Color(0xFFc5c4c7) else Color(0xFF0b110c)
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
                title = "Reading",
                description = "Read a book",
                color = if (done) Color(0xFFc5c4c7) else Color(0xFF0b110c)
            )
        }
    }
}

@Composable
private fun HabitSummary(
    modifier: Modifier = Modifier,
    title: String,
    color: Color = Color(0xFF0b110c),
    description: String,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Text(
            modifier = Modifier,
            text = title,
            color = color,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier,
            text = description,
            color = color,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}


