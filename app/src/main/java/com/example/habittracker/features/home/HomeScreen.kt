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
import com.example.habittracker.core.theme.HabitTrackerTheme
import com.example.habittracker.features.home.component.HabitDetailModal
import com.example.habittracker.features.home.component.AddHabitModal
import com.example.habittracker.features.home.component.DaysList
import com.example.habittracker.features.home.component.HabitsCardGrid
import com.example.habittracker.features.home.component.HbtBottomBar
import com.example.habittracker.features.home.component.HbtHomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    var showAddModal by remember { mutableStateOf(false) }
    var showDetailModal by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color.White,
        topBar = { HbtHomeTopBar(username = "Diana", onNotificationClick = {}) },
        bottomBar = {
            HbtBottomBar(
                onAddHabitClick = { showAddModal = true },
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
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                DaysList()
                Spacer(Modifier.height(18.dp))
                HabitsCardGrid(
                    onCardClick = { showDetailModal = true }
                )
            }
        }

        if (showAddModal) {
            AddHabitModal(
                onSave = { showAddModal = false },
                onDismissRequest = { showAddModal = false }
            )
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
        HomeScreen()

    }
}