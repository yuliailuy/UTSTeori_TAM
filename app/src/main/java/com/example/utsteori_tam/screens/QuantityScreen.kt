package com.example.utsteori_tam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.navigation.LocalNav
import tiket.KonserSource

@Composable
fun QuantityScreen(
    ticketId: String,
    concertId: String
) {

    val nav = LocalNav.current

    var qty by remember {
        mutableStateOf(1)
    }
    val konser =
        KonserSource.listKonser.find {
            it.nama == concertId
        }
    val (categoryName, price, categoryColor) =
        when(ticketId) {

            "CAT1" ->
                Triple(
                    "Near Stage",
                    3000000,
                    Color(0xFF8E2DE2)
                )
            "CAT2" ->
                Triple(
                    "Middle Area",
                    2000000,
                    Color(0xFFFF4DA6)
                )
            else ->
                Triple(
                    "Upper Area",
                    1200000,
                    Color(0xFFFF9800)
                )
        }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
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
            Text(
                "Choose Quantity",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Card(
            shape = RoundedCornerShape(20.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEDEAF5)
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {

                Image(
                    painter = painterResource(
                        konser?.imageRes
                            ?: android.R.drawable.ic_menu_gallery
                    ),

                    contentDescription = null,

                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(14.dp)),

                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {

                    Text(
                        konser?.nama ?: "",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        konser?.lokasi ?: "",
                        color = Color.Gray
                    )

                    Text(
                        konser?.tanggal ?: "",
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Card(
            shape = RoundedCornerShape(20.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEDEAF5)
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),

                horizontalArrangement =
                    Arrangement.SpaceBetween,

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                categoryColor,
                                RoundedCornerShape(12.dp)
                            )
                            .padding(
                                horizontal = 18.dp,
                                vertical = 12.dp
                            )
                    ) {

                        Text(
                            ticketId,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {

                        Text(
                            categoryName,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "Area",
                            color = Color.Gray
                        )
                    }
                }

                Text(
                    "Rp$price",
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Jumlah Tiket",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.Center,

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        Color.LightGray,
                        CircleShape
                    )
                    .clickable {

                        if (qty > 1) qty--
                    },

                contentAlignment = Alignment.Center
            ) {

                Text(
                    "-",
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                qty.toString(),

                modifier = Modifier.padding(
                    horizontal = 28.dp
                ),

                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        Color(0xFF8E2DE2),
                        CircleShape
                    )
                    .clickable {

                        if (qty < 6) qty++
                    },

                contentAlignment = Alignment.Center
            ) {

                Text(
                    "+",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Maksimal 6 tiket per transaksi",
            color = Color.Gray,

            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            "Total: Rp${qty * price}",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF8E2DE2),
                            Color(0xFFFF4DA6)
                        )
                    ),
                    shape = RoundedCornerShape(30.dp)
                )
                .clickable {

                    nav.navigate(
                        "checkout/$ticketId/$concertId/$qty"
                    )
                },

            contentAlignment = Alignment.Center
        ) {

            Text(
                "Continue",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}