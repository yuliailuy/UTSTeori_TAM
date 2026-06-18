package com.example.utsteori_tam.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClients {

    private const val BASE_URL =
        "https://gist.githubusercontent.com/yuliailuy/863adc47fb272022729af94b631cbc5a/raw/d42b1dc6e65657023d78e2df15aa2a4e2a529f78/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}