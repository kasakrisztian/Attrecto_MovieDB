package com.example.moviedb.movies

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviedb.R

//A composable egy függvény, de nagybetűvel szokás kezdeni!

//Órai rész
/*@Composable
fun MoviesScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(
            MaterialTheme.colors.background
        )
    ) {
        Text(
            text = "Movies",
            color = Color.Green
        )
        for (movie in 1..10) {
            Text(text = "Movie$movie")
        }
    }
}*/

@Composable
fun MoviesScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        MovieHeadline(
            painter = painterResource(id = R.drawable.batman),
            contentDescription = "The Batman movie poster",
            title = "The Batman"
        )
        MovieHeadline(
            painter = painterResource(id = R.drawable.harrypotter),
            contentDescription = "The Harry Potter and the philosopher's stone movie poster",
            title = "Harry Potter And The Philosopher's Stone"
        )
        MovieHeadline(
            painter = painterResource(id = R.drawable.transformers),
            contentDescription = "The Transformers movie poster",
            title = "The Transformers"
        )
        MovieHeadline(
            painter = painterResource(id = R.drawable.lotr),
            contentDescription = "The Lord of the Rings: The Fellowship of the Ring movie poster",
            title = "The Lord of the Rings: The Fellowship of the Ring"
        )
        MovieHeadline(
            painter = painterResource(id = R.drawable.sherlock),
            contentDescription = "Sherlock Holmes movie poster",
            title = "Sherlock Holmes"
        )
    }
}

@Composable
fun MovieHeadline(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Row() {
        Card(
            modifier = Modifier.padding(bottom = 5.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(150.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 14.sp,
            )
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