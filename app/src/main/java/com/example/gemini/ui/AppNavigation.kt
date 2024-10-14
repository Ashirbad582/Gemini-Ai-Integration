package com.example.gemini.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gemini.screens.chat.ChatScreen
import com.example.gemini.screens.Screens
import com.example.gemini.screens.settings.SettingScreen
import com.example.gemini.screens.home.HomeScreen


@Composable
fun AppNavigation(modifier: Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route, ) {
            HomeScreen(
                navController = navController,
                modifier = Modifier
            )
        }
        composable(Screens.Chat.route) {
            ChatScreen(
                navController = navController,
                modifier = Modifier
            )
        }
        composable(Screens.Settings.route) {
            SettingScreen(
                navController = navController,
                modifier = Modifier
            )
        }
    }
}





