package com.damlayagmur.movieapp.domain.usecase.moviedetail

import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.data.model.moviedetail.toMovieDetail
import com.damlayagmur.movieapp.domain.model.MovieDetail
import com.damlayagmur.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    operator fun invoke(movieId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = movieRepository.getMovieById(movieId).toMovieDetail()
            emit(Resource.Success(movieDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check your internet connection"))
        }
    }
}