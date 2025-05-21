package com.example.habittracker.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.core.theme.HabitTrackerTheme
import com.example.habittracker.features.home.component.DaysList
import com.example.habittracker.features.home.component.HabitsCardGrid
import com.example.habittracker.features.home.component.HomeTopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.White,
        contentColor = Color(0xFF0b110c)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            HomeTopBar(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            DaysList()
            Spacer(Modifier.height(18.dp))
            HabitsCardGrid()
        }
    }
}



@Preview
@Composable
private fun Preview() {
    HabitTrackerTheme {
        HomeScreen()

    }
}