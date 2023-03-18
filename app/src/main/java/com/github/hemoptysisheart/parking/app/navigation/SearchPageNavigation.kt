package com.github.hemoptysisheart.parking.app.navigation

import androidx.navigation.NavController
import com.github.hemoptysisheart.parking.domain.RecommendItem

class SearchPageNavigation(
    navController: NavController
) : AbstractPageNavigation(navController) {
    companion object {
        const val NAME = "SearchPage"
    }

    val selectRoute: (RecommendItem<*>) -> Unit = {
        LOGGER.d("#selectRoute args : item=$it")
    }
}
