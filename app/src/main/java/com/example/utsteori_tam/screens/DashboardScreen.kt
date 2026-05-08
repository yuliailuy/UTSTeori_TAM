package com.example.utsteori_tam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
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
import com.example.utsteori_tam.components.BottomNav
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.navigation.LocalNav
import tiket.KonserSource

@Composable
fun DashboardScreen() {

    val nav = LocalNav.current
    val data = KonserSource.listKonser

    var search by remember {
        mutableStateOf("")
    }

    val filtered = data.filter {
        it.nama.contains(search, true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color(0xFFF7F7F7))
            .padding(16.dp)
    ) {

        Text(
            "TicketNow",
            color = Color(0xFF8E2DE2),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = search,

            onValueChange = {
                search = it
            },

            placeholder = {
                Text("Search concerts...")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Explore",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (data.isNotEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {

                        val konser = data[0]

                        nav.navigate(
                            "detail/${konser.nama}"
                        )
                    }
            ) {

                Image(
                    painter = painterResource(data[0].imageRes),
                    contentDescription = null,

                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {

                    Text(
                        data[0].nama,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    GradientButton(
                        text = "Book Ticket"
                    ) {

                        val konser = data[0]

                        nav.navigate(
                            "detail/${konser.nama}"
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Popular Concerts",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {

            items(filtered) { konser ->

                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .padding(end = 12.dp)
                        .clickable {

                            nav.navigate(
                                "detail/${konser.nama}"
                            )
                        },

                    shape = RoundedCornerShape(16.dp)
                ) {

                    Column {

                        Image(
                            painter = painterResource(konser.imageRes),
                            contentDescription = null,

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),

                            contentScale = ContentScale.Crop
                        )

                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {

                            Text(
                                konser.nama,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                konser.lokasi,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNav(current = "home")
    }
}