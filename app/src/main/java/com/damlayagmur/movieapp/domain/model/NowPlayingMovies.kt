package com.damlayagmur.movieapp.domain.model

import com.damlayagmur.movieapp.data.model.nowplayingmovies.Result

data class NowPlayingMovies(
    val results: List<Result>,
)
