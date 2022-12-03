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
import com.github.hemoptysisheart.parking.app.ui.configuration.UiConstants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel
import com.github.hemoptysisheart.parking.core.dummy.model.DummyPlaceModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import java.util.*

/**
 * 지도 중심을 기준으로 장소를 검색한다.
 *
 * UI : [SearchScreen](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?node-id=112%3A509&t=TzUdFxNeMKN4ZpTv-4)
 */
@Composable
fun SearchScreen(
    latitude: Double,
    longitude: Double,
    zoom: Float,
    viewModel: SearchViewModel = hiltViewModel(),
    resultOnClick: (UUID) -> Unit = {}
) {
    Log.v(
        TAG_COMPOSE,
        "#SearchScreen args : latitude=$latitude, longitude=$longitude, zoom=$zoom, viewModel=$viewModel"
    )

    val query by viewModel.query.collectAsState()
    val list by viewModel.places.collectAsState()

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(3.dp, 6.dp)
    ) {
        item {
            SearchHeader(
                query = query,
                onQueryChange = {
                    viewModel.search(it)
                    Log.v(TAG_COMPOSE, "#SearchScreen.onQueryUpdate args : query=$it")
                },
                onBack = {
                    Log.v(TAG_COMPOSE, "#SearchScreen.onBack called.")
                }
            )
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
                    .clickable { resultOnClick(place.id) }) {
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
        SearchScreen(35.5956352, 139.604961, 16.0F, SearchViewModel(DummyPlaceModel))
    }
}