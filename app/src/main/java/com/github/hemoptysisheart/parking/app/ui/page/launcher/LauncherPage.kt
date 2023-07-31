package com.github.hemoptysisheart.parking.app.ui.page.launcher

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = """
                - 로고
                - 카피라이트
            """.trimIndent(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        EasyButton(onClick = interaction::gotoWizard, label = "마법사")
        EasyButton(onClick = interaction::gotoLandingMap, label = "랜딩맵")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_LauncherPage() {
    ParkingTheme {
        LauncherPage(LauncherInteraction(baseInteraction(PreviewActivity())))
    }
}
