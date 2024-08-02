package com.example.core.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.core.data.models.latest_movies_responce.Movie
import com.example.core.utils.Utils
import retrofit2.HttpException
import java.io.IOException

class LatestMoviesPagingSource(
    private val mainScreenApiInstance: MainScreenApiInstance
): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val startPage = params.key ?: 1
        val accessToken = "Bearer ${Utils.ACCESS_TOKEN}"

        return try {
            val movies = mainScreenApiInstance.getAllMovies(startPage, accessToken)
            val nextPage = if(movies.results.isEmpty()) null else movies.page + 1

            LoadResult.Page(
                data = movies.results,
                prevKey = if(startPage == 1) null else startPage - 1,
                nextKey = nextPage
            )

        } catch(e: IOException) {
            LoadResult.Error(e)
        } catch(e: HttpException) {
            LoadResult.Error(e)
        }
    }
}