package com.example.moviedb.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.domain.Movie
import com.example.moviedb.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieDetailViewModel: ViewModel() {
    private val repository = MovieRepository()
    var movie by mutableStateOf<Movie?>(null)

    val items = mutableStateListOf<Movie>()

    fun search(searchTerm: String) {
        viewModelScope.launch {
            items.addAll(repository.search(searchTerm).filter{ it != movie })
        }
    }

    fun searchById(imdbId: String) {
        viewModelScope.launch {
            movie = repository.searchByImdbId(imdbId)
        }
    }
}