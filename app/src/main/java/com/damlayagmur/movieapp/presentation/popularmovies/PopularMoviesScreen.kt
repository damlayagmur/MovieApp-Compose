package com.damlayagmur.movieapp.presentation.popularmovies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.damlayagmur.movieapp.R

@ExperimentalFoundationApi
@Composable
fun PopularMoviesScreen(
    popularMoviesViewModel: PopularMoviesViewModel = hiltViewModel(),
    navigateToMovieDetail: (Int) -> Unit,
) {
    val state = popularMoviesViewModel.state.value

    Box(modifier = Modifier
        .background(Color(0xFF3D3D4E))
        .fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(stringResource(id = R.string.most_popular),
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.body2)

            LazyRow(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(30.dp, 30.dp, 5.dp, 5.dp),
                contentPadding = PaddingValues(3.dp),
            ) {
                state.popularMovies?.results?.size?.let { result ->
                    items(result) {
                        PopularMoviesItem(
                            popularMovies = state.popularMovies.results[it],
                            onItemClick = {
                                navigateToMovieDetail.invoke(it)
                            },
                        )
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
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}