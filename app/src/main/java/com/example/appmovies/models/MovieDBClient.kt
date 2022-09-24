package com.example.appmovies.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieDBClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(MovieDBServices::class.java)
}
