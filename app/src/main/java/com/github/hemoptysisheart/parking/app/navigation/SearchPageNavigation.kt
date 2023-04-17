package com.github.hemoptysisheart.parking.app.navigation

import androidx.navigation.NavController
import com.github.hemoptysisheart.parking.domain.RecommendItem

class SearchPageNavigation(
    navController: NavController
) : AbstractPageNavigation(navController) {
    companion object {
        const val NAME = "SearchPage"
        const val ROUTE = NAME
    }

    val gotoSelectRoute: (RecommendItem<*>) -> Unit = {
        LOGGER.d("#gotoSelectRoute args : item=$it")
        navController.navigate("${SelectRoutePageNavigation.NAME}/${it.id}")
    }
}
