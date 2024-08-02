package com.example.feature.bars

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.ui.theme.mColors
import com.example.core.ui.theme.mTypography
import com.example.feature.R
import com.example.feature.main_screens.main_screen.presentation.MainScreenVM
import com.example.feature.main_screens.main_screen.presentation.MoviesColumn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenTopBar(
    mainScreenVM: MainScreenVM = hiltViewModel<MainScreenVM>()
) {
    val moviesByQuery = mainScreenVM.moviesByQuery.collectAsLazyPagingItems()

    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    val searchBarPadding by animateDpAsState(
        targetValue = if(active) 0.dp else 16.dp,
        label = "Search bar padding"
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = {
                mainScreenVM.setQuery(query)
            },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text(
                    text = "Find movie",
                    style = mTypography.labelLarge
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_magnifier),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            },
            trailingIcon = {
                if(active) {
                    IconButton(
                        onClick = {
                            active = false
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cross),
                            contentDescription = null
                        )
                    }
                }
            },
            tonalElevation = 0.dp,
            modifier = Modifier.padding(horizontal = searchBarPadding)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                MoviesColumn(movies = moviesByQuery)
            }
        }

        HorizontalDivider(thickness = 1.dp, color = mColors.surface)
    }
}