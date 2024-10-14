package com.example.gemini.screens.chat.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.gemini.R
import com.example.gemini.screens.chat.MessageModel


@Composable
fun MessageItem(messageModel: MessageModel) {
    val isModel = messageModel.role == "model"

    SelectionContainer {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = if (isModel) 8.dp else 40.dp,
                    end = if (isModel) 40.dp else 8.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                contentAlignment = if (isModel) Alignment.BottomStart else Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            if (isModel) colorResource(R.color.light_blue) else colorResource(R.color.light_green),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp)
                ) {
                    Column(modifier = Modifier) {
                        Text(
                            text = messageModel.message, color = Color.White
                        )
                    }
                }
            }
        }
    }
}