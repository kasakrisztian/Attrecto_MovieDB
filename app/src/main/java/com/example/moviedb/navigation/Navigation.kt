package com.example.moviedb.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviedb.movie.MovieDetailScreen
import com.example.moviedb.movies.MoviesScreen

@Composable
fun Navigation(navController: NavHostController) {
    //Képernyők közti navigálásra kell a navigation
    //Érdemes külön fájlba rendezni nagyobb projektek esetén
    //Minden egyes composable egy külön screen

    NavHost(
        navController = navController,
        startDestination = "movielist"
    ) {
        composable(
            route = "movielist"
        ) {
            MoviesScreen(
                modifier = Modifier.fillMaxSize(),
                toDetail = {imdbId, searchKeyword ->
                    navController.navigate("moviedetail/$imdbId/$searchKeyword")
                }
            )
        }
        composable(
            route = "moviedetail/{imdbId}/{searchKeyword}"
        ) {
            val imdbId = it.arguments?.getString("imdbId")
            val searchKeyword = it.arguments?.getString("searchKeyword")
            MovieDetailScreen(
                imdbId = imdbId.orEmpty(),
                searchKeyword.orEmpty(),
                toDetail = {imdbId, searchKeyword ->
                    navController.navigate("moviedetail/$imdbId/$searchKeyword")
                }
            )
        }
    }
}