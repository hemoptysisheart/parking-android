package com.github.hemoptysisheart.parking.app.ui.template.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.atom.icon.Drive
import com.github.hemoptysisheart.parking.app.ui.atom.icon.Walk
import com.github.hemoptysisheart.parking.app.ui.molecule.navigation.NaviLegMolecule
import com.github.hemoptysisheart.parking.app.ui.preview.LOCATION_신주쿠역
import com.github.hemoptysisheart.parking.app.ui.preview.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Route

@Composable
@OptIn(ExperimentalFoundationApi::class)
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
        stickyHeader {
            // TODO 헤더 UI 분리하기.
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(5.dp)
            ) {
                Drive()
                Spacer(Modifier.width(10.dp))
                Text(text = stringResource(R.string.domain_partial_route_drive))
            }
        }
        items(route.driving!!.legList) {
            NaviLegMolecule(here, it)
        }

        stickyHeader {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(5.dp)
            ) {
                Walk()
                Spacer(Modifier.width(10.dp))
                Text(text = stringResource(R.string.domain_partial_route_walk))
            }
        }
        items(route.walking!!.legList) {
            NaviLegMolecule(here, it)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_NavigationDetailTemplate() {
    ParkingTheme {
        NavigationDetailTemplate(LOCATION_신주쿠역, ROUTE_新宿駅_패밀리마트_카부키쵸키타점)
    }
}
