package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.main.GlobalHeaderInteraction
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.GlobalHeaderViewModel

@Composable
fun GlobalHeader(
    interaction: GlobalHeaderInteraction,
    viewModel: GlobalHeaderViewModel = hiltBaseViewModel()
) {
    val p by viewModel.p.collectAsStateWithLifecycle()

    if (p) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_GlobalHeader() {
    ParkingTheme {
        GlobalHeader(GlobalHeaderInteraction(baseInteraction(PreviewActivity())))
    }
}
