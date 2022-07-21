package com.damlayagmur.movieapp.domain.usecase.popular

import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.data.model.popularmovies.toPopularMovies
import com.damlayagmur.movieapp.domain.model.PopularMovies
import com.damlayagmur.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    operator fun invoke(apiKey: String): Flow<Resource<PopularMovies>> = flow {
        try {
            emit(Resource.Loading())
            val popularMovies = movieRepository.getPopularMovies(apiKey).toPopularMovies()
            emit(Resource.Success(popularMovies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occur"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check your internet connection"))
        }
    }
}