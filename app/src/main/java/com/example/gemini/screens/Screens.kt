package com.example.gemini.screens

sealed class Screens(
    val route :String
) {
    data object Home: Screens("home")
    data object Chat: Screens("chat")
    data object Settings: Screens("settings")
}