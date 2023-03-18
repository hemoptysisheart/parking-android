package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.navigation.MainPageNavigation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.MAIN_VM
import com.github.hemoptysisheart.parking.app.ui.template.HeaderTemplate
import com.github.hemoptysisheart.parking.app.ui.template.MapTemplate
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.configuration.LOGGER_COMPOSE as LOGGER

@Composable
fun MainPage(
    navigation: MainPageNavigation = MainPageNavigation(rememberNavController()),
    viewModel: MainViewModel = hiltViewModel()
) {
    LOGGER.v("#MainPage args : viewModel=$viewModel")

    val showHeader by viewModel.showHeader.collectAsStateWithLifecycle()
    val cameraGoto by viewModel.cameraGoto.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        if (showHeader) {
            HeaderTemplate { navigation.search() }
        }

        MapTemplate(
            cameraGoto,
            viewModel.onCameraPositionChange,
            viewModel.onMapClick
        )
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview_MainPage() {
    ParkingTheme {
        MainPage(viewModel = MAIN_VM)
    }
}
