package com.damlayagmur.movieapp.presentation.nowplayingmovies

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
import com.damlayagmur.movieapp.common.durationConvert
import com.damlayagmur.movieapp.data.model.nowplayingmovies.Result
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NowPlayingMoviesItem(
    nowPlayingD: Result,
    onItemClick: (Int) -> Unit,
) {

    Column(modifier = Modifier) {
        Card(
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .clickable {
                    onItemClick(nowPlayingD.id)
                },
            backgroundColor = Color(0xFF3D3D4E),
            shape = RoundedCornerShape(14.dp)
        ) {
            Box {
                GlideImage(
                    imageModel = "$IMG_BASE_URL" + nowPlayingD.poster_path,
                    contentScale = ContentScale.Fit,
                    circularReveal = CircularReveal(duration = 250),
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(14.dp, 8.dp, 0.dp, 0.dp)) {
                Text(
                    modifier = Modifier
                        .width(90.dp),
                    text = nowPlayingD.title,
                    style = MaterialTheme.typography.h1
                )

                Image(
                    if ((nowPlayingD.vote_average * 10).toInt() >= 50) {
                        painterResource(R.drawable.ic_green_foreground)
                    } else {
                        painterResource(R.drawable.ic_red_foreground)
                    },
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 4.dp),
                )

                Text(
                    modifier = Modifier
                        .padding(2.dp, 4.dp, 0.dp, 0.dp),
                    text = (nowPlayingD.vote_average * 10).toInt().toString() + "%",
                    style = MaterialTheme.typography.h1
                )
            }

            Text(
                modifier = Modifier.padding(14.dp, 0.dp, 0.dp, 0.dp),
                text = durationConvert(nowPlayingD.duration),
                color = Color.White,
                style = MaterialTheme.typography.h2
            )
        }
    }
}