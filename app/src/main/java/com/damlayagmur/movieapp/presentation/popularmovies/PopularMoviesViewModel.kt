package com.damlayagmur.movieapp.presentation.popularmovies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damlayagmur.movieapp.common.Constants
import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.domain.usecase.popular.PopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val popularMovieUseCase: PopularMovieUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(PopularMoviesState())
    val state: State<PopularMoviesState> = _state

    init {
        getPopularMovies(Constants.PARAM_API_KEY)
    }

    private fun getPopularMovies(apiKey: String) {
        popularMovieUseCase(apiKey).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PopularMoviesState(popularMovies = result.data)
                }
                is Resource.Error -> {
                    _state.value = PopularMoviesState(error = result.errorMessage
                        ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = PopularMoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}