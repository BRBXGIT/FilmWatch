package com.example.feature.main_screens.profile_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature.main_screens.profile_screen.presentation.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
object ProfileScreenRoute

fun NavGraphBuilder.profileScreen(innerPadding: PaddingValues) = composable<ProfileScreenRoute> {
    ProfileScreen(innerPadding = innerPadding)
}