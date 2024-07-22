package com.example.core.domain

import androidx.paging.PagingData
import com.example.core.data.models.latest_movies_responce.Movie
import com.example.core.data.models.movie.MoviePreview
import kotlinx.coroutines.flow.Flow

interface MainScreenRepo {

    fun getAllMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieById(id: Int): MoviePreview
}