package com.github.hemoptysisheart.parking.app.ui.page.launcher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.app.interaction.launcher.LauncherInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.viewmodel.launcher.LauncherViewModel

/**
 * [스플래시](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-641)
 */
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
@PagePreview
fun Preview_LauncherPage() {
    PagePreviewContainer {
        LauncherPage(LauncherInteraction(it))
    }
}