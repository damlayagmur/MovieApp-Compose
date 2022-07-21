package com.damlayagmur.movieapp.data.repository

import com.damlayagmur.movieapp.data.model.moviedetail.MovieDetailDto
import com.damlayagmur.movieapp.data.model.nowplayingmovies.NowPlayingDto
import com.damlayagmur.movieapp.data.model.popularmovies.PopularMoviesDto
import com.damlayagmur.movieapp.data.remote.MovieService
import com.damlayagmur.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val service: MovieService,
) : MovieRepository {

    override suspend fun getNowPlaying(api_key: String, page: Int): NowPlayingDto {
        return service.getNowPlaying(api_key, page)
    }

    override suspend fun getMovieById(movieId: String): MovieDetailDto {
        return service.getMovieById(movieId)
    }

    override suspend fun getPopularMovies(api_key: String): PopularMoviesDto {
        return service.getPopularMovies(api_key)
    }
}