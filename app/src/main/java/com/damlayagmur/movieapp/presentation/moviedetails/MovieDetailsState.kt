package com.damlayagmur.movieapp.presentation.moviedetails

import com.damlayagmur.movieapp.domain.model.MovieDetail

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetail? = null,
    val error: String = "",
)
