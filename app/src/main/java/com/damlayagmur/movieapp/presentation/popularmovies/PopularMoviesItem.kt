package com.damlayagmur.movieapp.presentation.popularmovies

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.damlayagmur.movieapp.R
import com.damlayagmur.movieapp.common.Constants.IMG_BASE_URL
import com.damlayagmur.movieapp.data.model.popularmovies.Result
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PopularMoviesItem(
    popularMovies: Result,
    onItemClick: (Int) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .padding(30.dp, 30.dp, 0.dp, 0.dp)
                .clickable {
                    onItemClick(popularMovies.id)
                },
            backgroundColor = Color(0xFF3D3D4E),
            shape = RoundedCornerShape(14.dp)
        ) {
            Box {
                GlideImage(
                    imageModel = "$IMG_BASE_URL" + popularMovies.poster_path,
                    contentScale = ContentScale.FillBounds,
                    circularReveal = CircularReveal(duration = 250),
                    modifier = Modifier
                        .height(220.dp)
                        .width(150.dp)
                )
            }
        }

        Text(modifier = Modifier.width(200.dp),
            text = popularMovies.title,
            color = Color.White,
            style = MaterialTheme.typography.h1
        )

        Row {
            Image(
                if ((popularMovies.vote_average * 10).toInt() >= 50) {
                    painterResource(R.drawable.ic_green_foreground)
                } else {
                    painterResource(R.drawable.ic_red_foreground)
                },
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 4.dp),
            )
            Text(modifier = Modifier
                .width(200.dp)
                .padding(2.dp, 8.dp, 0.dp, 4.dp),
                text = (popularMovies.vote_average * 10).toInt().toString() + "%",
                style = MaterialTheme.typography.h1
            )
        }

        Text(modifier = Modifier.width(200.dp),
            text = popularMovies.overview,
            color = Color.White,
            style = MaterialTheme.typography.h2
        )
    }
}