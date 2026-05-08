package com.example.utsteori_tam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.R
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.components.TicketItem
import com.example.utsteori_tam.navigation.LocalNav

@Composable
fun SelectTicketScreen(concertId: String) {

    val nav = LocalNav.current

    var selected by remember {
        mutableStateOf("")
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
                "Select Ticket",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(R.drawable.stage),
            contentDescription = null,

            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clip(RoundedCornerShape(20.dp)),

            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        TicketItem(
            title = "CAT 1",
            desc = "Near Stage",
            price = "Rp3.000.000",
            color = Color(0xFF8E2DE2),
            selected = selected == "CAT1"
        ) {
            selected = "CAT1"
        }

        TicketItem(
            title = "CAT 2",
            desc = "Middle Area",
            price = "Rp2.000.000",
            color = Color(0xFFFF4DA6),
            selected = selected == "CAT2"
        ) {
            selected = "CAT2"
        }

        TicketItem(
            title = "CAT 3",
            desc = "Upper Area",
            price = "Rp1.200.000",
            color = Color(0xFFFFA726),
            selected = selected == "CAT3"
        ) {
            selected = "CAT3"
        }

        Spacer(modifier = Modifier.weight(1f))

        GradientButton(
            text = "Continue"
        ) {

            if (selected.isNotEmpty()) {

                nav.navigate(
                    "qty/$selected/$concertId"
                )
            }
        }
    }
}