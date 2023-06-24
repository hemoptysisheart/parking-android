package com.github.hemoptysisheart.parking.app.ui.interaction

import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction.Companion.LOGGER
import com.github.hemoptysisheart.parking.domain.RecommendItem

class SearchInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "SearchPage"
        const val ROUTE = NAME
    }

    fun gotoSelectRoute(item: RecommendItem) {
        LOGGER.d("#gotoSelectRoute args : item=$item")

        navController.navigate("${SelectRouteInteraction.NAME}/${item.id}")
    }
}
