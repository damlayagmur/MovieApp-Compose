package com.damlayagmur.movieapp.presentation.moviedetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damlayagmur.movieapp.common.Constants
import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.domain.usecase.moviedetail.MovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailsState())
    val state: State<MovieDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_MOVIE_ID)?.let { movieId ->
            getMovieDetails(movieId)
        }
    }

    private fun getMovieDetails(movieId: String) {
        movieDetailUseCase(movieId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MovieDetailsState(movieDetails = result.data)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailsState(error = result.errorMessage
                        ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}