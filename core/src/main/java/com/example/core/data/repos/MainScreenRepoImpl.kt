package com.example.core.data.repos

import android.content.Context
import com.example.core.R
import com.example.core.data.models.MoviesResponse
import com.example.core.data.network.MainScreenApiInstance
import com.example.core.domain.MainScreenRepo
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Inject

class MainScreenRepoImpl @Inject constructor(
    private val mainScreenApiInstance: MainScreenApiInstance,
    @ApplicationContext private val context: Context
): MainScreenRepo {

    override suspend fun getAllMovies(page: Int): Response<MoviesResponse> {
        val apiKey = context.getText(R.string.access_token_auth)
        return mainScreenApiInstance.getAllMovies(page, apiKey.toString())
    }
}