package com.example.feature.main_screens.main_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature.main_screens.main_screen.presentation.MainScreen
import com.example.feature.main_screens.main_screen.presentation.MainScreenVM
import kotlinx.serialization.Serializable

@Serializable
object MainScreenRoute

fun NavGraphBuilder.mainScreen(innerPadding: PaddingValues) = composable<MainScreenRoute> {
    val mainScreenVM = hiltViewModel<MainScreenVM>()
    MainScreen(innerPadding = innerPadding, mainScreenVM = mainScreenVM)
}