package com.example.gemini.screens.chat.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.gemini.R


@Composable
fun MessageView(
    onSend: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var message by remember {
        mutableStateOf("")
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            placeholder = {
                Text(
                    text = "Enter something....",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Send,
                    tint = colorResource(R.color.light_green),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        if (message.isNotEmpty()) {
                            onSend(message)
                            message = ""
                        }
                    })
            },
            shape = RoundedCornerShape(20),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedPlaceholderColor = Color.Gray,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
        )
    }
}