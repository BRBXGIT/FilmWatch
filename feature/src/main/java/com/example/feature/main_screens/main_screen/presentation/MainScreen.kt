package com.example.feature.main_screens.main_screen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.ui.theme.mColors

@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    mainScreenVM: MainScreenVM,
) {
    val latestMovies = mainScreenVM.latestMovies.collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .padding(innerPadding)
    ) {
        MoviesColumn(movies = latestMovies)
    }
}