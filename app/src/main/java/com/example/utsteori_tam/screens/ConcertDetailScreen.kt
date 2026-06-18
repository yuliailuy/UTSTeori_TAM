package com.example.utsteori_tam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.navigation.LocalNav
import tiket.KonserSource
import coil.compose.AsyncImage
import com.example.utsteori_tam.data.KonserRepository
@Composable
fun ConcertDetailScreen(concertId: String) {

    val nav = LocalNav.current

    val konser =
        KonserRepository.konserList.find {
            it.nama == concertId
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

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

        Spacer(modifier = Modifier.height(12.dp))

        AsyncImage(
            model = konser?.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            konser?.nama ?: "",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("📍 ${konser?.lokasi}")
        Text("📅 ${konser?.tanggal}")
        Text("⏰ 18:00 WIB")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Detail Event",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(konser?.deskripsi ?: "")

        Spacer(modifier = Modifier.height(30.dp))

        GradientButton(
            text = "Select Ticket"
        ) {
            nav.navigate("ticket/${konser?.nama}")
        }
    }
}