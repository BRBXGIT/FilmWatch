package com.example.core.data.network

import com.example.core.data.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainScreenApiInstance {

    @GET("/movie/changes")
    suspend fun getAllMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String
    ): MoviesResponse
}