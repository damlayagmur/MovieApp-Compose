package com.damlayagmur.movieapp.presentation.nowplayingmovies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damlayagmur.movieapp.common.Constants
import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.domain.usecase.nowplaying.NowPlayingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NowPlayingMoviesViewModel @Inject constructor(
    private val nowPlayingUseCase: NowPlayingUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(NowPlayingMoviesState())
    val state: State<NowPlayingMoviesState> = _state
    private var page = 1
    var isLoading = mutableStateOf(false)

    init {
        getNowPlayingMovies()
    }

    fun getNowPlayingMovies() {
        nowPlayingUseCase(Constants.PARAM_API_KEY, page).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        NowPlayingMoviesState(nowPlayingMovies = result.data!!)
                    isLoading.value = false
                }
                is Resource.Error -> {
                    _state.value = NowPlayingMoviesState(error = result.errorMessage
                        ?: "An unexpected error occurred")
                    isLoading.value = false
                }
                is Resource.Loading -> {
                    _state.value = NowPlayingMoviesState(isLoading = true)
                    isLoading.value = true
                }
            }
        }.launchIn(viewModelScope)
        page += 1
    }
}