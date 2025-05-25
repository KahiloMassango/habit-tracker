package com.example.habittracker.features.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavController.navigateToHome()  = navigate(HomeRoute)

fun NavGraphBuilder.homeScreen(
    onAddHabitClick: () -> Unit
) {
    composable<HomeRoute> {
        HomeScreen(
            onAddHabitClick = onAddHabitClick
        )
    }
}