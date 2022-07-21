package com.damlayagmur.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.damlayagmur.movieapp.navigation.BottomNavigationBar
import com.damlayagmur.movieapp.navigation.NavGraph
import com.damlayagmur.movieapp.navigation.Screen
import com.damlayagmur.movieapp.presentation.theme.AssignmentTheme
import com.damlayagmur.movieapp.presentation.theme.Background
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme() {
                val bottomBarState = rememberSaveable { (mutableStateOf(false)) }

                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()

                when (navBackStackEntry?.destination?.route) {
                    Screen.SplashScreen.route -> bottomBarState.value = false
                    else -> bottomBarState.value = true
                }

                Scaffold(
                    backgroundColor = Background,
                    bottomBar = {
                        BottomNavigationBar(navController, bottomBarState)

                    }
                ) {
                    NavGraph(navController = navController, it)
                }

            }
        }
    }
}
