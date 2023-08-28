package com.github.hemoptysisheart.parking.app.ui.template.selectroute

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.hemoptysisheart.parking.R.drawable.marker_destination
import com.github.hemoptysisheart.parking.R.drawable.marker_parking
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.GEOLOCATION_시부야역
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_MODE_GAKUEN_COCOON_TOWER_PARKING_LOT
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_니시신주쿠_7_10_19
import com.github.hemoptysisheart.parking.app.ui.resource.drawableResource
import com.github.hemoptysisheart.parking.app.ui.resource.toBitmapDescriptor
import com.github.hemoptysisheart.parking.core.R.string.domain_geolocation_here
import com.github.hemoptysisheart.parking.core.R.string.domain_place_type_destination
import com.github.hemoptysisheart.parking.core.R.string.domain_place_type_parking
import com.github.hemoptysisheart.parking.core.domain.place.toLatLng
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.route.Route
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun SelectRouteMap(
        here: Geolocation,
        parking: Place,
        destination: Place,
        routeList: List<Route>,
        toggleOverlay: () -> Unit = { }
) {
    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(destination.toLatLng(), 16F)
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (mapRef, hereRef, parkingRef, destRef) = createRefs()

        GoogleMap(
                modifier = Modifier
                        .fillMaxSize()
                        .constrainAs(mapRef) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        },
                cameraPositionState = cameraPosition,
                properties = MapProperties(isMyLocationEnabled = true),
                uiSettings = MapUiSettings(
                        indoorLevelPickerEnabled = false,
                        mapToolbarEnabled = false,
                        myLocationButtonEnabled = false,
                        zoomControlsEnabled = false
                ),
                onMapClick = { toggleOverlay() }
        ) {
            Marker(
                    state = rememberMarkerState("${destination.id.toURI()}", destination.toLatLng()),
                    icon = drawableResource(marker_destination).toBitmapDescriptor()
            )
            Marker(
                    state = rememberMarkerState("${parking.id.toURI()}", parking.toLatLng()),
                    icon = drawableResource(marker_parking).toBitmapDescriptor()
            )
            for (route in routeList) {
                // TODO 경로 그리기.
            }
        }

        IconButton(
                onClick = { cameraPosition.move(CameraUpdateFactory.newLatLng(destination.toLatLng())) },
                modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(30.dp))
                        .constrainAs(destRef) {
                            top.linkTo(parent.top, 10.dp)
                            end.linkTo(parent.end, 10.dp)
                        }
        ) {
            Icon(
                    imageVector = Icons.Default.Flag,
                    contentDescription = stringResource(domain_place_type_destination),
                    tint = MaterialTheme.colorScheme.onSurface
            )
        }
        IconButton(
                onClick = { cameraPosition.move(CameraUpdateFactory.newLatLng(parking.toLatLng())) },
                modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(30.dp))
                        .constrainAs(parkingRef) {
                            top.linkTo(parent.top, 10.dp)
                            end.linkTo(destRef.start, 10.dp)
                        }
        ) {
            Icon(
                    imageVector = Icons.Default.LocalParking,
                    contentDescription = stringResource(domain_place_type_parking)
            )
        }
        IconButton(
                onClick = { cameraPosition.move(CameraUpdateFactory.newLatLng(here.toLatLng())) },
                modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(30.dp))
                        .constrainAs(hereRef) {
                            top.linkTo(parent.top, 10.dp)
                            end.linkTo(parkingRef.start, 10.dp)
                        }
        ) {
            Icon(
                    imageVector = Icons.Default.MyLocation,
                    contentDescription = stringResource(domain_geolocation_here),
                    tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
@ComponentPreview
fun Preview_RouteMap() {
    ComponentPreviewContainer {
        SelectRouteMap(
                GEOLOCATION_시부야역,
                PLACE_MODE_GAKUEN_COCOON_TOWER_PARKING_LOT,
                PLACE_로손편의점_니시신주쿠_7_10_19,
                emptyList()
        )
    }
}
