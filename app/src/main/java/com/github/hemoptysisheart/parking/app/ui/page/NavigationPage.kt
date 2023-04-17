package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.navigation.NavigationPageNavigation
import com.github.hemoptysisheart.parking.app.ui.template.navigation.HeaderTemplate
import com.github.hemoptysisheart.parking.app.ui.template.navigation.MapTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.NavigationViewModel
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun NavigationPage(
    navigation: NavigationPageNavigation,
    viewModel: NavigationViewModel = hiltViewModel()
) {
    LOGGER.v("#NavigationPage args : navigation=$navigation, viewModel=$viewModel")

    val here by viewModel.here.collectAsStateWithLifecycle()
    val route by viewModel.route.collectAsStateWithLifecycle()
    LOGGER.v("#NavigationPage args : here=$here, route=$route")
    when {
        null == route -> {
            LOGGER.e("#NavigationPage route is null.")
        }
        true != route?.contains(here) -> {
            throw IllegalArgumentException("route does not contains here : here=$here, route=$route")
        }
    }

    route?.let {
        Box(modifier = Modifier.fillMaxSize()) {
            HeaderTemplate(
                route = it,
                onBack = navigation.onBack,
                onClose = navigation.onClose,
                modifier = Modifier
                    .zIndex(10f)
            )
            MapTemplate(here, it)
        }
    }
}

@Composable
@Preview
fun Preview_NavigationPage() {
    ParkingTheme {
        NavigationPage(NavigationPageNavigation(rememberNavController()))
    }
}