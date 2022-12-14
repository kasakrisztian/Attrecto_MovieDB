package com.example.moviedb.data

import com.example.moviedb.data.domain.MovieDto
import com.example.moviedb.data.domain.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET(".")
    suspend fun searchMovies(
        @Query("s") searchTerm: String,
        @Query("apikey") apikey: String = "17cdc959",
        @Query("type") type: String = "movie"
    ): MovieListDto

    @GET(".")
    suspend fun searchByImdbId(
        @Query("i") imdbId: String,
        @Query("apikey") apikey: String = "17cdc959"
    ): MovieDto
}