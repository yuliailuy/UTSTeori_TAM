package com.example.utsteori_tam.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.R
import com.example.utsteori_tam.components.BottomNav
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.navigation.LocalNav

@Composable
fun ProfileScreen() {

    val nav = LocalNav.current
    val context = LocalContext.current

    val pref = context.getSharedPreferences(
        "USER",
        Context.MODE_PRIVATE
    )

    val currentUser =
        pref.getString("currentUser", "")
            ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
    ) {


        Box {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFF8E2DE2),
                                Color(0xFFFF4DA6)
                            )
                        ),
                        shape = RoundedCornerShape(
                            bottomStart = 40.dp,
                            bottomEnd = 40.dp
                        )
                    )
            )

            IconButton(
                onClick = {
                    nav.popBackStack()
                },

                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
            ) {

                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Text(
                text = "Profile",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 16.dp)
            )

            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 65.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(90.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Nama",
                color = Color(0xFF8E2DE2)
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = currentUser,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Divider()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Email",
                color = Color(0xFFFF4DA6)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$currentUser@gmail.com",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(26.dp))
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEDEAF5)
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .background(
                                Color(0xFFE6B4CF),
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Ubah Foto Profil",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Pilih foto baru untuk akun kamu",

                            color = Color.Gray
                        )
                    }
                    Text(
                        text = ">",
                        color = Color.Gray
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {

            GradientButton(
                text = "Logout"
            ) {
                pref.edit()
                    .remove("currentUser")
                    .apply()

                nav.navigate("login") {
                    popUpTo("home") {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        BottomNav(current = "profile")
    }
}