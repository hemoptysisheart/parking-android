package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.ui.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.SELECT_ROUTE_VM
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER
import com.github.hemoptysisheart.parking.app.ui.template.select.MapTemplate
import com.github.hemoptysisheart.parking.app.ui.template.select.RouteDetailTemplate
import com.github.hemoptysisheart.parking.app.ui.template.select.SelectRouteHeader
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.SelectRouteViewModel

/**
 * [경로 선택 화면](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?type=design&node-id=505-508&mode=design)
 *
 * 목적지를 선택한 후, 가능한 여러 경로를 보여준다.
 * 각 경로의 정보를 보여주면서 사용자가 선택할 수 있도록 하고, 안내 화면으로 넘어가야 한다.
 */
@Composable
fun SelectRoutePage(
    interaction: SelectRouteInteraction,
    viewModel: SelectRouteViewModel = hiltViewModel()
) {
    LOGGER.v("#SelectRoutePage args : interaction=$interaction, viewModel=$viewModel")

    var showControl by remember { mutableStateOf(true) }
    val destination by viewModel.destination.collectAsStateWithLifecycle()
    val routeList by viewModel.routeList.collectAsStateWithLifecycle()
    val focusedRoute by viewModel.focusedRoute.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        if (showControl) {
            SelectRouteHeader(destination = destination, interaction::onBack)
        }
        Column(Modifier.fillMaxSize()) {
            MapTemplate(
                destination = destination,
                routeList = routeList,
                focusedRoute = focusedRoute,
                modifier = Modifier.weight(2f),
                onClick = { showControl = !showControl },
                onSelectRoute = { viewModel.focus(it) }
            )
            focusedRoute?.let {
                if (showControl) {
                    RouteDetailTemplate(it, Modifier.weight(1f), interaction::gotoNavigation)
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview_SelectRoutePage() {
    ParkingTheme {
        SelectRoutePage(
            SelectRouteInteraction(commonInteraction()),
            SELECT_ROUTE_VM
        )
    }
}
