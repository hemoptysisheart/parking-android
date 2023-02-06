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
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.ITEM_AAA_ANNEX_GALLERY
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.ITEM_AAA_NIHON_株式会社
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.ITEM_AAA_TOHO_TRADING
import com.github.hemoptysisheart.parking.app.ui.preview.RecommendItems.ITEM_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.domain.RecommendItem
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun MapOverlayExtend(
    query: String = "",
    recommended: List<RecommendItem<*>> = listOf(),
    onQueryChange: (String) -> Unit = {},
    onCollapse: () -> Unit = { }
) {
    logArgs(
        TAG_COMPOSE, "MapOverlayExtend",
        "query" to query,
        "onQueryChange" to onQueryChange,
        "onCollapse" to onCollapse
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .zIndex(1.0F)
    ) {
        MapOverlayExtendHeader(query, onQueryChange, onCollapse)

        LazyColumn {
            itemsIndexed(recommended) { index, item ->
                if (0 < index) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp, 3.dp)
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                }
                Text(text = item.toString())
            }
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
            query = "AAA",
            recommended = listOf(
                ITEM_AAA_TOHO_TRADING, ITEM_株式会社ＡＡＡ, ITEM_AAA_ANNEX_GALLERY, ITEM_AAA_NIHON_株式会社,
                ITEM_AAA_TOHO_TRADING, ITEM_株式会社ＡＡＡ, ITEM_AAA_ANNEX_GALLERY, ITEM_AAA_NIHON_株式会社,
                ITEM_AAA_TOHO_TRADING, ITEM_株式会社ＡＡＡ, ITEM_AAA_ANNEX_GALLERY, ITEM_AAA_NIHON_株式会社,
                ITEM_AAA_TOHO_TRADING, ITEM_株式会社ＡＡＡ, ITEM_AAA_ANNEX_GALLERY, ITEM_AAA_NIHON_株式会社,
                ITEM_AAA_TOHO_TRADING, ITEM_株式会社ＡＡＡ, ITEM_AAA_ANNEX_GALLERY, ITEM_AAA_NIHON_株式会社
            )
        )
    }
}