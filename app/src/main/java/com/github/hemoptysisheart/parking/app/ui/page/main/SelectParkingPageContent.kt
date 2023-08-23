package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.BackButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodySmall
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_스미요시_2_22
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
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
    BottomSheetScaffold(sheetContent = {
        // TODO 템플릿으로 분리
        LazyColumn(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp)
        ) {
            items(items = parkingList) {
                Text(text = "$it") // TODO UI 작성
            }
        }
    }) {
        Box(modifier = Modifier.fillMaxSize()) {
            GoogleMap(
                    modifier = Modifier
                            .fillMaxSize(),
                    cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(destination.toLatLng(), 16F)
                    },
                    uiSettings = MapUiSettings(indoorLevelPickerEnabled = false),
                    onMapClick = { toggleOverlay() }
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

            if (showOverlay) {
                // TODO 오버레이를 템플릿으로 분리
                Row(
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    BackButton(onClick = interaction::goBack)
                    Column(
                            modifier = Modifier
                                    .weight(1F)
                                    .background(MaterialTheme.colorScheme.background, RoundedCornerShape(30.dp))
                                    .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(30.dp))
                                    .padding(20.dp, 10.dp),
                            verticalArrangement = Arrangement.Center
                    ) {
                        TextLabelMedium(
                                text = destination.name,
                                color = MaterialTheme.colorScheme.onBackground,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                        )
                        TextBodySmall(
                                text = destination.address,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                                imageVector = Icons.Default.Flag,
                                contentDescription = stringResource(R.string.page_select_parking_label_destination),
                                tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                                imageVector = Icons.Default.MyLocation,
                                contentDescription = stringResource(R.string.page_select_parking_label_here),
                                tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
    }
}

@Composable
@PagePreview
fun Preview_SelectParkingPageContent() {
    PagePreviewContainer {
        SelectParkingPageContent(SelectParkingInteraction(it), PLACE_로손편의점_스미요시_2_22, emptyList(), true)
    }
}
