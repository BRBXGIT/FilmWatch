package com.example.feature.main_screens.main_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature.main_screens.main_screen.presentation.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object MainScreenRoute

fun NavGraphBuilder.mainScreen(innerPadding: PaddingValues) = composable<MainScreenRoute> {
    MainScreen(innerPadding = innerPadding)
}