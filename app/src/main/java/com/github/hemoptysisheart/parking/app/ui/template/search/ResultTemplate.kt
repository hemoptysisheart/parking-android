@file:OptIn(ExperimentalComposeUiApi::class)

package com.github.hemoptysisheart.parking.app.ui.template.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.search.RecommendedItem
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRecommendItem.ITEM_AAA_ANNEX_GALLERY
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRecommendItem.ITEM_AAA_NIHON_株式会社
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRecommendItem.ITEM_AAA_TOHO_TRADING
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRecommendItem.ITEM_GOOBNE_CHICKEN_曙橋店
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRecommendItem.ITEM_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItem

@Composable
fun SearchResultTemplate(
    here: Location = GeoLocation(0.0, 0.0),
    resultList: List<RecommendItem<*>> = listOf(),
    hideSoftKeyboard: () -> Unit = {},
    onSelect: (RecommendItem<*>) -> Unit = {}
) {
    val state = rememberLazyListState()
    if (state.isScrollInProgress) {
        hideSoftKeyboard()
    }

    LazyColumn(modifier = Modifier.fillMaxWidth(), state = state) {
        itemsIndexed(resultList) { index, item ->
            if (0 < index) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 3.dp)
                        .height(1.dp)
                        .background(Color.LightGray)
                )
            }
            RecommendedItem(item = item, here = here, onSelect = onSelect)
        }
    }
}

@Composable
@Preview(showBackground = true)
@Suppress("NonAsciiCharacters")
fun Preview_SearchResultTemplate_결과_없음() {
    ParkingTheme {
        SearchResultTemplate()
    }
}

@Composable
@Preview(showBackground = true)
@Suppress("NonAsciiCharacters")
fun Preview_SearchResultTemplate_결과_있음() {
    ParkingTheme {
        SearchResultTemplate(
            resultList = listOf(
                ITEM_AAA_TOHO_TRADING,
                ITEM_株式会社ＡＡＡ,
                ITEM_AAA_ANNEX_GALLERY,
                ITEM_AAA_NIHON_株式会社,
                ITEM_GOOBNE_CHICKEN_曙橋店,
                ITEM_AAA_TOHO_TRADING,
                ITEM_株式会社ＡＡＡ,
                ITEM_AAA_ANNEX_GALLERY,
                ITEM_AAA_NIHON_株式会社,
                ITEM_GOOBNE_CHICKEN_曙橋店,
                ITEM_AAA_TOHO_TRADING,
                ITEM_株式会社ＡＡＡ,
                ITEM_AAA_ANNEX_GALLERY,
                ITEM_AAA_NIHON_株式会社,
                ITEM_GOOBNE_CHICKEN_曙橋店,
                ITEM_AAA_TOHO_TRADING,
                ITEM_株式会社ＡＡＡ,
                ITEM_AAA_ANNEX_GALLERY,
                ITEM_AAA_NIHON_株式会社,
                ITEM_GOOBNE_CHICKEN_曙橋店
            )
        )
    }
}