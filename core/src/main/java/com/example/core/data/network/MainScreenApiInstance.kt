package com.example.core.data.network

import com.example.core.data.models.latest_movies_responce.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MainScreenApiInstance {

    @GET("trending/movie/day")
    suspend fun getAllMovies(
        @Query("page") page: Int,
        @Header("Authorization") apiKey: String
    ): MoviesResponse

    @GET("search/movie")
    suspend fun getMoviesByQuery(
        @Query("page") page: Int,
        @Query("query") query: String,
        @Header("Authorization") apiKey: String
    ): MoviesResponse
}