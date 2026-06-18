package com.example.utsteori_tam.data

import com.example.utsteori_tam.model.Konser
import retrofit2.http.GET

interface ApiService {

    @GET("konser.json")
    suspend fun getKonser(): List<Konser>

}