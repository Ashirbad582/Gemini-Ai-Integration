package com.example.gemini.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.gemini.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onClickSettings: () -> Unit) {

    TopAppBar(
        title = {},
        navigationIcon = {

            val brush = Brush.horizontalGradient(
                listOf(
                    colorResource(R.color.black),
                    colorResource(R.color.purple_500),
                    colorResource(R.color.purple_700),
                    colorResource(R.color.purple_500),
                    colorResource(R.color.purple_700),
                    colorResource(R.color.purple_500),
                    colorResource(R.color.black),
                )
            )
            Text(
                text = "Gemini",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.textBrush(brush)
            )

        },
        actions = {
            Icon(
                imageVector = Icons.Default.Settings,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp),
                contentDescription = null,
            )
        },
        colors = TopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.primary,
            actionIconContentColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.primary,
            scrolledContainerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.light_green),
                        colorResource(R.color.light_yellow),
                    )
                )
            )
            .clickable { onClickSettings() }
    )
}


fun Modifier.textBrush(brush: Brush) = this
    .graphicsLayer(alpha = 0.99f)
    .drawWithCache {
        onDrawWithContent {
            drawContent()
            drawRect(brush, blendMode = BlendMode.SrcAtop)
        }
    }