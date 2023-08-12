package com.github.hemoptysisheart.parking.app.ui.page.launcher

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.activity.WizardActivity
import com.github.hemoptysisheart.parking.app.interaction.launcher.LauncherInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.TextDisplayLarge
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewLauncherViewModel
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.launcher.LauncherViewModel

/**
 * 런처 화면(`launcher`)
 *
 * 앱을 실행하고 초기화에 필요한 시간을 벌면서 사용자에게 필요한 정보를 전달한다.
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54316-24308&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54303-34813&mode=design
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-641
 */
@Composable
fun LauncherPage(
        interaction: LauncherInteraction,
        viewModel: LauncherViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#LauncherPage args : interaction=$interaction")

    val target = viewModel.target.collect()
    LOGGER.i("#LauncherPage : target=$target")
    when (target) {
        WizardActivity::class -> interaction.gotoWizard()
        MainActivity::class -> interaction.gotoLandingMap()
        else -> LOGGER.e("#LauncherPage illegal target : target=$target")
    }

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(20.dp, 0.dp),
            verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit
        )
        TextDisplayLarge(
                text = stringResource(R.string.page_launcher_slogan),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp, 0.dp),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(2F))
    }
}

@Composable
@PagePreview
fun Preview_LauncherPage() {
    PagePreviewContainer {
        LauncherPage(
                interaction = LauncherInteraction(it),
                viewModel = previewLauncherViewModel()
        )
    }
}
