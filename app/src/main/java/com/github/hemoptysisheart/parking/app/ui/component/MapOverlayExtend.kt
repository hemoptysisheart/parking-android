package com.github.hemoptysisheart.parking.app.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.app.ui.configuration.Constant.TAG_COMPOSE
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.AAA_ANNEX_GALLERY
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.AAA_NIHON_株式会社
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.AAA_TOHO_TRADING
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.GOOBNE_CHICKEN_曙橋店
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.domain.RecommendItem
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayExtend(
    destinationQuery: String = "",
    searchDestinationResult: List<RecommendItem<*>> = listOf(),
    onDestinationQueryChange: (String) -> Unit = {},
    onSelectRecommend: (RecommendItem<*>) -> Unit = {},
    onCollapse: () -> Unit = { }
) {
    logArgs(
        TAG_COMPOSE, "MapOverlayExtend",
        "destinationQuery" to destinationQuery,
        "onDestinationQueryChange" to onDestinationQueryChange,
        "onSelectRecommend" to onSelectRecommend,
        "onCollapse" to onCollapse
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .zIndex(1.0F)
    ) {
        item { MapOverlayExtendHeader(destinationQuery, onDestinationQueryChange, onCollapse) }
        itemsIndexed(searchDestinationResult) { index, item ->
            if (0 < index) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 3.dp)
                        .height(1.dp)
                        .background(Color.LightGray)
                )
            }
            MapRecommendedItem(item, onSelectRecommend)
        }
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayExtend_recommendedEmpty() {
    ParkingTheme {
        MapOverlayExtend()
    }
}

@Composable
@Preview(showBackground = true)
@SuppressLint("ComposableNaming")
fun preview_MapOverlayExtend_recommended() {
    ParkingTheme {
        MapOverlayExtend(
            destinationQuery = "AAA",
            searchDestinationResult = listOf(
                AAA_TOHO_TRADING,
                株式会社ＡＡＡ,
                AAA_ANNEX_GALLERY,
                AAA_NIHON_株式会社,
                GOOBNE_CHICKEN_曙橋店,
                AAA_TOHO_TRADING,
                株式会社ＡＡＡ,
                AAA_ANNEX_GALLERY,
                AAA_NIHON_株式会社,
                GOOBNE_CHICKEN_曙橋店,
                AAA_TOHO_TRADING,
                株式会社ＡＡＡ,
                AAA_ANNEX_GALLERY,
                AAA_NIHON_株式会社,
                GOOBNE_CHICKEN_曙橋店,
                AAA_TOHO_TRADING,
                株式会社ＡＡＡ,
                AAA_ANNEX_GALLERY,
                AAA_NIHON_株式会社,
                GOOBNE_CHICKEN_曙橋店
            )
        )
    }
}
