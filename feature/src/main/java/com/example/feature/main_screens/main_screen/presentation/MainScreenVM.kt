package com.example.feature.main_screens.main_screen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.core.data.models.latest_movies_responce.Movie
import com.example.core.data.repos.MainScreenRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val mainScreenRepoImpl: MainScreenRepoImpl
): ViewModel() {
    val latestMovies = mainScreenRepoImpl.getAllMovies().cachedIn(viewModelScope)

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        ""
    )
    @OptIn(ExperimentalCoroutinesApi::class)
    private val _moviesByQuery = _query.flatMapLatest { query ->
        mainScreenRepoImpl.getMoviesByQuery(query).cachedIn(viewModelScope)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        PagingData.empty()
    )

    val moviesByQuery: StateFlow<PagingData<Movie>> get() = _moviesByQuery

    fun setQuery(query: String) {
        _query.value = query
    }
}