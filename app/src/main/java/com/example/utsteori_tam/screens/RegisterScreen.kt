package com.example.utsteori_tam.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utsteori_tam.R
import com.example.utsteori_tam.components.GradientButton
import com.example.utsteori_tam.components.InputField
import com.example.utsteori_tam.navigation.LocalNav
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen() {

    val nav = LocalNav.current
    val context = LocalContext.current

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val snackbar = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            verticalArrangement = Arrangement.Center
        ) {

            Text(
                "TicketNow",
                color = Color(0xFF8E2DE2),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(R.drawable.konsero),
                contentDescription = null,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(20.dp)),

                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            InputField(
                value = nama,
                onChange = { nama = it },
                hint = "Username"
            )

            Spacer(modifier = Modifier.height(10.dp))

            InputField(
                value = email,
                onChange = { email = it },
                hint = "Email"
            )

            Spacer(modifier = Modifier.height(10.dp))

            InputField(
                value = password,
                onChange = { password = it },
                hint = "Password"
            )

            Spacer(modifier = Modifier.height(20.dp))

            GradientButton(
                text = "Sign Up"
            ) {

                val pref =
                    context.getSharedPreferences(
                        "USER",
                        Context.MODE_PRIVATE
                    )

                val oldData =
                    pref.getString("users", "") ?: ""

                val newUser =
                    "$nama|$email|$password"

                val updatedData =
                    if (oldData.isEmpty()) {
                        newUser
                    } else {
                        "$oldData;$newUser"
                    }

                pref.edit()
                    .putString("users", updatedData)
                    .apply()

                scope.launch {
                    snackbar.showSnackbar(
                        "Registrasi berhasil"
                    )
                }

                nav.navigate("login") {

                    popUpTo("register") {
                        inclusive = true
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Sudah punya akun? Login!",
                color = Color(0xFFFF4DA6),

                modifier = Modifier.clickable {
                    nav.popBackStack()
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            SnackbarHost(hostState = snackbar)
        }
    }
}