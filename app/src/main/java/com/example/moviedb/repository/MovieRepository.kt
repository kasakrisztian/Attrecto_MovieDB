package com.example.moviedb.repository

import com.example.moviedb.data.Network
import com.example.moviedb.data.domain.Movie
import com.example.moviedb.data.domain.MovieDto

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
        return api.searchMovies(pattern).movies.map { movieDto ->
            movieDto.toMovie()
        }
    }

    suspend fun searchByImdbId(imdbId: String) : Movie {
        return api.searchByImdbId(imdbId).toMovie()
    }
}

fun MovieDto.toMovie() = Movie(
    imdbId = imdbId,
    title = title,
    released = year.toInt(),
    poster = poster,
    imdbRating = imdbRating,
    plot = plot
)