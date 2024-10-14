package com.example.gemini.screens.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.gemini.screens.Screens

@Composable
fun SettingScreen(modifier: Modifier, navController: NavHostController) {


    Scaffold(topBar = {
        SettingsTopBar(
            onClickBack = {
                navController.navigateUp()
            },

            onClickSettings = {
                navController.navigate(Screens.Settings.route)
            }
        )
    }) {
        Text("", modifier.padding(it))
    }
}