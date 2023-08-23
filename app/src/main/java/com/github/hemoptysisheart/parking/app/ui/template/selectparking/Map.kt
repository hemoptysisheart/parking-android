package com.github.hemoptysisheart.parking.app.ui.template.selectparking

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHIONE_BIKE_LOCKER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHI_BUILDING_PARKING
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_OTEMACHI_FIRST_SQARE_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_PALACE_BLDG_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_TIMES_NIHON_SEIMEI_MARUNOUCHI_GARDEN_TOWER
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_丸の内ガーデンタワー_バイク駐車場
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_니시신주쿠_7_10_19
import com.github.hemoptysisheart.parking.app.ui.resource.drawableResource
import com.github.hemoptysisheart.parking.app.ui.resource.toBitmapDescriptor
import com.github.hemoptysisheart.parking.core.domain.place.toLatLng
import com.github.hemoptysisheart.parking.domain.place.Place
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

/**
 * 목적지와 목적지 주변의 주차장을 지도로 보여준다.
 */
@Composable
fun Map(
        destination: Place,
        parkingList: List<Place>,
        onClick: () -> Unit = { }
) {
    GoogleMap(
            modifier = Modifier
                    .fillMaxSize(),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(destination.toLatLng(), 16F)
            },
            uiSettings = MapUiSettings(indoorLevelPickerEnabled = false),
            onMapClick = { onClick() }
    ) {
        Marker(
                state = rememberMarkerState("${destination.id.toURI()}", destination.toLatLng()),
                icon = drawableResource(R.drawable.marker_destination).toBitmapDescriptor()
        )
        for (p in parkingList) {
            Marker(
                    state = rememberMarkerState("${p.id.toURI()}", p.toLatLng()),
                    icon = drawableResource(R.drawable.marker_parking).toBitmapDescriptor()
            )
        }
    }
}


@Composable
@ComponentPreview
fun Preview_Map() {
    ComponentPreviewContainer {
        Map(
                destination = PLACE_로손편의점_니시신주쿠_7_10_19,
                parkingList = listOf(
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
