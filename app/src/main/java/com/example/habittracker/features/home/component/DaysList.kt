package com.example.habittracker.features.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.habittracker.features.home.model.Day
import java.time.LocalDate

@Composable
fun DaysList(
    modifier: Modifier = Modifier,
    days: List<Day> = listOf(Day(18, "Mon"), Day(19, "Tue"), Day(20, "Wed"), Day(21, "Thu"), Day(22, "Fri"), Day(23, "Sat"), Day(24, "Sun"))
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(days, { it.hashCode() }) { day ->
            DayItem(day = day)
        }
    }
}


@Composable
fun DayItem(
    modifier: Modifier = Modifier,
    day: Day,
    today: Int = LocalDate.now().dayOfMonth
) {
    val background = when {
        day.day < today -> Color(0xFFb6e86c)
        day.day == today -> Color(0xFF0b110c)
        else -> Color(0xFFf5f7f9)
    }
    val textColor = when {
        day.day < today -> Color(0xFF0b110c)
        day.day == today -> Color.White
        else -> Color(0xFF0b110c)
    }

    Box(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .width(55.dp)
            .height(65.dp)
            .clip(MaterialTheme.shapes.large)
            .background(background),
        contentAlignment = Alignment.Center

    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = day.day.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
            Text(
                text = day.dayOfWeek,
                style = MaterialTheme.typography.bodySmall,
                color = textColor
            )
        }
    }
}