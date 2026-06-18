package com.example.utsteori_tam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.R
import com.example.utsteori_tam.components.BottomNav
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.data.userTickets
import com.example.utsteori_tam.navigation.LocalNav
import tiket.KonserSource
import coil.compose.AsyncImage
import com.example.utsteori_tam.data.KonserRepository

@Composable
fun MyTicketScreen() {

    val nav = LocalNav.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Text(
            "My Tickets",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(userTickets) { ticket ->

                val konser =
                    KonserRepository.konserList.find {
                        it.nama == ticket.concertId
                    }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),

                    shape = RoundedCornerShape(20.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        AsyncImage(
                            model = konser?.imageUrl,
                            contentDescription = null,

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .clip(RoundedCornerShape(16.dp)),

                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            konser?.nama ?: "",
                            fontWeight = FontWeight.Bold
                        )

                        Text(ticket.ticketId)

                        Text(
                            "Seat : ${
                                ticket.seats.joinToString(", ")
                            }"
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        GradientButton(
                            text = "View Details"
                        ) {

                            val seatString =
                                ticket.seats.joinToString(",")

                            nav.navigate(
                                "ticketdetail/$seatString"
                            )
                        }
                    }
                }
            }
        }

        BottomNav(current = "myticket")
    }
}