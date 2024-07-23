package com.example.feature.main_screens.main_screen.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp),
                contentPadding = PaddingValues(
                    vertical = 16.dp
                )
            ) {
                items(latestMovies.itemSnapshotList.items, key = { it.id }) { movie ->
                    MoviePreviewUi(
                        moviePreview = movie
                    )
                }

                item {
                    if(latestMovies.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}