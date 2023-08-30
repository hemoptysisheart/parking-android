package com.github.hemoptysisheart.parking.app.ui.template.routenavigation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.resource.drawableResource
import com.github.hemoptysisheart.parking.app.ui.resource.toBitmapDescriptor
import com.github.hemoptysisheart.parking.app.viewmodel.main.RouteNavigationViewModel
import com.github.hemoptysisheart.parking.core.domain.place.toLatLng
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun ColumnScope.RouteNavigationMap(drive: SubRoute, walk: SubRoute, here: Geolocation) {
    val cameraPosition = rememberCameraPositionState(RouteNavigationViewModel::class.qualifiedName) {
        position = CameraPosition.fromLatLngZoom(here.toLatLng(), 17F)
    }

    ConstraintLayout(modifier = Modifier.weight(2F)) {
        val (mapRef) = createRefs()

        GoogleMap(
                modifier = Modifier
                        .fillMaxSize()
                        .constrainAs(mapRef) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                cameraPositionState = cameraPosition,
                properties = MapProperties(
                        isBuildingEnabled = true,
                        isIndoorEnabled = false,
                        isMyLocationEnabled = true
                ),
                uiSettings = MapUiSettings(
                        indoorLevelPickerEnabled = false,
                        mapToolbarEnabled = false,
                        myLocationButtonEnabled = false,
                        zoomControlsEnabled = false
                )
        ) {
            Marker(
                    state = rememberMarkerState("${walk.end}", walk.end.geolocation.toLatLng()),
                    icon = drawableResource(R.drawable.marker_destination).toBitmapDescriptor()
            )
            Marker(
                    state = rememberMarkerState("${walk.start}", walk.start.geolocation.toLatLng()),
                    icon = drawableResource(R.drawable.marker_parking).toBitmapDescriptor()
            )

            Polyline(
                    points = drive.overview.map { it.toLatLng() },
                    color = MaterialTheme.colorScheme.primary,
                    width = 10F
            )
            Polyline(
                    points = walk.overview.map { it.toLatLng() },
                    color = MaterialTheme.colorScheme.secondary,
                    width = 10F
            )
        }
    }
}

@Composable
@ComponentPreview
fun Preview_RouteNavigationMap() {
    ComponentPreviewContainer {
        // RouteNavigationMap()
    }
}
