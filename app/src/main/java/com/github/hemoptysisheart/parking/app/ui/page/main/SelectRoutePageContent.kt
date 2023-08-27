package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.GEOLOCATION_시부야역
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_MODE_GAKUEN_COCOON_TOWER_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_니시신주쿠_7_10_19
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.selectroute.SelectRouteHeader
import com.github.hemoptysisheart.parking.app.ui.template.selectroute.SelectRouteMap
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 경로 선택
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54312-34855&mode=design
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SelectRoutePageContent(
        interaction: SelectRouteInteraction,
        showOverlay: Boolean,
        here: Geolocation,
        parking: Place,
        destination: Place,
        toggleOverlay: () -> Unit = { }
) {
    BottomSheetScaffold(sheetContent = {
    }) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            SelectRouteMap(here, parking, destination, toggleOverlay)
            if (showOverlay) {
                SelectRouteHeader(destination, interaction::goBack)
            }
        }
    }
}


@Composable
@PagePreview
fun Preview_SelectRoutePageContent() {
    PagePreviewContainer {
        SelectRoutePageContent(
                SelectRouteInteraction(it),
                true,
                GEOLOCATION_시부야역,
                PLACE_MODE_GAKUEN_COCOON_TOWER_PARKING_LOT,
                PLACE_로손편의점_니시신주쿠_7_10_19
        )
    }
}
