package com.example.core.domain

import androidx.paging.PagingData
import com.example.core.data.models.latest_movies_responce.Movie
import kotlinx.coroutines.flow.Flow

interface MainScreenRepo {

    fun getAllMovies(): Flow<PagingData<Movie>>

    fun getMoviesByQuery(query: String): Flow<PagingData<Movie>>
}