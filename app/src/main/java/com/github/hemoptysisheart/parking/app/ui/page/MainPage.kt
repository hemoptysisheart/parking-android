package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.ui.interaction.MainInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.MAIN_VM
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER
import com.github.hemoptysisheart.parking.app.ui.template.main.HeaderTemplate
import com.github.hemoptysisheart.parking.app.ui.template.main.MapTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel

@Composable
fun MainPage(
    interaction: MainInteraction,
    viewModel: MainViewModel = hiltViewModel()
) {
    LOGGER.v("#MainPage args : interaction=$interaction, viewModel=$viewModel")

    val showHeader by viewModel.showHeader.collectAsStateWithLifecycle()
    val cameraGoto by viewModel.cameraGoto.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        if (showHeader) {
            HeaderTemplate { interaction.search() }
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
        MainPage(
            MainInteraction(commonInteraction()),
            MAIN_VM
        )
    }
}
