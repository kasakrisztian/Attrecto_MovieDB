package com.example.moviedb.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

//A composable egy függvény, de nagybetűvel szokás kezdeni!
@Composable
fun MoviesScreen(modifier: Modifier = Modifier) {
    val viewModel: MoviesViewModel = viewModel()
    val movies = viewModel.items
    Scaffold(topBar = {
        TopAppBar(title = { Text("Movie list") })
    }) {
        Column() {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = viewModel.searchTerm,
                    onValueChange = {
                        viewModel.searchTerm = it
                    },
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { viewModel.search() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }
            //Hasonlóan működik, mint a RecyclerView
            LazyColumn(
                modifier = modifier.background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(items = movies, { it.imdbId }) {
                    MovieCard(it)
                }
            }
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