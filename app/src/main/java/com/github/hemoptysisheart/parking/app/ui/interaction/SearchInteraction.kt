package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.navigation.NavController
import com.github.hemoptysisheart.parking.domain.RecommendItem

class SearchInteraction(
    navController: NavController
) : AbstractInteraction(navController) {
    companion object {
        const val NAME = "SearchPage"
        const val ROUTE = NAME
    }

    val gotoSelectRoute: (RecommendItem<*>) -> Unit = {
        LOGGER.d("#gotoSelectRoute args : item=$it")
        navController.navigate("${SelectRouteInteraction.NAME}/${it.id}")
    }
}
