package com.example.moviedb.repository

import com.example.moviedb.data.domain.Movie
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

val movieRepository = MovieRepository()

class MovieRepository {
    private val movies = (1..100).map {
        dummyMovieOfNumber(it)
    }

    fun search(pattern: String = "") : List<Movie> {
        return movies.filter { movie ->
            movie.title.contains(pattern)
        }
    }

    private fun dummyMovieOfNumber(i: Int) =  Movie(
        imdbId = UUID.randomUUID().toString(),
        "Movie#$i",
        Random.nextInt(1950, 2022),
        poster = "https://picsum.photos/90/120"
    )

    /*private fun dummyMovieOfNumber(i: Int) = Movie(
        i.toString(),
        "movie $i",
        Random.nextInt(1950, 2022),
        ""
    )*/
}