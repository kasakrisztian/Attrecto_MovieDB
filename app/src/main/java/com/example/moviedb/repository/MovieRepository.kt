package com.example.moviedb.repository

import com.example.moviedb.data.domain.Movie
import kotlin.random.Random

val movieRepository = MovieRepository()

class MovieRepository {
    private val movies = (0..10000).map {
        dummyMovieOfNumber(it)
    }

    fun search(pattern: String = "") : List<Movie> {
        return movies.filter { movie ->
            movie.title.contains(pattern)
        }
    }

    private fun dummyMovieOfNumber(i: Int) =  Movie(i.toString(), "movie $i", Random.nextInt(1950, 1980))
}