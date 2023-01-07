package com.github.hemoptysisheart.parking.app.ui.component.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.hemoptysisheart.parking.app.ui.configuration.UiConstants.TAG_COMPOSE
import com.github.hemoptysisheart.parking.core.dummy.model.data.DummySearchResultItem
import com.github.hemoptysisheart.parking.core.model.data.SearchResultItem
import com.github.hemoptysisheart.parking.core.model.data.SearchResultItemType
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import java.util.*

@Composable
fun SearchResultItemView(index: Int, item: SearchResultItem, onClick: (id: UUID) -> Unit = {}) {
    Log.v(TAG_COMPOSE, "#SearchResultItemView args : index=$index, item=$item, onClick=$onClick")

    if (0 < index) {
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(3.dp)
        )
    }

    Row(
        Modifier
            .padding(5.dp)
            .clickable { onClick(item.id) }
    ) {
        Column(
            modifier = Modifier.padding(0.dp, 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (item.type) {
                SearchResultItemType.GOOGLE_PLACE ->
                    Icon(Icons.Default.Search, "Google Places API")
            }
        }
        Spacer(modifier = Modifier.width(3.dp))
        Column {
            Text(text = item.name, fontSize = 21.sp, fontWeight = FontWeight.Bold)
            Text(text = item.address, color = Color.LightGray, fontSize = 14.sp)
        }
    }
}

@Composable
@Preview(name = "Google Places API 검색 결과.", showBackground = true)
fun PreviewSearchResultItemView_GOOGLE_PLACES() {
    ParkingTheme {
        SearchResultItemView(index = 0, item = DummySearchResultItem.GMP_0)
    }
}
