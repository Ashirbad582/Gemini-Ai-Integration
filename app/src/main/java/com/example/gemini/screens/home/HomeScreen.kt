package com.example.gemini.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gemini.R
import com.example.gemini.screens.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(modifier: Modifier, navController: NavHostController) {

    Scaffold(topBar = {
        HomeTopBar {
            navController.navigate(Screens.Settings.route)
        }
    }) {
        val description by remember {
            mutableStateOf(
                "Gemini AI, developed by Google DeepMind, represents a significant advancement in artificial intelligence, offering powerful multimodal capabilities. This means it can process and understand text, images, audio, and more, making it particularly skilled at reasoning about complex topics like math and physics. It is also proficient in tasks like coding, performing at state-of-the-art levels across multiple programming languages such as Python, Java, and C++.\n" +
                        "\n" +
                        "Gemini AI's architecture, especially in its latest 1.5 version, is designed for efficiency and scalability. It features a long-context window of up to 1 million tokens, allowing it to handle vast amounts of information, a breakthrough in long-context understanding. This positions Gemini AI as a frontrunner in applications requiring advanced reasoning and large-scale data processing, including scientific research and business tasks.\n" +
                        "\n" +
                        "Additionally, Gemini AI incorporates advanced safety protocols and ethics testing to ensure responsible deployment. As it evolves, it promises to empower developers and businesses by enabling faster, more effective AI-driven solutions."
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp), // Vertical spacing between items
            modifier = modifier
                .padding(it)
                .padding(10.dp)

        ) {

            item {
                Text(
                    text = "About Gemini",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }

            item {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }

            item() {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 10.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.light_green),
                                    colorResource(R.color.light_yellow),
                                )
                            ),
                            shape = RoundedCornerShape(10)
                        )
                        .clickable {
                            navController.navigate(Screens.Chat.route)
                        }, // Item size
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(text = "Start New Chat")
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}


