package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.navigation.SelectRoutePageNavigation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewViewModel.SELECT_ROUTE_VM
import com.github.hemoptysisheart.parking.app.ui.template.select.MapTemplate
import com.github.hemoptysisheart.parking.app.ui.template.select.SelectRouteHeader
import com.github.hemoptysisheart.parking.app.viewmodel.SelectRouteViewModel
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun SelectRoutePage(
    navigation: SelectRoutePageNavigation = SelectRoutePageNavigation(rememberNavController()),
    viewModel: SelectRouteViewModel = hiltViewModel()
) {
    var showControl by rememberSaveable {
        mutableStateOf(true)
    }
    val destination by viewModel.destination.collectAsStateWithLifecycle()
    val routeMap by viewModel.routeMap.collectAsStateWithLifecycle()
    val focusedRoute by viewModel.focusedRoute.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        if (showControl) {
            SelectRouteHeader(destination = destination, navigation.onBack)
        }
        MapTemplate(
            destination = destination,
            routeMap = routeMap,
            focusedRoute = focusedRoute,
            onClick = { showControl = !showControl }
        )
    }
}

@Composable
@Preview
fun Preview_SelectRoutePage() {
    ParkingTheme {
        SelectRoutePage(viewModel = SELECT_ROUTE_VM)
    }
}
