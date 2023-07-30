package com.github.hemoptysisheart.parking.app.ui.page.launcher

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.ui.interaction.launcher.LauncherInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.rememberCommonInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.launcher.LauncherViewModel

@Composable
fun LauncherPage(
    interaction: LauncherInteraction,
    viewModel: LauncherViewModel = hiltViewModel()
) {
    LOGGER.v("#LauncherPage args : interaction=$interaction")

    Text(text = "$viewModel")
}

@Composable
@Preview(showSystemUi = true)
fun Preview_LauncherPage() {
    ParkingTheme {
        LauncherPage(LauncherInteraction(rememberCommonInteraction()))
    }
}
