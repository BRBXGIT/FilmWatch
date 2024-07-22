package com.example.feature.main_screens.main_screen.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.ui.theme.mColors

@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    mainScreenVM: MainScreenVM,
    context: Context = LocalContext.current
) {
    val latestMovies = mainScreenVM.latestMovies.collectAsLazyPagingItems()

    LaunchedEffect(latestMovies.loadState) {
        if(latestMovies.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                (latestMovies.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .padding(innerPadding)
    ) {
        if(latestMovies.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn {
                items(latestMovies.itemSnapshotList.items, key = { it.id }) { item ->
                    val movie by mainScreenVM.getMovieById(item.id).collectAsState()
                }
            }
        }
    }
}