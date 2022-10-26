package com.example.moviedb.data.domain

data class Movie(
    val imdbId: String,
    val title: String,
    val released: Int,
    val poster: String,
    val plot: String? = "",
    val imdbRating: Float? = null
)
