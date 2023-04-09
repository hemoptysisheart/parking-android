package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.navigation.NavigationPageNavigation
import com.github.hemoptysisheart.parking.app.viewmodel.NavigationViewModel
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun NavigationPage(
    navigation: NavigationPageNavigation = NavigationPageNavigation(rememberNavController()),
    viewModel: NavigationViewModel = hiltViewModel()
) {
    LOGGER.v("#NavigationPage args : navigation=$navigation, viewModel=$viewModel")
}
