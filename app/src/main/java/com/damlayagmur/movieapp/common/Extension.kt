package com.damlayagmur.movieapp.common

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun durationConvert(runtime: Int): String {

    val hours: Int = runtime / 60
    val minutes: Int = runtime % 60

    return "${hours}h$minutes"
}

@RequiresApi(Build.VERSION_CODES.O)
fun String.dateConvert(): String {
    val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val date = LocalDate.parse(this, firstApiFormat)

    return date.month.toString() + ", " + date.dayOfMonth.toString() + " " + date.year.toString()
}