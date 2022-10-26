package com.example.moviedb.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.domain.Movie
import com.example.moviedb.repository.MovieRepository
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    private val repository = MovieRepository()

    var items by mutableStateOf<List<Movie>>(emptyList())
    var error by mutableStateOf<Throwable?>(null)
    var loading by mutableStateOf(false)

    var searchTerm by mutableStateOf("Movie")

    init {
        search()
    }

    fun search() {
        viewModelScope.launch {
            loading = true
            try {
                items = repository.search(searchTerm)
                error = null
            } catch (e: Exception) {
                error = Throwable(e.message)
            }
        }
    }
}