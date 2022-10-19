package com.example.moviedb.repository

import com.example.moviedb.data.Network
import com.example.moviedb.data.domain.Movie
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

val movieRepository = MovieRepository()

class MovieRepository {
    /*private val movies = (1..100).map {
        dummyMovieOfNumber(it)
    }

    private fun dummyMovieOfNumber(i: Int) =  Movie(
        imdbId = UUID.randomUUID().toString(),
        "Movie#$i",
        Random.nextInt(1950, 2022),
        poster = "https://picsum.photos/90/120"
    )*/
    val api = Network.provideMoviesApi()

    suspend fun search(pattern: String): List<Movie>{
        return api.searchMovies(pattern).movies.map { movideDto ->
            Movie(
                imdbId = movideDto.imdbId,
                title = movideDto.title,
                released = movideDto.year.toInt(),
                poster = movideDto.poster
            )
        }
    }
}