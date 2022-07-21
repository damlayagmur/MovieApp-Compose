package com.damlayagmur.movieapp.domain.model

import com.damlayagmur.movieapp.data.model.moviedetail.Genre

data class MovieDetail(
    val genres: List<Genre>,
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val title: String,
)