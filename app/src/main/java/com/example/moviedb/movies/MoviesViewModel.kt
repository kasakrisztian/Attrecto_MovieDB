package com.example.moviedb.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.moviedb.data.domain.Movie
import com.example.moviedb.repository.movieRepository

class MoviesViewModel : ViewModel() {
    var items by mutableStateOf<List<Movie>>(emptyList())

    init {
        items = movieRepository.search("1")
    }
}