package com.example.core.domain

import com.example.core.data.models.MoviesResponse
import retrofit2.Response

interface MainScreenRepo {

    suspend fun getAllMovies(page: Int, apiKey: String): Response<MoviesResponse>
}