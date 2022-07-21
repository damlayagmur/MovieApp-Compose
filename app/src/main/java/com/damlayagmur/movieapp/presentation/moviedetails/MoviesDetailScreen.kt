package com.damlayagmur.movieapp.presentation.moviedetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.damlayagmur.movieapp.R
import com.damlayagmur.movieapp.common.Constants
import com.damlayagmur.movieapp.common.dateConvert
import com.damlayagmur.movieapp.common.durationConvert
import com.damlayagmur.movieapp.presentation.theme.Background
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage


@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MoviesDetailsScreen(
    movieDetailsViewModel: MovieDetailsViewModel = hiltViewModel(),
    navigateToMovieList: (String) -> Unit,
) {
    val state = movieDetailsViewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        state.movieDetails?.let {

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    IconButton(modifier = Modifier.then(Modifier
                        .size(24.dp)),
                        onClick = {
                            navigateToMovieList("1")
                        }) {

                        Icon(
                            Icons.Filled.Close,
                            contentDescription = stringResource(id = R.string.content_description),
                            tint = Color.White)
                    }
                    Text(modifier = Modifier.fillMaxWidth(),
                        text = it.title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1
                    )
                }

                Spacer(modifier = Modifier.size(24.dp))

                Card(
                    shape = RoundedCornerShape(14.dp)
                ) {
                    GlideImage(
                        modifier = Modifier
                            .height(300.dp)
                            .width(200.dp),
                        imageModel = "${Constants.IMG_BASE_URL}" + it.poster_path,
                        circularReveal = CircularReveal(),
                        contentScale = ContentScale.FillBounds,
                    )
                }
            }

            Column() {
                Spacer(modifier = Modifier.size(24.dp))

                Row(Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)) {
                    Text(
                        text = stringResource(id = R.string.released_on),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h3
                    )

                    Text(
                        modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp),
                        text = it.release_date.dateConvert(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h2
                    )
                }

                Row(Modifier.padding(15.dp)) {
                    Text(
                        text = "Lasts ",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h3
                    )

                    Text(
                        modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp),
                        text = durationConvert(it.runtime),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h2
                    )
                }

                Text(
                    modifier = Modifier
                        .width(450.dp)
                        .padding(10.dp),
                    text = it.overview,
                    style = MaterialTheme.typography.h2
                )

                LazyRow(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(30.dp, 15.dp, 5.dp, 5.dp),
                    contentPadding = PaddingValues(3.dp),

                    ) {
                    state.movieDetails.genres?.size?.let { result ->
                        items(result) {
                            MovieDetailItem(
                                genre = state.movieDetails.genres[it],
                            )
                        }

                    }
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(text = state.error, color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

