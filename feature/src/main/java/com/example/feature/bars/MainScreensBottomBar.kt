package com.example.feature.bars

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.feature.R
import com.example.feature.main_screens.bookmarks_screen.navigation.BookmarksScreenRoute
import com.example.feature.main_screens.main_screen.navigation.MainScreenRoute
import com.example.feature.main_screens.profile_screen.navigation.ProfileScreenRoute

data class NavItem(
    val title: String,
    val icon: Int,
    val iconChosen: Int,
    val route: Any,
    val destination: String
)

@Composable
fun MainScreensBottomBar(
    navController: NavHostController
) {
    val navItems = listOf(
        NavItem(
            title = "Main",
            icon = R.drawable.ic_home_outlined,
            iconChosen = R.drawable.ic_home_filled,
            route = MainScreenRoute,
            destination = "MainScreenRoute"
        ),
        NavItem(
            title = "Bookmarks",
            icon = R.drawable.ic_bookmark_outlined,
            iconChosen = R.drawable.ic_bookmark_filled,
            route = BookmarksScreenRoute,
            destination = "BookmarksScreenRoute"
        ),
        NavItem(
            title = "Profile",
            icon = R.drawable.ic_user_outlined,
            iconChosen = R.drawable.ic_user_filled,
            route = ProfileScreenRoute,
            destination = "ProfileScreenRoute"
        )
    )

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = if(currentDestination != null) currentDestination?.destination?.route.toString().split(".")[6] else "MainScreenRoute"
    BottomAppBar(
        tonalElevation = 0.dp
    ) {
        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.destination,
                onClick = {
                    if(navItem.destination != currentRoute) {
                        navController.navigate(navItem.route)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if(currentRoute != navItem.destination) navItem.icon else navItem.iconChosen
                        ),
                        contentDescription = null
                    )
                },
                label = { Text(text = navItem.title) }
            )
        }
    }
}