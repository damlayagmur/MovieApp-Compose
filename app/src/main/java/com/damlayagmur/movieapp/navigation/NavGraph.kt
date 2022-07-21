package com.damlayagmur.movieapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.damlayagmur.movieapp.presentation.moviedetails.MoviesDetailsScreen
import com.damlayagmur.movieapp.presentation.nowplayingmovies.NowPlayingMoviesScreen
import com.damlayagmur.movieapp.presentation.popularmovies.PopularMoviesScreen
import com.damlayagmur.movieapp.presentation.splash.SplashScreen

@ExperimentalFoundationApi
@Composable
fun NavGraph(navController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(
                navigateToNowPlaying = {
                    navController.navigate(Screen.NowPlayingMoviesScreen.route) {
                        popUpTo(Screen.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Screen.NowPlayingMoviesScreen.route) {
            NowPlayingMoviesScreen(
                navigateToMovieDetail = {
                    navController.navigate("${Screen.MoviesDetailScreen.route}/$it")
                }
            )
        }

        composable(route = Screen.PopularMoviesScreen.route) {
            PopularMoviesScreen(
                navigateToMovieDetail = {
                    navController.navigate("${Screen.MoviesDetailScreen.route}/$it")
                }
            )
        }

        composable(route = "${Screen.MoviesDetailScreen.route}/{movieId}") {
            MoviesDetailsScreen(navigateToMovieList = {

                navController.navigate(Screen.NowPlayingMoviesScreen.route) {
                    popUpTo(Screen.MoviesDetailScreen.route) {
                        inclusive = false
                    }
                }
            })
        }

        /*composable(route = "${Screen.MoviesDetailScreen.route}/{movieId}") {
            MoviesDetailsScreen(
                navigateToMovieList = {
                    navController.navigate(Screen.PopularMoviesScreen.route) {
                        popUpTo(Screen.MoviesDetailScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }*/
    }
}