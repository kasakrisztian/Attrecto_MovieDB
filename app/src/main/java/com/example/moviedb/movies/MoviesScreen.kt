package com.example.moviedb.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

//A composable egy függvény, de nagybetűvel szokás kezdeni!
//Házi - Movie card composable

@Composable
fun MoviesScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(MaterialTheme.colors.background
    )) {
        Text(
            text = "Movies",
            color = Color.Green
        )
        for (movie in 1..10) {
            Text(text = "Movie$movie" )
        }
    }

}



//Előnézetet is tudunk készíteni, akár többet is. 
// Ez szuper hasznos, ha meg szeretnénk nézni, hogy a kész composable-k hogy néznek ki.
@Preview
@Composable
fun MoviesScreenPreview() {
    MoviesScreen()
}