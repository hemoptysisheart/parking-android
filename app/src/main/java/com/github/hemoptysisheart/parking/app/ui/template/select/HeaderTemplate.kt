package com.github.hemoptysisheart.parking.app.ui.template.select

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.app.ui.molecule.common.GoBackButton
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun SelectRouteHeader(
    destination: Location? = null,
    onBack: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(10.dp, 5.dp)
            .zIndex(10f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GoBackButton(onBack)
        Text(text = destination?.name ?: "", modifier = Modifier.padding(5.dp))
    }
}

@Composable
@Preview
fun Preview_SelectRouteHeader() {
    ParkingTheme {
        SelectRouteHeader(LOCATION_株式会社ＡＡＡ)
    }
}
