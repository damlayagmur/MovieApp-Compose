package com.damlayagmur.movieapp.presentation.moviedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.damlayagmur.movieapp.data.model.moviedetail.Genre
import com.damlayagmur.movieapp.presentation.theme.MovieDetailGenreColor
import com.damlayagmur.movieapp.presentation.theme.SplashBackground

@Composable
fun MovieDetailItem(
    genre: Genre,
) {

    Card(
        modifier = Modifier
            .height(25.dp)
            .padding(15.dp, 0.dp, 15.dp, 0.dp),
        backgroundColor = MovieDetailGenreColor,
        shape = RoundedCornerShape(5.dp)) {

        Box {

            Text(modifier = Modifier.padding(5.dp),
                text = genre.name.toUpperCase(),
                textAlign = TextAlign.Center,
                color = SplashBackground,
                style = MaterialTheme.typography.h2
            )
        }
    }
}