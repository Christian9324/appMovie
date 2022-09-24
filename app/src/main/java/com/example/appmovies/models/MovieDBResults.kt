package com.example.appmovies.models

data class MovieDBResults(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
