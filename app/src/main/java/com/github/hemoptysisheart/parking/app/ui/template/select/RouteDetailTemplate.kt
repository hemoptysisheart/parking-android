package com.github.hemoptysisheart.parking.app.ui.template.select

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.select.RouteDetailHeader
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.domain.Route
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RouteDetailTemplate(route: Route, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier
            .background(Color.White)
            .padding(5.dp, 10.dp, 5.dp, 0.dp)
    ) {
        stickyHeader { RouteDetailHeader(route) }
        item {
            Text(text = "$route")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_RouteDetailTemplate() {
    ParkingTheme {
        RouteDetailTemplate(ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
