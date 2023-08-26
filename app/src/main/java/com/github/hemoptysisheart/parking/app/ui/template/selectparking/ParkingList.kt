package com.github.hemoptysisheart.parking.app.ui.template.selectparking

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.Divider
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHIONE_BIKE_LOCKER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHI_BUILDING_PARKING
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHI_FIRST_SQARE_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_PALACE_BLDG_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_TIMES_NIHON_SEIMEI_MARUNOUCHI_GARDEN_TOWER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_丸の内ガーデンタワー_バイク駐車場
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 목적지 주변의 주차장 목록.
 */
@Composable
fun ParkingList(
        parkingList: List<Place>
) {
    LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp)) {
        itemsIndexed(parkingList) { index, parking ->
            if (0 < index) {
                Divider()
            }
            ParkingListItem(parking)
        }
    }
}

@Composable
@ComponentPreview
fun Preview_ParkingList() {
    ComponentPreviewContainer {
        ParkingList(
                listOf(
                        PLACE_PALACE_BLDG_PARKING_LOT,
                        PLACE_OTEMACHI_FIRST_SQARE_PARKING_LOT,
                        PLACE_丸の内ガーデンタワー_バイク駐車場,
                        PLACE_TIMES_NIHON_SEIMEI_MARUNOUCHI_GARDEN_TOWER,
                        PLACE_OTEMACHI_BUILDING_PARKING,
                        PLACE_OTEMACHIONE_BIKE_LOCKER
                )
        )
    }
}
