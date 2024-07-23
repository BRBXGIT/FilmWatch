package com.example.core.data.repos

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.models.latest_movies_responce.Movie
import com.example.core.data.network.MainScreenApiInstance
import com.example.core.data.network.MoviesPagingSource
import com.example.core.domain.MainScreenRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainScreenRepoImpl @Inject constructor(
    private val mainScreenApiInstance: MainScreenApiInstance,
): MainScreenRepo {

    //Getting all latest movies by page
    override fun getAllMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { MoviesPagingSource(mainScreenApiInstance) }
        ).flow
    }
}