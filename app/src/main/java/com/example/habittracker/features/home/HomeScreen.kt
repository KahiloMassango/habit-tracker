package com.example.habittracker.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.core.ui.components.DaysList
import com.example.habittracker.core.ui.theme.HabitTrackerTheme
import com.example.habittracker.features.home.component.HabitDetailModal
import com.example.habittracker.features.home.component.HabitsCardGrid
import com.example.habittracker.features.home.component.HbtBottomBar
import com.example.habittracker.features.home.component.HbtHomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAddHabitClick: () -> Unit,
) {
    var showDetailModal by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color.White,
        topBar = { HbtHomeTopBar(username = "Diana", onCreateHabit = onAddHabitClick) },
        bottomBar = {
            HbtBottomBar(
                onProfileClick = {}
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize(),
            color = Color.White,
            contentColor = Color(0xFF0b110c)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                DaysList()
                Spacer(Modifier.height(18.dp))
                HabitsCardGrid(
                    onCardClick = { showDetailModal = true }
                )
            }
        }

        if (showDetailModal) {
            HabitDetailModal(
                onDone = { showDetailModal = false },
                onDismissRequest = { showDetailModal = false }
            )
        }
    }
}


@Preview
@Composable
private fun Preview() {
    HabitTrackerTheme {
        HomeScreen(
            onAddHabitClick = {}
        )

    }
}