package com.example.utsteori_tam.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TicketItem(
    title: String,
    desc: String,
    price: String,
    color: Color,
    selected: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor =
                if (selected)
                    Color(0xFFEDE7F6)
                else
                    Color(0xFFE0E0E0)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(40.dp)
                        .background(
                            color,
                            RoundedCornerShape(10.dp)
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {

                    Text(
                        desc,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "Area",
                        color = Color.Gray
                    )
                }
            }

            Text(
                price,
                fontWeight = FontWeight.Bold
            )
        }
    }
}