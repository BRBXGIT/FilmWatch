package com.example.feature.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.feature.bars.MainScreensBottomBar
import com.example.feature.main_screens.bookmarks_screen.navigation.bookmarksScreen
import com.example.feature.main_screens.main_screen.navigation.MainScreenRoute
import com.example.feature.main_screens.main_screen.navigation.mainScreen
import com.example.feature.main_screens.profile_screen.navigation.profileScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            MainScreensBottomBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainScreenRoute
        ) {
            mainScreen(innerPadding)

            bookmarksScreen(innerPadding)

            profileScreen(innerPadding)
        }
    }
}