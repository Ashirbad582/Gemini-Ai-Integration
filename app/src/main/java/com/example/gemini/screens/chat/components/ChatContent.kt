package com.example.gemini.screens.chat.components


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gemini.R
import com.example.gemini.screens.chat.MessageModel

@Composable
fun ChatContent(
    messageList: MutableList<MessageModel>,
    modifier: Modifier
) {

    if (messageList.isNotEmpty()) {
        LazyColumn(
            reverseLayout = true,
            modifier = modifier
                .padding(10.dp)
                .animateContentSize(
                    animationSpec = tween(durationMillis = 1000)
                ),
        ) {
            items(items = messageList.reversed()) { message ->
                MessageItem(messageModel = message)
            }
        }
    } else {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.baseline_chat_24),
                    tint = colorResource(R.color.light_green),
                    contentDescription = null
                )

                Text(
                    text = "No messages yet",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                )

            }
        }
    }
}