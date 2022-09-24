package com.example.appmovies.models

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBServices {

    @GET("movie/popular")
    suspend fun listPopularMovies(@Query("api_key") apiKey : String) : MovieDBResults
}