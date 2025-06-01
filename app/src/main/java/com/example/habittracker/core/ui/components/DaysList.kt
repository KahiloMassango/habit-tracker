package com.example.habittracker.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DaysList(
    modifier: Modifier = Modifier,
    days: List<Day> = getSurroundingDays()
) {
    val scrollState = rememberLazyListState(LocalDate.now().hashCode())
    LazyRow(
        modifier = modifier,
        state = scrollState,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(days, { it.date.hashCode() }) { day ->
            DayItem(day = day)
        }
    }
}


@Composable
private fun DayItem(
    modifier: Modifier = Modifier,
    day: Day,
    today: LocalDate = LocalDate.now()
) {
    val isFirstDay = day.date.dayOfMonth == 1
    val background = when {
        day.date.isBefore(today) -> Color(0xFFb6e86c)
        day.date == today -> Color(0xFF0b110c)
        else -> Color(0xFFf5f7f9)
    }
    val textColor = when {
        day.date.isBefore(today) -> Color(0xFF0b110c)
        day.date == today -> Color.White
        else -> Color(0xFF0b110c)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                    text = day.date.dayOfMonth.toString(),
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
        if (isFirstDay) {
            Text(
                text = day.date.month.getDisplayName(TextStyle.FULL, Locale.getDefault()), // e.g. "June"
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp),
                color = Color(0xFF0b110c)
            )
        }
    }
}


fun getSurroundingDays(range: Int = 4): List<Day> {
    val today = LocalDate.now()
    val locale = Locale.getDefault()

    return (-range..range).map { offset ->
        val date = today.plusDays(offset.toLong())
        val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.SHORT, locale) // e.g., "Mon"
        Day(date, dayOfWeek)
    }
}
