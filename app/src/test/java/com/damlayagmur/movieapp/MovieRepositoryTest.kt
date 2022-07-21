package com.damlayagmur.movieapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.damlayagmur.movieapp.common.Resource
import com.damlayagmur.movieapp.data.remote.MovieService
import com.damlayagmur.movieapp.data.repository.MovieRepositoryImpl
import com.damlayagmur.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var movieService: MovieService

    @Before
    fun setUp() {
        movieRepository = MovieRepositoryImpl(movieService)
    }

    @Test
    fun `Given Movies When moviesService returns Success`() = runBlocking {
        val givenMovie = getDummyMovieDetail()
        val givenMovieOutput = Resource.Success(givenMovie)
        Mockito.`when`(movieService.getMovieById("1")).thenReturn(givenMovieOutput.data!![0])

        val outputFlow = movieRepository.getMovieById("1")

        assert(outputFlow.id == 1)
    }
}
