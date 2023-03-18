package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.navigation.SearchPageNavigation
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun SearchPage(
    navigation: SearchPageNavigation = SearchPageNavigation(rememberNavController())
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        item {
            Text(text = "search")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_SearchPage() {
    ParkingTheme {
        SearchPage()
    }
}