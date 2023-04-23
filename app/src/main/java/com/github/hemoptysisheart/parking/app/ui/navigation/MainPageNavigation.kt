package com.github.hemoptysisheart.parking.app.ui.navigation

import androidx.navigation.NavController

class MainPageNavigation(
    navController: NavController
) : AbstractPageNavigation(navController) {
    companion object {
        const val NAME = "MainPage"

        const val ROUTE = NAME
    }

    fun search() = navController.navigate(SearchPageNavigation.NAME)
}
