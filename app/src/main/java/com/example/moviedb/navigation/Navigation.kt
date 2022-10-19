package com.example.moviedb.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                toDetail = {imdbId ->
                    navController.navigate("moviedetail/$imdbId")
                }
            )
        }
        composable(
            route = "moviedetail/{imdbId}"
        ) {
            val imdbId = it.arguments?.getString("imdbId")
            Text(imdbId.orEmpty())
        }
    }
}