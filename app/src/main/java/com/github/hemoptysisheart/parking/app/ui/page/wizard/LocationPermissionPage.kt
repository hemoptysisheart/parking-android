package com.github.hemoptysisheart.parking.app.ui.page.wizard

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
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

    // TODO 유틸리티로 분리.
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(LocationPermissionViewModel::class) {
        lifecycle.addObserver(viewModel)
        onDispose {
            lifecycle.removeObserver(viewModel)
        }
    }

    val permission by viewModel.permission.collectAsStateWithLifecycle()
    val permissionRequestedCount by viewModel.permissionRequestedCount.collectAsStateWithLifecycle()

    val requestPermission = rememberRequestPermission(
        permission = Manifest.permission.ACCESS_FINE_LOCATION,
        onGranted = {}
    )

    LocationPermissionPageContent(
        interaction = interaction,
        permission = permission,
        permissionRequestedCount = permissionRequestedCount,
        onClickRequestPermission = {
            viewModel.onClickRequestPermission()
            requestPermission()
        }
    )
}

@Composable
fun LocationPermissionPageContent(
    interaction: LocationPermissionInteraction,
    permission: Boolean,
    permissionRequestedCount: Int,
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(
                R.string.permission_location_description,
                stringResource(R.string.app_name)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // TODO 템플릿으로 분리.
        when {
            permission -> Button(onClick = { }, enabled = false) {
                Text(
                    text = stringResource(
                        R.string.label_permission_request,
                        stringResource(R.string.permission_location)
                    )
                )
            }

            0 == permissionRequestedCount -> Button(onClick = onClickRequestPermission) {
                Text(
                    text = stringResource(
                        R.string.label_permission_request,
                        stringResource(R.string.permission_location)
                    )
                )
            }

            else -> {
                Text(
                    text = stringResource(
                        R.string.label_permission_maybe_not_allowed,
                        stringResource(R.string.permission_location),
                        stringResource(R.string.permission_location)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp)
                )
                if (1 == permissionRequestedCount) {
                    Button(onClick = onClickRequestPermission) {
                        Text(
                            text = stringResource(
                                R.string.label_permission_request,
                                stringResource(R.string.permission_location)
                            )
                        )
                    }
                }
                Button(onClick = interaction::gotoPermissionSetting) {
                    Text(text = stringResource(R.string.label_open_app_setting))
                }
            }
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
            permissionRequestedCount = 0,
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
            permissionRequestedCount = 0,
            permission = false
        )
    }
}
