package com.github.hemoptysisheart.parking.app.ui.page.wizard

import android.Manifest.permission.ACCESS_FINE_LOCATION
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.hemoptysisheart.parking.app.interaction.wizard.LocationInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewLocationModel
import com.github.hemoptysisheart.parking.app.ui.preview.previewLocationViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.support.requestPermission
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
 * [마법사](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-649)
 */
@Composable
fun LocationPage(
        interaction: LocationInteraction,
        viewModel: LocationViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#LocationPage args : interaction=$interaction")

    val granted = viewModel.granted.collect()
    val permissionRequestCount = viewModel.permissionRequestCount.collect()
    val location = viewModel.location.collect()

    val launchRequestDialog = requestPermission(permission = ACCESS_FINE_LOCATION)

    LocationPageContent(
            interaction = interaction,
            granted = granted,
            location = location,
            permissionRequestCount = permissionRequestCount,
            onRequestPermission = {
                viewModel.onClickRequestPermission()
                launchRequestDialog()
            }
    )
}

@Composable
internal fun LocationPageContent(
        interaction: LocationInteraction,
        granted: Boolean,
        location: Geolocation?,
        permissionRequestCount: Int,
        onRequestPermission: () -> Unit = { }
) {
    LOGGER.v("#LocationPageContent args : granted=$granted, location=$location, permissionRequestCount=$permissionRequestCount")

    Column(Modifier
            .fillMaxSize()
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
            TextBodyMedium(text = "권한 요청하기")
        }

        if (!granted && 2 <= permissionRequestCount) {
            TextLabelMedium(text = "위치정보 권한을 얻지 못했습니다. 만약 위치정보 권한을 요청해도 승인 다이얼로그 보이지 않는다면 앱 설정에서 권한을 주기 바랍니다.")

            Button(onClick = interaction::openAppSetting, modifier = Modifier.fillMaxWidth()) {
                TextBodyMedium(text = "앱 설정 열기")
            }
        }
        Spacer(modifier = Modifier.weight(1F))
        WizardFooter(onClose = interaction::close, onNext = interaction::close)
    }
}

@Composable
@PagePreview
fun Preview_LocationPage_granted() {
    PagePreviewContainer {
        LocationPage(
                interaction = LocationInteraction(it),
                viewModel = previewLocationViewModel()
        )
    }
}

@Composable
@PagePreview
fun Preview_LocationPage_dined() {
    PagePreviewContainer {
        LocationPage(
                interaction = LocationInteraction(it),
                viewModel = previewLocationViewModel(
                        previewLocationModel(
                                granted = false,
                                geolocation = Geolocation(0.0, 0.0)
                        )
                )
        )
    }
}
