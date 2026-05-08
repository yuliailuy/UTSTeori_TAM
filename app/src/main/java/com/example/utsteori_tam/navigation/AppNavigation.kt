package com.example.utsteori_tam.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.*

import com.example.utsteori_tam.screens.*

val LocalNav = compositionLocalOf<NavController> {
    error("No NavController")
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    CompositionLocalProvider(LocalNav provides navController) {

        NavHost(
            navController = navController,
            startDestination = "login"
        ) {

            composable("login") {
                LoginScreen()
            }
            composable("register") {
                RegisterScreen()
            }
            composable("home") {
                DashboardScreen()
            }
            composable("profile") {
                ProfileScreen()
            }

            composable("detail/{concertId}") {

                val id =
                    it.arguments?.getString("concertId") ?: ""

                ConcertDetailScreen(id)
            }

            composable("ticket/{concertId}") {

                val id =
                    it.arguments?.getString("concertId") ?: ""

                SelectTicketScreen(id)
            }

            composable("qty/{ticketId}/{concertId}") {

                val ticketId =
                    it.arguments?.getString("ticketId") ?: ""

                val concertId =
                    it.arguments?.getString("concertId") ?: ""

                QuantityScreen(ticketId, concertId)
            }

            composable("checkout/{ticketId}/{concertId}/{qty}") {

                val ticketId =
                    it.arguments?.getString("ticketId") ?: ""

                val concertId =
                    it.arguments?.getString("concertId") ?: ""

                val qty =
                    it.arguments?.getString("qty")?.toInt() ?: 1

                CheckoutScreen(ticketId, concertId, qty)
            }

            composable("myticket") {
                MyTicketScreen()
            }

            composable("ticketdetail/{ticketId}") {

                val id =
                    it.arguments?.getString("ticketId") ?: ""

                TicketDetailScreen(id)
            }
        }
    }
}