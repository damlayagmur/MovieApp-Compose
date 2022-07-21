package com.damlayagmur.movieapp.domain.repository

import com.damlayagmur.movieapp.data.model.moviedetail.MovieDetailDto
import com.damlayagmur.movieapp.data.model.nowplayingmovies.NowPlayingDto
import com.damlayagmur.movieapp.data.model.popularmovies.PopularMoviesDto

interface MovieRepository {

    suspend fun getNowPlaying(apiKey: String, page: Int): NowPlayingDto

    suspend fun getMovieById(movieId: String): MovieDetailDto

    suspend fun getPopularMovies(apiKey: String): PopularMoviesDto
}