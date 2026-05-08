package com.example.utsteori_tam.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    value: String,
    onChange: (String) -> Unit,
    hint: String
) {

    OutlinedTextField(
        value = value,

        onValueChange = onChange,

        placeholder = {
            Text(hint)
        },

        shape = RoundedCornerShape(16.dp),

        modifier = Modifier.fillMaxWidth()
    )
}