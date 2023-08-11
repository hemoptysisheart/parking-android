package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.hemoptysisheart.parking.app.interaction.wizard.LocationInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewLocationModel
import com.github.hemoptysisheart.parking.app.ui.preview.previewLocationViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.template.WizardFooter
import com.github.hemoptysisheart.parking.app.ui.theme.Typography
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

    LocationPageContent(
            interaction = interaction,
            granted = granted,
            location = viewModel.location
    )
}

@Composable
internal fun LocationPageContent(
        interaction: LocationInteraction,
        granted: Boolean,
        location: Geolocation? = null
) {
    Column(Modifier.fillMaxSize()) {
        if (granted) {
            location?.toLatLng()?.let { latLng ->
                val cameraPositionState = rememberCameraPositionState(LocationViewModel::class.qualifiedName) {
                    position = CameraPosition.fromLatLngZoom(latLng, 17F)
                }
                GoogleMap(
                        modifier = Modifier
                                .padding(20.dp)
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
        Text(
                text = """
                1. 위치정보 권한을 요청한다.
                2. 위치정보를 얻지 못한 경우, 앱 설정으로 안내한다.
                3. 마법사를 종료한다.
                """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                style = Typography.bodyLarge
        )
        EasyButton(onClick = interaction::requestPermission, label = "시스템 위치 권한 요청")
        EasyButton(onClick = interaction::openAppSetting, label = "앱 설정 열기")
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
