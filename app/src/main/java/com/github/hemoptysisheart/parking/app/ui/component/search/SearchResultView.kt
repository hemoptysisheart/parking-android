package com.github.hemoptysisheart.parking.app.ui.component.search

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.configuration.UiConstants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.core.dummy.model.data.DummySearchResult
import com.github.hemoptysisheart.parking.core.model.data.SearchResult
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import java.util.*

@Composable
fun SearchResultView(result: SearchResult, onClick: (UUID) -> Unit = {}) {
    Log.v(TAG_COMPOSE, "#SearchResultView args : result=$result")

    LazyColumn() {
        itemsIndexed(result.list) { index, item ->
            SearchResultItemView(index, item, onClick)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSearchResultView() {
    ParkingTheme {
        SearchResultView(result = DummySearchResult.RESULT_0)
    }
}
