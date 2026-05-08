package com.example.utsteori_tam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.components.RowItem
import com.example.utsteori_tam.data.userTickets
import com.example.utsteori_tam.model.Ticket
import com.example.utsteori_tam.navigation.LocalNav
import com.example.utsteori_tam.utils.generateSeats
import tiket.KonserSource

@Composable
fun CheckoutScreen(
    ticketId: String,
    concertId: String,
    qty: Int
) {

    val nav = LocalNav.current

    val konser =
        KonserSource.listKonser.find {
            it.nama == concertId
        }

    val (categoryName, price) =
        when(ticketId) {

            "CAT1" ->
                "CAT 1 (Near Stage)" to 3000000

            "CAT2" ->
                "CAT 2 (Middle Area)" to 2000000

            else ->
                "CAT 3 (Upper Area)" to 1200000
        }

    val subtotal = price * qty
    val admin = 25000
    val total = subtotal + admin

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
                "Checkout",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Image(
                    painter = painterResource(
                        konser?.imageRes
                            ?: android.R.drawable.ic_menu_gallery
                    ),

                    contentDescription = null,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),

                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    konser?.nama ?: "",
                    fontWeight = FontWeight.Bold
                )

                Text(konser?.lokasi ?: "")
                Text(konser?.tanggal ?: "")

                Spacer(modifier = Modifier.height(16.dp))

                RowItem(
                    title = "Kategori",
                    value = categoryName
                )

                RowItem(
                    title = "Jumlah Tiket",
                    value = qty.toString()
                )

                RowItem(
                    title = "Subtotal",
                    value = "Rp$subtotal"
                )

                RowItem(
                    title = "Service Fee",
                    value = "Rp$admin"
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "Total : Rp$total",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                GradientButton(
                    text = "Pay Now"
                ) {

                    val seats =
                        generateSeats().take(qty)

                    userTickets.add(
                        Ticket(
                            ticketId,
                            concertId,
                            qty,
                            seats
                        )
                    )

                    nav.navigate("myticket")
                }
            }
        }
    }
}