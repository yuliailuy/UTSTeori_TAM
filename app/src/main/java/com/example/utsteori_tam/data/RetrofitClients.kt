package com.example.utsteori_tam.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClients {

    private const val BASE_URL =
        "https://gist.githubusercontent.com/yuliailuy/863adc47fb272022729af94b631cbc5a/raw/41df371b3e91030f6141153c07af67c13d395912/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}