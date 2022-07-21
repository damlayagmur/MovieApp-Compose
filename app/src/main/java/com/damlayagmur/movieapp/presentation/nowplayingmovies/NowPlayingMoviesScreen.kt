package com.damlayagmur.movieapp.presentation.nowplayingmovies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.damlayagmur.movieapp.R
import com.damlayagmur.movieapp.presentation.theme.SplashBackground

@ExperimentalFoundationApi
@Composable
fun NowPlayingMoviesScreen(
    nowPlayingMoviesViewModel: NowPlayingMoviesViewModel = hiltViewModel(),
    navigateToMovieDetail: (Int) -> Unit,
) {
    val state = nowPlayingMoviesViewModel.state.value

    val scrollState = rememberScrollState()

    if (scrollState.value == scrollState.maxValue) {
        nowPlayingMoviesViewModel.getNowPlayingMovies()
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(SplashBackground)) {

        Column {
            Row {
                Text(stringResource(id = R.string.now_playing),
                    modifier = Modifier.padding(29.dp, 20.dp, 0.dp, 5.dp),
                    style = MaterialTheme.typography.body2)
            }

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(12.dp)

            ) {
                state.nowPlayingMovies?.results?.size?.let { result ->
                    items(result) {
                        NowPlayingMoviesItem(
                            nowPlayingD = state.nowPlayingMovies.results[it],
                            onItemClick = {
                                navigateToMovieDetail.invoke(it)
                            },
                        )

                        //Pagination Part
                        /*if (it >= state.nowPlayingMovies.results.size - 1 && !nowPlayingMoviesViewModel.isLoading.value) {
                            // For handle possible side effect
                            LaunchedEffect(key1 = true) {
                                nowPlayingMoviesViewModel.getNowPlayingMovies()
                            }
                    }*/
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