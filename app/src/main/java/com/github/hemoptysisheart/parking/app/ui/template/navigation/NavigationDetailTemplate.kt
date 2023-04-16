package com.github.hemoptysisheart.parking.app.ui.template.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.molecule.navigation.NaviLegMolecule
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_신주쿠역
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Route
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun NavigationDetailTemplate(
    here: GeoLocation,
    route: Route,
    modifier: Modifier = Modifier
) {
    LOGGER.v("#NavigationDetailTemplate args : here=$here, route=$route, modifier=$modifier")
    when {
        null == route.driving ->
            throw IllegalArgumentException("route.driving is null.")
        null == route.walking ->
            throw IllegalArgumentException("route.walking is null.")
    }

    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(route.driving!!.legList) { NaviLegMolecule(here, it) }
        items(route.walking!!.legList) { NaviLegMolecule(here, it) }
    }
}

@Composable
@Preview
fun Preview_NavigationDetailTemplate() {
    ParkingTheme {
        NavigationDetailTemplate(LOCATION_신주쿠역, ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
