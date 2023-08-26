package com.github.hemoptysisheart.parking.app.ui.template.selectparking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.util.NonNegativeInt
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

/**
 * 목적지와 목적지 주변의 주차장을 지도로 보여준다.
 */
@Composable
fun Map(
        here: Geolocation,
        destination: Place,
        parkingRadius: NonNegativeInt,
        parkingList: List<Place>,
        onClick: () -> Unit = { },
        onMoveCamera: (LatLng, Float) -> Unit = { _, _ -> }
) {
    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(destination.toLatLng(), 16F)
    }
    if (cameraPosition.isMoving) {
        onMoveCamera(cameraPosition.position.target, cameraPosition.position.zoom)
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (mapRef, hereRef, destRef) = createRefs()

        GoogleMap(
                modifier = Modifier
                        .fillMaxSize()
                        .constrainAs(mapRef) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                cameraPositionState = cameraPosition,
                properties = MapProperties(isMyLocationEnabled = true),
                uiSettings = MapUiSettings(indoorLevelPickerEnabled = false, myLocationButtonEnabled = false),
                onMapClick = { onClick() }
        ) {
            Circle(
                    center = destination.toLatLng(),
                    fillColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4F),
                    radius = parkingRadius.value.toDouble(),
                    strokeColor = MaterialTheme.colorScheme.primaryContainer,
                    strokeWidth = 3F
            )
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
                    contentDescription = stringResource(R.string.page_select_parking_label_destination),
                    tint = MaterialTheme.colorScheme.onSurface
            )
        }
        IconButton(
                onClick = { cameraPosition.move(CameraUpdateFactory.newLatLng(here.toLatLng())) },
                modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(30.dp))
                        .constrainAs(hereRef) {
                            top.linkTo(parent.top, 10.dp)
                            end.linkTo(destRef.start, 10.dp)
                        }
        ) {
            Icon(
                    imageVector = Icons.Default.MyLocation,
                    contentDescription = stringResource(R.string.page_select_parking_label_here),
                    tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}


@Composable
@ComponentPreview
fun Preview_Map() {
    ComponentPreviewContainer {
        Map(
                here = PLACE_로손편의점_니시신주쿠_7_10_19.geolocation,
                destination = PLACE_로손편의점_니시신주쿠_7_10_19,
                parkingRadius = NonNegativeInt(200),
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
