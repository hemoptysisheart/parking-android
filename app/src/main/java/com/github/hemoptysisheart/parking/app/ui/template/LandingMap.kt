package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.GEOLOCATION_시부야역
import com.github.hemoptysisheart.parking.app.viewmodel.LandingMapViewModel
import com.github.hemoptysisheart.parking.core.domain.place.toLatLng
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * [`map`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54303-34810&mode=design)
 *
 * @param center 지도 중심.
 * @param zoom 지도 확대 수준.
 * @param toggleOverlay 지도 클릭으로 오버레이 표시/숨김 전환.
 */
@Composable
fun LandingMap(
        center: Geolocation,
        zoom: Float,
        toggleOverlay: () -> Unit = { }
) {
    val cameraPositionState = rememberCameraPositionState(LandingMapViewModel::class.qualifiedName)
    cameraPositionState.position = CameraPosition.fromLatLngZoom(center.toLatLng(), zoom)

    val properties = remember(LandingMapViewModel::class) {
        MapProperties(isBuildingEnabled = true, isMyLocationEnabled = true)
    }
    val uiSettings = remember(LandingMapViewModel::class) {
        MapUiSettings(
                compassEnabled = false,
                indoorLevelPickerEnabled = false,
                mapToolbarEnabled = false,
                myLocationButtonEnabled = false,
                zoomControlsEnabled = false
        )
    }
    GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings,
            onMapClick = { toggleOverlay() }
    )
}


@Composable
@ComponentPreview
fun Preview_LandingMap() {
    ComponentPreviewContainer {
        LandingMap(GEOLOCATION_시부야역, 17F)
    }
}
