package com.example.habittracker.features.new_habit

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object NewHabitRoute

fun NavController.navigateToNewHabit() = navigate(NewHabitRoute)

fun NavGraphBuilder.newHabitScreen(
    onNavigateUp: () -> Unit,
) {
    composable<NewHabitRoute> {
        NewHabitScreen(
            onNavigateUp = onNavigateUp
        )
    }
}