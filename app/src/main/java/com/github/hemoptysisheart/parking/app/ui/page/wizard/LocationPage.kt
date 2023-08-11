package com.github.hemoptysisheart.parking.app.ui.page.wizard

import android.Manifest.permission.ACCESS_FINE_LOCATION
import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.interaction.wizard.LocationInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewLocationViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.support.requestPermission
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.LocationViewModel

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
            },
            onClose = interaction::close
    )
}

@Composable
@PagePreview
fun Preview_LocationPage() {
    PagePreviewContainer {
        LocationPage(
                interaction = LocationInteraction(it),
                viewModel = previewLocationViewModel()
        )
    }
}
