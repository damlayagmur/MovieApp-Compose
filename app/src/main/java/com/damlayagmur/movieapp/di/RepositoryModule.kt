package com.damlayagmur.movieapp.di

import com.damlayagmur.movieapp.data.remote.MovieService
import com.damlayagmur.movieapp.data.repository.MovieRepositoryImpl
import com.damlayagmur.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(service: MovieService): MovieRepository {
        return MovieRepositoryImpl(service)
    }
}