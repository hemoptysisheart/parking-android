package com.github.hemoptysisheart.parking.app.ui.molecule.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.domain.distance
import com.github.hemoptysisheart.parking.app.ui.atom.Distance
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRecommendItem.ITEM_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItem
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun RecommendedItem(
    item: RecommendItem<*>,
    here: Location = GeoLocation(0.0, 0.0),
    onSelect: (RecommendItem<*>) -> Unit = {}
) {
    LOGGER.v("#MapRecommendedItem args : item=$item, onSelectRecommend=$onSelect")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(item) }
            .padding(20.dp, 7.dp)
    ) {
        Text(text = item.summary)
        item.detail?.let { detail ->
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = detail, color = Color.Gray)

            item.item?.apply {
                when (this) {
                    is Location ->
                        Distance(distance = distance(here))
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_MapRecommendedItem_GmpPlace() {
    ParkingTheme {
        RecommendedItem(ITEM_株式会社ＡＡＡ)
    }
}
