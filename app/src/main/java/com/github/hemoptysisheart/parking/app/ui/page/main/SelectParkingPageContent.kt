package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHIONE_BIKE_LOCKER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHI_BUILDING_PARKING
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHI_FIRST_SQARE_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_PALACE_BLDG_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_TIMES_NIHON_SEIMEI_MARUNOUCHI_GARDEN_TOWER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_丸の内ガーデンタワー_バイク駐車場
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_스미요시_2_22
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.selectparking.Map
import com.github.hemoptysisheart.parking.app.ui.template.selectparking.ParkingList
import com.github.hemoptysisheart.parking.app.ui.template.selectparking.SelectParkingHeader
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * [주차장 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-673)
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SelectParkingPageContent(
        interaction: SelectParkingInteraction,
        destination: Place,
        parkingList: List<Place>,
        showOverlay: Boolean,
        toggleOverlay: () -> Unit = { }
) {
    LOGGER.v("#SelectParkingPageContent args : destination=$destination, parkingList=$parkingList, showOverlay=$showOverlay")
    BottomSheetScaffold(
            sheetContent = {
                if (showOverlay) {
                    ParkingList(parkingList)
                }
            },
            sheetPeekHeight = if (showOverlay) {
                200.dp
            } else {
                0.dp
            }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Map(destination, parkingList, toggleOverlay)
            if (showOverlay) {
                SelectParkingHeader(destination, interaction::goBack)
            }
        }
    }
}

@Composable
@PagePreview
fun Preview_SelectParkingPageContent() {
    PagePreviewContainer {
        SelectParkingPageContent(
                interaction = SelectParkingInteraction(it),
                destination = PLACE_로손편의점_스미요시_2_22,
                parkingList = listOf(
                        PLACE_PALACE_BLDG_PARKING_LOT,
                        PLACE_OTEMACHI_FIRST_SQARE_PARKING_LOT,
                        PLACE_丸の内ガーデンタワー_バイク駐車場,
                        PLACE_TIMES_NIHON_SEIMEI_MARUNOUCHI_GARDEN_TOWER,
                        PLACE_OTEMACHI_BUILDING_PARKING,
                        PLACE_OTEMACHIONE_BIKE_LOCKER
                ),
                showOverlay = true
        )
    }
}
