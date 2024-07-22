package com.example.feature.main_screens.main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.core.data.models.movie.MoviePreview
import com.example.core.data.repos.MainScreenRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val mainScreenRepoImpl: MainScreenRepoImpl
): ViewModel() {
    val latestMovies = mainScreenRepoImpl.getAllMovies().cachedIn(viewModelScope)

    private val movieCache = mutableMapOf<Int, MutableStateFlow<MoviePreview>>()
    fun getMovieById(id: Int): StateFlow<MoviePreview> {
        return movieCache.getOrPut(id) {
            val movieFlow = MutableStateFlow(MoviePreview())
            viewModelScope.launch {
                movieFlow.value = mainScreenRepoImpl.getMovieById(id)
            }
            movieFlow
        }
    }
}