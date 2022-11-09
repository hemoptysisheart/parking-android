package com.github.hemoptysisheart.parking.app.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.component.search.SearchHeader
import com.github.hemoptysisheart.parking.app.ui.configuration.LogicConstant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import java.util.*

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    setPlaceOnMap: (UUID) -> Unit = {}
) {
    Log.v(TAG_COMPOSE, "#SearchScreen args : viewModel=$viewModel")

    val list by viewModel.places.collectAsState()

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(3.dp, 6.dp)
    ) {
        item {
            SearchHeader()
        }

        itemsIndexed(list) { idx, place ->
            if (0 < idx) {
                Spacer(
                    Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                )
            }

            Column(
                Modifier
                    .padding(3.dp)
                    .clickable { setPlaceOnMap(place.id) }) {
                Text(text = place.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = place.description, color = Color.LightGray, fontSize = 16.sp)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview() {
    ParkingTheme {
        SearchScreen(SearchViewModel(DummyPlaceModel))
    }
}