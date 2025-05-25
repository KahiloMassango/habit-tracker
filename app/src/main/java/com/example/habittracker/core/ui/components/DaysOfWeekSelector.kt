package com.example.habittracker.core.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.core.model.DayOfWeek

@Composable
fun DaysOfWeekSelector(
    modifier: Modifier = Modifier,
    selectedDays: Set<DayOfWeek>,
    enabled: Boolean,
    onSelect: (DayOfWeek) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "On these days",
            style = MaterialTheme.typography.bodyMedium ,
            color = Color(0xFF0b110c)
        )
        Row (
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            ,
        ) {
            DayOfWeek.entries.forEach { day ->
                key(day) {
                    DayOfWeekOption(
                        modifier = Modifier.weight(1f),
                        day = day,
                        selected = day in selectedDays,
                        enabled = enabled,
                        onClick = {
                            if(selectedDays.size  <= 5) onSelect(it)
                        }
                    )
                }
            }
        }
    }
}


@Composable
private fun DayOfWeekOption(
    modifier: Modifier = Modifier,
    day: DayOfWeek,
    selected: Boolean,
    enabled: Boolean,
    onClick: (DayOfWeek) -> Unit,
) {
    val background by animateColorAsState(
        when {
            !enabled -> Color(0xFFCCCCCC)
            selected -> Color(0xff4e55e0)
            else -> Color(0xfff6f8fa)
        },
        label = "background"
    )

    val textColor by animateColorAsState(
        when {
            !enabled -> Color(0xFF0b110c)
            selected -> Color.White
            else -> Color(0xFF0b110c)
        },
        label = "textColor"
    )

    Box(
        modifier = modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(background, CircleShape)
            .clickable(enabled = enabled) { onClick(day) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.description,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 10.sp,
            color = textColor
        )
    }
}

