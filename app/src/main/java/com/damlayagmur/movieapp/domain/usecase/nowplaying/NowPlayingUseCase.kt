package com.damlayagmur.movieapp.domain.usecase.nowplaying

import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.data.model.moviedetail.toMovieDetail
import com.damlayagmur.movieapp.data.model.nowplayingmovies.toNowPlaying
import com.damlayagmur.movieapp.domain.model.NowPlayingMovies
import com.damlayagmur.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NowPlayingUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    operator fun invoke(api_key: String, page: Int): Flow<Resource<NowPlayingMovies>> = flow {
        try {
            emit(Resource.Loading())
            val nowPlayingMovie = movieRepository.getNowPlaying(api_key, page).toNowPlaying()
            for (item in nowPlayingMovie.results) {
                val value: String = item.id.toString()
                item.duration = movieRepository.getMovieById(value).toMovieDetail().runtime
            }
            emit(Resource.Success(nowPlayingMovie))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occur"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check your internet connection"))
        }
    }
}