package com.example.core.data.repos

import com.example.core.data.models.MoviesResponse
import com.example.core.data.network.MainScreenApiInstance
import com.example.core.domain.MainScreenRepo
import com.example.core.utils.Utils
import javax.inject.Inject

class MainScreenRepoImpl @Inject constructor(
    private val mainScreenApiInstance: MainScreenApiInstance,
): MainScreenRepo {

    private val accessToken = Utils.ACCESS_TOKEN

    //Getting all latest movies by page
    override suspend fun getAllMovies(page: Int): MoviesResponse {
        return mainScreenApiInstance.getAllMovies(page, accessToken)
    }
}