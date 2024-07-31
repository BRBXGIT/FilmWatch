package com.example.feature.main_screens.main_screen.presentation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.ui.theme.mColors
import com.example.core.ui.toasts.ToastMessage

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
                items(latestMovies.itemCount, key = { index -> index }) { index ->
                    val movie = latestMovies[index]
                    movie?.let {
                        MoviePreviewUi(moviePreview = it)
                    }
                }

                item {
                    if(latestMovies.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }

        var error by rememberSaveable { mutableStateOf(false) }
        LaunchedEffect(latestMovies.loadState) {
            if(latestMovies.loadState.refresh is LoadState.Error) {
                error = true
            }
        }

        AnimatedVisibility(
            visible = error,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            val errorMessage = (latestMovies.loadState.refresh as LoadState.Error).error.message.toString()
            val message = if(errorMessage == """Unable to resolve host "api.themoviedb.org": No address associated with hostname""") {
                "Something went wrong. Try to use vpn"
            } else {
                "Something wrong with internet ;)"
            }
            ToastMessage(
                text = message,
                success = false,
                onTimeEnds = { error = false }
            )
        }
    }
}