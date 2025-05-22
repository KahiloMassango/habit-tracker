package com.example.habittracker

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.habittracker.features.authentication.WelcomeRoute
import com.example.habittracker.features.authentication.welcomeScreen
import com.example.habittracker.features.home.homeScreen
import com.example.habittracker.features.home.navigateToHome

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = WelcomeRoute
    ) {
        welcomeScreen(
            onGetStarted = { navController.navigateToHome() }
        )

        homeScreen()
    }

}