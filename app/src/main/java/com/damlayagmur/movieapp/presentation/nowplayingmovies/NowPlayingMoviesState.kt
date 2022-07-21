package com.damlayagmur.movieapp.presentation.nowplayingmovies

import com.damlayagmur.movieapp.domain.model.NowPlayingMovies

data class NowPlayingMoviesState(
    val isLoading: Boolean = false,
    val nowPlayingMovies: NowPlayingMovies? = null,
    val error: String = "",
)
