package com.example.core.data.network

import com.example.core.data.models.latest_movies_responce.MoviesResponse
import com.example.core.data.models.movie.MoviePreview
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MainScreenApiInstance {

    @GET("movie/changes")
    suspend fun getAllMovies(
        @Query("page") page: Int,
        @Header("Authorization") apiKey: String
    ): MoviesResponse

    @GET("movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: Int,
        @Header("Authorization") apiKey: String
    ): MoviePreview
}