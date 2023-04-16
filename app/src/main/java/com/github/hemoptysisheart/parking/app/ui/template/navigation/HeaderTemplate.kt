package com.github.hemoptysisheart.parking.app.ui.template.navigation

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
import com.github.hemoptysisheart.parking.app.ui.molecule.common.GoBackButton
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.Route

@Composable
fun HeaderTemplate(route: Route, onBack: () -> Unit = {}, modifier: Modifier=Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GoBackButton(onBack)
        Text(text = route.destination.name, modifier = Modifier.weight(1f))
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_HeaderTemplate() {
    ParkingTheme {
        HeaderTemplate(PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
