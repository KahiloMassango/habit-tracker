package com.example.habittracker.features.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object WelcomeRoute

fun NavGraphBuilder.welcomeScreen(
    onGetStarted: () -> Unit
) {
    composable<WelcomeRoute> {
        WelcomeScreen(
            onGetStarted = onGetStarted
        )
    }
}