package com.example.habittracker.features.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.core.ui.theme.HabitTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HbtHomeTopBar(
    modifier: Modifier = Modifier,
    username: String,
    onCreateHabit: () -> Unit,
) {

    Row(
        modifier = modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        GreetingText(name = username)
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xff4e55e0))
                .size(40.dp)
                .clickable { onCreateHabit() },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    HabitTrackerTheme {
        HbtHomeTopBar(username = "Kahilo", onCreateHabit = {})
    }
}
