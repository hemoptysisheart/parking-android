package com.github.hemoptysisheart.parking.app.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.component.search.SearchHeader
import com.github.hemoptysisheart.parking.app.ui.configuration.LogicConstant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import java.util.*

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    setPlaceOnMap: (UUID) -> Unit = {}
) {
    Log.v(TAG_COMPOSE, "#SearchScreen args : viewModel=$viewModel")

    val list by viewModel.places.collectAsState()

    LazyColumn(Modifier.fillMaxSize()) {
        item {
            SearchHeader()
        }

        items(list) {
            Button(onClick = { setPlaceOnMap(it.id) }) {
                Text(text = "#${it.id} ${it.name}")
            }
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