package com.damlayagmur.movieapp.data.remote

import com.damlayagmur.movieapp.data.model.moviedetail.MovieDetailDto
import com.damlayagmur.movieapp.data.model.nowplayingmovies.NowPlayingDto
import com.damlayagmur.movieapp.data.model.popularmovies.PopularMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("now_playing?language=en-US")
    suspend fun getNowPlaying(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
    ): NowPlayingDto

    @GET("{movieId}?api_key=ba7aadc4f5cd06ca5c8eb61037b3f77d&language=en-US")
    suspend fun getMovieById(@Path("movieId") movieId: String): MovieDetailDto

    @GET("popular?&language=en-US")
    suspend fun getPopularMovies(@Query("api_key") api_key: String): PopularMoviesDto
}