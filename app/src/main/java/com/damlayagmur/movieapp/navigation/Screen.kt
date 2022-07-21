package com.damlayagmur.movieapp.navigation

sealed class Screen(val route: String) {
    object NowPlayingMoviesScreen : Screen("nowPlayingListScreen")
    object PopularMoviesScreen : Screen("PopularMoviesScreen")
    object MoviesDetailScreen : Screen("moviesListScreen")
    object SplashScreen : Screen("splashScreen")
}
