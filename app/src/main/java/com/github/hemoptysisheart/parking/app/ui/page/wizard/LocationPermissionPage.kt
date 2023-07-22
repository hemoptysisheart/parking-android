package com.github.hemoptysisheart.parking.app.ui.page.wizard

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.interaction.wizard.LocationPermissionInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.LOCATION_PERMISSION_VIEW_MODEL
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.support.rememberRequestPermission
import com.github.hemoptysisheart.parking.app.ui.template.wizard.FooterTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.LocationPermissionViewModel
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun LocationPermissionPage(
    interaction: LocationPermissionInteraction,
    viewModel: LocationPermissionViewModel = hiltViewModel()
) {
    LOGGER.v("#LocationPermissionPage args : interaction=$interaction, viewModel=$viewModel")

    val permission by viewModel.permission.collectAsStateWithLifecycle()
    val requestPermission = rememberRequestPermission(
        permission = Manifest.permission.ACCESS_FINE_LOCATION,
        onGranted = viewModel::refreshPermission,
        onDenied = viewModel::refreshPermission
    )

    LocationPermissionPageContent(
        interaction = interaction,
        permission = permission,
        onClickRequestPermission = requestPermission::invoke
    )
}

@Composable
fun LocationPermissionPageContent(
    interaction: LocationPermissionInteraction,
    permission: Boolean,
    onClickRequestPermission: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Text(
            text = stringResource(R.string.permission_location),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onClickRequestPermission, enabled = !permission) {
            Text(
                text = if (permission) {
                    stringResource(R.string.permission_location_granted, stringResource(R.string.permission_location))
                } else {
                    stringResource(R.string.permission_location_request, stringResource(R.string.permission_location))
                }
            )
        }
        Spacer(modifier = Modifier.weight(1F))
        FooterTemplate(onClickSkip = interaction::skip, onClickNext = interaction::next)
    }
}

@Composable
@Preview(showSystemUi = true)
fun VmPreview_LocationPermissionPage() {
    ParkingTheme {
        LocationPermissionPage(
            LocationPermissionInteraction(commonInteraction()),
            LOCATION_PERMISSION_VIEW_MODEL
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_LocationPermissionPageContentGranted() {
    ParkingTheme {
        LocationPermissionPageContent(
            interaction = LocationPermissionInteraction(commonInteraction()),
            permission = true
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_LocationPermissionPageContentNotGranted() {
    ParkingTheme {
        LocationPermissionPageContent(
            interaction = LocationPermissionInteraction(commonInteraction()),
            permission = false
        )
    }
}
