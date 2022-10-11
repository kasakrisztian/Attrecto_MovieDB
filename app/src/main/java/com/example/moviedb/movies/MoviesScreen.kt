package com.example.moviedb.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviedb.data.domain.Movie

//A composable egy függvény, de nagybetűvel szokás kezdeni!
@Composable
fun MoviesScreen(modifier: Modifier = Modifier) {
    val viewModel : MoviesViewModel = viewModel()
    val movies = viewModel.items
    //Hasonlóan működik, mint a RecyclerView
    LazyColumn(modifier = modifier.background(MaterialTheme.colors.background)) {
        item {
            Text(
                text = "Movies",
                color = Color.Green
            )
        }
        items(items = movies, {it.id}) {
            MovieCard(it)
        }
    }
}

@Composable
fun MovieCard(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Text(text = movie.title)

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