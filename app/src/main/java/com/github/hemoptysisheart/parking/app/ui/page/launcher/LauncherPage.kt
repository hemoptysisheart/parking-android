package com.github.hemoptysisheart.parking.app.ui.page.launcher

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.launcher.LauncherInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.launcher.LauncherViewModel

@Composable
fun LauncherPage(
    interaction: LauncherInteraction,
    viewModel: LauncherViewModel = hiltViewModel()
) {
    LOGGER.v("#LauncherPage args : interaction=$interaction")

    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1F))
        EasyButton(onClick = interaction::gotoWizard, label = "마법사")
        EasyButton(onClick = interaction::gotoLandingMap, label = "랜딩맵")
        Spacer(modifier = Modifier.weight(1F))
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_LauncherPage() {
    ParkingTheme {
        LauncherPage(LauncherInteraction(baseInteraction(PreviewActivity())))
    }
}
