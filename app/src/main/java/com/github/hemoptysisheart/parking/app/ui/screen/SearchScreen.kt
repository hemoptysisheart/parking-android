package com.github.hemoptysisheart.parking.app.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.component.search.SearchHeader
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun SearchScreen() {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            SearchHeader()
        }
    }
}

@Composable
@Preview
fun SearchScreenPreview() {
    ParkingTheme {
        SearchScreen()
    }
}