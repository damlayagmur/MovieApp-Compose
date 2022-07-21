package com.damlayagmur.movieapp

import com.damlayagmur.movieapp.data.model.moviedetail.BelongsToCollection
import com.damlayagmur.movieapp.data.model.moviedetail.MovieDetailDto

fun getDummyMovieDetail() = listOf(
    MovieDetailDto(
        adult = true,
        backdrop_path = "1",
        belongs_to_collection = BelongsToCollection("1",
            1,
            "1",
            "1"),
        budget = 1,
        genres = emptyList(),
        homepage = "1",
        id = 1,
        imdb_id = "1",
        original_language = "1",
        original_title = "1",
        overview = "1",
        popularity = 12833.993,
        poster_path = "1",
        production_companies = emptyList(),
        production_countries = emptyList(),
        release_date = "1",
        revenue = 1,
        runtime = 1,
        spoken_languages = emptyList(),
        status = "1",
        tagline = "1",
        title = "1",
        video = true,
        vote_average = 12833.993,
        vote_count = 1
    )
)