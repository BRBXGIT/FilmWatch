package com.example.core.data.repos

import com.example.core.data.models.MoviesResponse
import com.example.core.data.network.MainScreenApiInstance
import com.example.core.domain.MainScreenRepo
import retrofit2.Response
import javax.inject.Inject

class MainScreenRepoImpl @Inject constructor(
    private val mainScreenApiInstance: MainScreenApiInstance
): MainScreenRepo {

    override suspend fun getAllMovies(page: Int, apiKey: String): Response<MoviesResponse> {
        return mainScreenApiInstance.getAllMovies(page, apiKey)
    }
}