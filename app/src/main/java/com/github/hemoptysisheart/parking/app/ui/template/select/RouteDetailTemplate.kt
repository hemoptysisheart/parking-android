package com.github.hemoptysisheart.parking.app.ui.template.select

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R.string
import com.github.hemoptysisheart.parking.app.ui.molecule.common.RoutePropertyRow
import com.github.hemoptysisheart.parking.app.ui.molecule.select.RouteDetailHeader
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.support.formatDistance
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RouteDetailTemplate(route: Route, modifier: Modifier = Modifier, gotoNavigation: (Route) -> Unit = {}) {
    LazyColumn(
        modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(5.dp, 10.dp, 5.dp, 0.dp)
    ) {
        stickyHeader { RouteDetailHeader(route, gotoNavigation) }

        item { RoutePropertyRow(stringResource(string.domain_route_driving), formatDistance(route.driving?.distance)) }
        item { RoutePropertyRow(stringResource(string.domain_route_walking), formatDistance(route.walking?.distance)) }
        item { RoutePropertyRow(stringResource(string.domain_route_distance), formatDistance(route.distance)) }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_RouteDetailTemplate() {
    ParkingTheme {
        RouteDetailTemplate(ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}