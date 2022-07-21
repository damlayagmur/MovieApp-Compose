package com.damlayagmur.movieapp.presentation.popularmovies

import com.damlayagmur.movieapp.domain.model.PopularMovies

data class PopularMoviesState(
    val isLoading: Boolean = false,
    val popularMovies: PopularMovies? = null,
    val error: String = "",
)