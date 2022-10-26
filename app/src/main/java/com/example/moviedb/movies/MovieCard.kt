package com.example.moviedb.movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviedb.data.domain.Movie

@Composable
fun MovieCard(
    movie: Movie,
    onClick: () -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        //shape = RoundedCornerShape(10.dp),
        elevation = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = movie.poster,
                contentDescription = null,
                modifier = Modifier.size(width = 90.dp, height = 120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = movie.released.toString(),
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = movie.imdbId,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun Detail(movie: Movie) {
    Surface(
        shape = RoundedCornerShape(25.dp),
        elevation = 12.dp
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .width(120.dp)
        ) {
            Column(
                modifier = Modifier.width(120.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = movie.poster,
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 90.dp, height = 120.dp)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.body2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCard() {
    MovieCard(
        Movie(
            imdbId = "tt126565",
            title = "Star Wars",
            released = 1970,
            poster = ""
        ), onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun Detail() {
    Detail(
        Movie(
            imdbId = "tt121313",
            title = "Star Wars: Episode IV - A New Hope",
            released = 1970,
            poster = "https://m.media-amazon.com/images/I/61CYagANQEL._AC_SL1000_.jpg"
        )
    )
}