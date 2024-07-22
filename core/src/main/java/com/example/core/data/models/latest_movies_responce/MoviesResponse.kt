package com.example.core.data.models.latest_movies_responce

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)