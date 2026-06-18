package com.example.utsteori_tam.model

data class Konser(
    val id: String,
    val nama: String,
    val deskripsi: String,
    val lokasi: String,
    val tanggal: String,
    val harga: Int,
    val imageUrl: String
)