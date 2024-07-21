package com.example.core.data.repos

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.models.Movie
import com.example.core.data.models.MoviesResponse
import com.example.core.data.network.MainScreenApiInstance
import com.example.core.data.network.MoviesPagingSource
import com.example.core.domain.MainScreenRepo
import com.example.core.utils.Utils
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainScreenRepoImpl @Inject constructor(
    private val mainScreenApiInstance: MainScreenApiInstance,
): MainScreenRepo {

    //Getting all latest movies by page
    override fun getAllMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 101, enablePlaceholders = false),
            pagingSourceFactory = { MoviesPagingSource(mainScreenApiInstance) }
        ).flow
    }
}