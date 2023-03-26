package com.github.hemoptysisheart.parking.app.ui.template.select

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.domain.Route
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun RouteDetailTemplate(route: Route, modifier: Modifier = Modifier) {
    Text(text = "$route", modifier = modifier)
}

@Composable
@Preview(showBackground = true)
fun Preview_RouteDetailTemplate() {
    ParkingTheme {
        RouteDetailTemplate(ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
