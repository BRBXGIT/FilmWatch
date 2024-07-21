package com.example.feature.main_screens.main_screen.presentation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    mainScreenVM: MainScreenVM
) {
    val latestMovies = mainScreenVM.latestMovies.collectAsLazyPagingItems()

    LaunchedEffect(latestMovies.loadState) {
        if(latestMovies.loadState.refresh is LoadState.Error) {
            Log.d("movies", (latestMovies.loadState.refresh as LoadState.Error).error.message.toString())
        }
    }

    Log.d("movies", latestMovies.itemSnapshotList.items.toString())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        items(latestMovies.itemSnapshotList.items) { movie ->
            Text(text = movie.id.toString())
        }
    }
}