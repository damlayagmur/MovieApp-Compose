package com.damlayagmur.movieapp.domain.model

import com.damlayagmur.movieapp.data.model.popularmovies.Result

data class PopularMovies(
    val results: List<Result>,
)
