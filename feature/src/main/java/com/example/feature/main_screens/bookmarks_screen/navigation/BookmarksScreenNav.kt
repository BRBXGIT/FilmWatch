package com.example.feature.main_screens.bookmarks_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature.main_screens.bookmarks_screen.presentation.BookmarksScreen
import kotlinx.serialization.Serializable

@Serializable
object BookmarksScreenRoute

fun NavGraphBuilder.bookmarksScreen(innerPadding: PaddingValues) = composable<BookmarksScreenRoute> {
    BookmarksScreen(innerPadding = innerPadding)
}