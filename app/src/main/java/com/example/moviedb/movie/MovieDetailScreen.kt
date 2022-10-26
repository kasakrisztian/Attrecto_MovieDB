package com.example.moviedb.movie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun MovieDetailScreen(imdbId: String, searchKeyword: String, toDetail: (String, String) -> Unit) {
    val viewModel: MovieDetailViewModel = viewModel()

    val movie = viewModel.movie
    LaunchedEffect(key1 = imdbId) {
        viewModel.search(searchKeyword)
        viewModel.searchById(imdbId)
    }
    movie?.let {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Row(modifier = Modifier.padding(horizontal = 8.dp)) {
                AsyncImage(
                    model = movie.poster,
                    contentDescription = "Movie poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(width = 250.dp, 400.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    LabelValue(label = "Year", value = movie.released.toString())
                    Spacer(modifier = Modifier.height(8.dp))
                    LabelValue(label = "IMDB ID", value = movie.imdbId)
                    Spacer(modifier = Modifier.height(8.dp))
                    LabelValue(label = "IMDB Rating", value = movie.imdbRating.toString())
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.title,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            movie.plot?.let {
                Text(text = movie.plot)
            }

            Spacer(modifier = Modifier.height(24.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
                items(viewModel.items) {
                    MovieIconCard(title = it.title, poster = it.poster, onClick = {
                        toDetail(it.imdbId, searchKeyword)
                    })
                }
            }
        }
    }
}


@Composable
fun LabelValue(label: String, value: String) {
    Column() {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailScreen(imdbId = "tesztId", "",)
}