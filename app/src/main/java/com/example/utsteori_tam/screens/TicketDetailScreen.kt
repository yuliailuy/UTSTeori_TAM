package com.example.utsteori_tam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.R
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.navigation.LocalNav

@Composable
fun TicketDetailScreen(
    seats: String
) {

    val nav = LocalNav.current

    val seatList =
        remember(seats) {

            if (seats.isNotBlank()) {

                seats.split(",")
                    .filter {
                        it.isNotBlank()
                    }

            } else {
                emptyList()
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Row {

            IconButton(
                onClick = {
                    nav.popBackStack()
                }
            ) {

                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }

            Text(
                "My Tickets",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(seatList) { seat ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),

                    shape = RoundedCornerShape(20.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),

                        horizontalAlignment =
                            Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(
                                R.drawable.barcode
                            ),

                            contentDescription = null,

                            modifier = Modifier.size(200.dp),

                            contentScale = ContentScale.Fit
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            "Seat : $seat",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "Tunjukkan QR saat masuk venue",
                            color = Color.Gray
                        )
                    }
                }
            }
        }

        GradientButton(
            text = "Back Home"
        ) {
            nav.navigate("home")
        }
    }
}