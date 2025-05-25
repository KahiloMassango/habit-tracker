package com.example.habittracker.core.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.habittracker.core.model.Frequency

@Composable
fun FrequencySelector(
    modifier: Modifier = Modifier,
    selected: Frequency,
    onSelect: (Frequency) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Repeat",
            style = MaterialTheme.typography.bodyMedium ,
            color = Color(0xFF0b110c)
        )
        Row (
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xfff6f8fa))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
            ,
        ) {
            Frequency.entries.forEach { frequency ->
                key(frequency) {
                    FrequencyOption(
                        modifier = Modifier.weight(1f),
                        frequency = frequency,
                        selected = frequency == selected,
                        onClick = onSelect
                    )
                }
            }
        }
    }
}

@Composable
private fun FrequencyOption(
    modifier: Modifier = Modifier,
    frequency: Frequency,
    selected: Boolean,
    onClick: (Frequency) -> Unit,
) {
    val background by animateColorAsState(
        if (selected) Color.White else Color(0xfff6f8fa),
        label = "color"
    )
    val elevation by animateDpAsState(
        if(selected) 4.dp else 0.dp,
        label = "elevation"
    )
    val cornerShape = 10.dp
    Box(
        modifier = modifier
            .padding(6.dp)
            .shadow(elevation, RoundedCornerShape(cornerShape))
            .clip(RoundedCornerShape(cornerShape))
            .background(background, RoundedCornerShape(cornerShape))
            .clickable { onClick(frequency) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(12.dp),
            text = frequency.description,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

