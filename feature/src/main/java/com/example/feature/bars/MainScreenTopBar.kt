package com.example.feature.bars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenTopBar() {

    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    TopAppBar(
        title = { SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = {  },
            active = active,
            onActiveChange = { active = it }
        ) {

        } }
    )
}