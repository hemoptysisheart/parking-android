package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.interaction.wizard.LocationPermissionInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER
import com.github.hemoptysisheart.parking.app.ui.template.wizard.FooterTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun LocationPermissionPage(
    interaction: LocationPermissionInteraction
) {
    LOGGER.v("#LocationPermissionPage args : interaction=$interaction")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Text(text = "위치 권한 요청하기.", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.weight(1F))
        FooterTemplate(onClickSkip = interaction::skip, onClickNext = interaction::next)
    }
}

@Composable
@Preview(showSystemUi = true)
fun LocationPermissionPage() {
    ParkingTheme {
        LocationPermissionPage(interaction = LocationPermissionInteraction(commonInteraction()))
    }
}
