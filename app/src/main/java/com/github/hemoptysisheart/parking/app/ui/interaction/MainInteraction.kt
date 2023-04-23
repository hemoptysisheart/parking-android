package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.navigation.NavController

class MainInteraction(
    navController: NavController
) : AbstractInteraction(navController) {
    companion object {
        const val NAME = "MainPage"

        const val ROUTE = NAME
    }

    fun search() = navController.navigate(SearchInteraction.NAME)
}
