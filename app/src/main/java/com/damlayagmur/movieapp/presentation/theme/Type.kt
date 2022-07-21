package com.damlayagmur.movieapp.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.damlayagmur.movieapp.R

val roboto = FontFamily(
    Font(R.font.roboto_bold),
)
val robotoLight = FontFamily(
    Font(R.font.roboto_light, FontWeight.Light),
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 18.sp
    ),

    body2 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 24.sp
    ),

    h1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Light,
        color = Color.White,
        fontSize = 14.sp
    ),
    h2 = TextStyle(
        fontFamily = robotoLight,
        fontWeight = FontWeight.Light,
        color = Color.White,
        fontSize = 14.sp
    ),
    h3 = TextStyle(
        fontFamily = robotoLight,
        fontWeight = FontWeight.Light,
        color = MovieDetailColor,
        fontSize = 16.sp
    ),
)