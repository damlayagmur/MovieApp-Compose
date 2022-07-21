package com.damlayagmur.movieapp.data.model.nowplayingmovies

import com.damlayagmur.movieapp.domain.model.NowPlayingMovies

data class NowPlayingDto(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int,
)

fun NowPlayingDto.toNowPlaying(): NowPlayingMovies {
    return NowPlayingMovies(
        results = results
    )
}