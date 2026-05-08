package com.example.utsteori_tam.model

data class Ticket(
    val ticketId: String,
    val concertId: String,
    val qty: Int,
    val seats: List<String>
)