package com.github.hemoptysisheart.parking.app.ui.template.search

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelLarge
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_오사키_1_11_2
import com.github.hemoptysisheart.parking.app.ui.template.LOGGER
import com.github.hemoptysisheart.parking.core.domain.place.toLatLng
import com.github.hemoptysisheart.parking.domain.place.Place
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * [``]()
 */
@Composable
fun PlaceDialogContent(place: Place) {
    LOGGER.v("#PlaceDialogContent args : place=$place")
    val state = rememberCameraPositionState("${place.id}") {
        position = CameraPosition.fromLatLngZoom(place.toLatLng(), 17F)
    }
    val uiSettings = remember(Place::class) {
        MapUiSettings(
                compassEnabled = false,
                indoorLevelPickerEnabled = false,
                mapToolbarEnabled = false,
                myLocationButtonEnabled = true,
                zoomControlsEnabled = false
        )
    }
    GoogleMap(
            modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4F / 3F),
            cameraPositionState = state,
            uiSettings = uiSettings
    ) {
        Marker(MarkerState(place.toLatLng()))
    }
    TextLabelLarge(text = place.name)
    TextBodyMedium(text = place.address)
}


@Composable
@ComponentPreview
fun Preview_PlaceDialogContent() {
    ComponentPreviewContainer {
        PlaceDialogContent(place = PLACE_로손편의점_오사키_1_11_2)
    }
}
