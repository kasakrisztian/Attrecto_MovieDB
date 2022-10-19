package com.example.moviedb.data.domain

import com.squareup.moshi.Json

data class MovieListDto (
    @Json(name = "Search")
    val movies: List<MovieDto>
)

data class MovieDto(
    @Json(name = "Title")
    val title: String,
    @Json(name = "Year")
    val year: String,
    @Json(name = "imdbId")
    val imdbId: String,
    @Json(name = "Type")
    val type: String,
    @Json(name = "Poster")
    val poster: String,
)