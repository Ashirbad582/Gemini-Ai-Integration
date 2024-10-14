package com.example.gemini.screens.chat

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {


    val messageList by lazy { mutableStateListOf<MessageModel>() }

    val generativeModel: GenerativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = Constants.API_KEY
    )

    fun sendMessage(message: String) {

        viewModelScope.launch(Dispatchers.IO) {
            Log.d("chatViewmodel", "logged $message")
            try {

                val chat = generativeModel.startChat(history = messageList.map {
                    content(it.role) {
                        text(it.message)
                    }
                }.toList())
                messageList.add(MessageModel(message = message, role = "user"))
                messageList.add(MessageModel(message = "typing..", role = "model"))
                val response = chat.sendMessage(message)
                messageList.removeLastOrNull()
                Log.d("chatViewmodel", "logged ${response.text.toString()}")
                messageList.add(MessageModel(message = response.text.toString(), role = "model"))
                Log.d("chatViewmodel", "printed ${response.text.toString()}")

            } catch (e: Exception) {
                messageList.add(MessageModel(message = e.message.toString(), role = "model"))
            }
        }
    }
}
