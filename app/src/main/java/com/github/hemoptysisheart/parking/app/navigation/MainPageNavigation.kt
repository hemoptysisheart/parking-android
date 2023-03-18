package com.github.hemoptysisheart.parking.app.navigation

import androidx.navigation.NavController

class MainPageNavigation(
    navController: NavController
) : AbstractPageNavigation(navController) {
    companion object {
        const val NAME = "MainPage"
    }

    fun search() = navController.navigate(SearchPageNavigation.NAME)
}
