package com.example.utsteori_tam.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.navigationBarsPadding
import com.example.utsteori_tam.navigation.LocalNav

@Composable
fun BottomNav(current: String) {

    val nav = LocalNav.current

    val active = Color(0xFF8E2DE2)
    val inactive = Color.Gray

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 12.dp)
            .background(
                Color.White,
                RoundedCornerShape(20.dp)
            )
            .padding(12.dp)
            .navigationBarsPadding(),

        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.clickable {
                nav.navigate("home")
            }
        ) {

            Icon(
                Icons.Default.Home,
                contentDescription = null,
                tint = if (current == "home") active else inactive
            )

            Text(
                "Beranda",
                color = if (current == "home") active else inactive
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.clickable {
                nav.navigate("myticket")
            }
        ) {

            Icon(
                Icons.Default.ConfirmationNumber,
                contentDescription = null,
                tint = if (current == "myticket") active else inactive
            )

            Text(
                "My Tickets",
                color = if (current == "myticket") active else inactive
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.clickable {
                nav.navigate("profile")
            }
        ) {

            Icon(
                Icons.Default.Person,
                contentDescription = null,
                tint = if (current == "profile") active else inactive
            )

            Text(
                "Profile",
                color = if (current == "profile") active else inactive
            )
        }
    }
}