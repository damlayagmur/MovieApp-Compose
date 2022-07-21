package com.damlayagmur.movieapp.navigation

import com.damlayagmur.movieapp.R
import com.damlayagmur.movieapp.common.Constants

sealed class BottomNavItem(
    val title: String,
    val image: Int,
    val route: String,
) {
    object PlayingNow : BottomNavItem(
        title = Constants.CATEGORY_PLAYING_NOW,
        image = R.drawable.ic_now_playing,
        route = Screen.NowPlayingMoviesScreen.route
    )

    object MostPopular : BottomNavItem(
        title = Constants.CATEGORY_MOST_POPULAR,
        image = R.drawable.ic_most_popular,
        route = Screen.PopularMoviesScreen.route
    )
}