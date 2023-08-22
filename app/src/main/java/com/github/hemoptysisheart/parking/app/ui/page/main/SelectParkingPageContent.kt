package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_스미요시_2_22
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.core.domain.place.toLatLng
import com.github.hemoptysisheart.parking.domain.place.Place
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

/**
 * [주차장 선택](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-673)
 */
@Composable
fun SelectParkingPageContent(
        interaction: SelectParkingInteraction,
        destination: Place,
        parkingList: List<Place>
) {
    GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(destination.toLatLng(), 16F)
            },
            properties = MapProperties(
                    isBuildingEnabled = true,
                    isMyLocationEnabled = true
            ),
            uiSettings = MapUiSettings(
                    indoorLevelPickerEnabled = false,
                    zoomGesturesEnabled = false
            )
    ) {
        Marker(state = rememberMarkerState("${destination.id.toURI()}", destination.toLatLng()))
        for (p in parkingList) {
            Marker(state = rememberMarkerState("${p.id.toURI()}", p.toLatLng()))
        }
    }
}


@Composable
@PagePreview
fun Preview_SelectParkingPageContent() {
    PagePreviewContainer {
        SelectParkingPageContent(SelectParkingInteraction(it), PLACE_로손편의점_스미요시_2_22, emptyList())
    }
}
