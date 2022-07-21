package com.damlayagmur.movieapp.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.damlayagmur.movieapp.R
import com.damlayagmur.movieapp.presentation.theme.Background
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToNowPlaying: () -> Unit,
) {

    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000)
        navigateToNowPlaying.invoke()
    }

    SplashDesign(alpha = alphaAnimation.value)
}

@Composable
fun SplashDesign(alpha: Float) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)

    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(300.dp)
                .alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.splash),
            contentDescription = stringResource(R.string.app_name),
        )
    }
}