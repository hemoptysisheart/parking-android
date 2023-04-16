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
}

@Composable
@Preview
fun Preview_NavigationPage() {
    ParkingTheme {
        NavigationPage(NavigationPageNavigation(rememberNavController()))
    }
}