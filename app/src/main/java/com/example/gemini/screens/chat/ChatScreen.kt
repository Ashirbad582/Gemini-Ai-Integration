package com.example.gemini.screens.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gemini.screens.Screens
import com.example.gemini.screens.chat.components.ChatContent
import com.example.gemini.screens.chat.components.MessageView

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ChatViewModel = viewModel()
) {


    val messageList = viewModel.messageList

    Scaffold(topBar = {
        ChatTopBar(
            onClickBack = {
                navController.navigateUp()
            },

            onClickSettings = {
                navController.navigate(Screens.Settings.route)
            }
        )
    }) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            ChatContent(
                messageList = messageList,
                modifier = modifier
                    .weight(1f)

            )

            MessageView(
                onSend = { message ->
                    viewModel.sendMessage(message)
                },
                modifier = Modifier,
            )
        }
    }
}





