package com.example.core.domain

import androidx.paging.PagingData
import com.example.core.data.models.Movie
import com.example.core.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface MainScreenRepo {

    fun getAllMovies(): Flow<PagingData<Movie>>
}