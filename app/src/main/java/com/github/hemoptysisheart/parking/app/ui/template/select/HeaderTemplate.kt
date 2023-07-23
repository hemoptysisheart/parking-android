package com.github.hemoptysisheart.parking.app.ui.template.select

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.github.hemoptysisheart.parking.app.ui.molecule.common.BackButton
import com.github.hemoptysisheart.parking.app.ui.preview.LOCATION_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.deprecate.Location

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
        BackButton(onBack)
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
