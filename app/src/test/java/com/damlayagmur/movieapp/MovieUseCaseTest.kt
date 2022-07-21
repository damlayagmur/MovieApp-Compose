package com.damlayagmur.movieapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.domain.repository.MovieRepository
import com.damlayagmur.movieapp.domain.usecase.moviedetail.MovieDetailUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieUseCaseTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository
    private lateinit var movieUseCase: MovieDetailUseCase

    @Before
    fun setUp() {
        movieUseCase = MovieDetailUseCase(movieRepository)
    }

    @Test
    fun `Given Movie When UseCase invoke returns Success`() = runBlocking {
        //GIVEN
        val inputFlow = flowOf(Resource.Success(getDummyMovieDetail()))
        Mockito.`when`(movieRepository.getMovieById("0"))
            .thenReturn(inputFlow.toList()[0].data?.get(0))
        //WHEN
        val output = movieUseCase.invoke("0")
        //THEN
        assert(output.toList()[0].data?.id != 0)
    }
}