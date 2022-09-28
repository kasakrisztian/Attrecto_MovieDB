package com.example.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.moviedb.movies.MoviesScreen
import com.example.moviedb.ui.theme.MovieDBTheme

//Egy activity és a composeable-kből áll össze.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDBTheme {
                // A surface container using the 'background' color from the theme
                //Ide kerülnek majd az alkalmazás "képernyői".

                MoviesScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}