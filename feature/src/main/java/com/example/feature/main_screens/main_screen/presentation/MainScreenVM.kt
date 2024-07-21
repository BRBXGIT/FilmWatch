package com.example.feature.main_screens.main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.core.data.repos.MainScreenRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val mainScreenRepoImpl: MainScreenRepoImpl
): ViewModel() {
    val latestMovies = mainScreenRepoImpl.getAllMovies().cachedIn(viewModelScope)

}