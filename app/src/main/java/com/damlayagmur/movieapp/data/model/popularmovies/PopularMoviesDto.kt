package com.damlayagmur.movieapp.data.model.popularmovies

import com.damlayagmur.movieapp.domain.model.PopularMovies

data class PopularMoviesDto(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int,
)

fun PopularMoviesDto.toPopularMovies(): PopularMovies {
    return PopularMovies(
        results = results
    )
}