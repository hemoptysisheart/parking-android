package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.wizard.LocationInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.WizardFooter
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.LocationViewModel
import com.github.hemoptysisheart.parking.core.domain.place.toLatLng
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * 마법사 - 위치정보 권한
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54365-25110&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54310-34814&mode=design
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-649
 */
@Composable
fun LocationPageContent(
        interaction: LocationInteraction,
        granted: Boolean,
        location: Geolocation?,
        permissionRequestCount: Int,
        onRequestPermission: () -> Unit = { },
        onClose: () -> Unit = { }
) {
    LOGGER.v("#LocationPageContent args : granted=$granted, location=$location, permissionRequestCount=$permissionRequestCount")

    Column(Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp, 0.dp)) {
        if (granted) {
            location?.toLatLng()?.let { latLng ->
                val cameraPositionState = rememberCameraPositionState(LocationViewModel::class.qualifiedName) {
                    position = CameraPosition.fromLatLngZoom(latLng, 17F)
                }
                GoogleMap(
                        modifier = Modifier
                                .padding(0.dp, 40.dp)
                                .fillMaxWidth()
                                .height(400.dp),
                        cameraPositionState = cameraPositionState,
                        properties = MapProperties(
                                isBuildingEnabled = false,
                                isIndoorEnabled = false,
                                isMyLocationEnabled = true,
                                isTrafficEnabled = false
                        ),
                        uiSettings = MapUiSettings(
                                compassEnabled = false,
                                indoorLevelPickerEnabled = false,
                                mapToolbarEnabled = false,
                                myLocationButtonEnabled = false,
                                scrollGesturesEnabled = false,
                                rotationGesturesEnabled = false,
                                scrollGesturesEnabledDuringRotateOrZoom = false,
                                tiltGesturesEnabled = false,
                                zoomControlsEnabled = false,
                                zoomGesturesEnabled = false
                        )
                )
            }

            TextBodyMedium(
                    text = stringResource(R.string.page_wizard_location_granted),
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 40.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
            )
        } else {
            Text(
                    text = "🌏",
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                    fontSize = 200.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 200.sp
            )
        }

        Button(
                onClick = onRequestPermission,
                modifier = Modifier
                        .fillMaxWidth(),
                enabled = null == location && 2 > permissionRequestCount
        ) {
            TextBodyMedium(text = stringResource(R.string.page_wizard_location_request_permission_label))
        }

        if (!granted && 2 <= permissionRequestCount) {
            TextLabelMedium(
                    text = stringResource(R.string.page_wizard_location_denied),
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 40.dp),
                    color = MaterialTheme.colorScheme.onBackground
            )

            Button(onClick = interaction::openAppSetting, modifier = Modifier.fillMaxWidth()) {
                TextBodyMedium(text = stringResource(R.string.global_open_app_detail_settings))
            }
        }
        Spacer(modifier = Modifier.weight(1F))
        WizardFooter(onClose = onClose, onNext = interaction::close)
    }
}

class LocationPageContentParamProvider : PreviewParameterProvider<LocationPageContentParamProvider.Params> {
    data class Params(
            val granted: Boolean,
            val location: Geolocation?,
            val permissionRequestCount: Int
    )

    override val values: Sequence<Params> = listOf(
            Params(false, null, 0),
            Params(false, null, 1),
            Params(false, null, 2),
            Params(true, Geolocation(35.658114, 139.700103), 0),
            Params(true, Geolocation(35.658114, 139.700103), 1)
    ).asSequence()
}

@Composable
@PagePreview
fun Preview_LocationPageContent(
        @PreviewParameter(LocationPageContentParamProvider::class) params: LocationPageContentParamProvider.Params
) {
    PagePreviewContainer {
        LocationPageContent(
                interaction = LocationInteraction(it),
                granted = params.granted,
                location = params.location,
                permissionRequestCount = params.permissionRequestCount
        )
    }
}
