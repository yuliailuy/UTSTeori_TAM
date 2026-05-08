package com.example.utsteori_tam.utils

fun generateSeats(): List<String> {

    val seats = mutableListOf<String>()

    val cat1Rows = listOf('A', 'B')

    val cat1PerRow = 100 / cat1Rows.size

    for (row in cat1Rows) {
        for (i in 1..cat1PerRow) {
            seats.add("$row$i")
        }
    }

    val cat2Rows = listOf('C', 'D', 'E')

    val cat2PerRow = 250 / cat2Rows.size

    for (row in cat2Rows) {
        for (i in 1..cat2PerRow) {
            seats.add("$row$i")
        }
    }

    val cat3Rows = listOf('F', 'G', 'H', 'I', 'J')

    val cat3PerRow = 500 / cat3Rows.size

    for (row in cat3Rows) {
        for (i in 1..cat3PerRow) {
            seats.add("$row$i")
        }
    }

    return seats.shuffled()
}