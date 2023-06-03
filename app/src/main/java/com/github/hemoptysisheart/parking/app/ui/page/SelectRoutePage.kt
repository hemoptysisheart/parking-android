package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.ui.interaction.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.SELECT_ROUTE_VM
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER
import com.github.hemoptysisheart.parking.app.ui.template.select.MapTemplate
import com.github.hemoptysisheart.parking.app.ui.template.select.RouteDetailTemplate
import com.github.hemoptysisheart.parking.app.ui.template.select.SelectRouteHeader
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.SelectRouteViewModel

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
            SelectRouteHeader(destination = destination, interaction.onBack)
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
                    RouteDetailTemplate(it, Modifier.weight(1f), interaction.gotoNavigation)
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
