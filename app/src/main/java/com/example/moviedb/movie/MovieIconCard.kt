package com.example.moviedb.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun MovieIconCard(title : String, poster : String, onClick: () -> Unit) {
    Surface(shape= RoundedCornerShape(6.dp),
        elevation = 4.dp,
        modifier = Modifier.size(95.dp, height = 135.dp)
            .clickable(onClick = onClick)

    ) {
        Column(modifier = Modifier
            .padding(vertical = 6.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = poster, contentDescription = null,
                modifier = Modifier
                    .size(width = 75.dp, height = 80.dp)
                    .clip((RoundedCornerShape(12.dp))),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 80.dp)
            )
        }
    }
}