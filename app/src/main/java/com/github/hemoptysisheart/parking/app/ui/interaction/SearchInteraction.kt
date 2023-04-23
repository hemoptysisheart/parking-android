package com.github.hemoptysisheart.parking.app.ui.interaction

import com.github.hemoptysisheart.parking.domain.RecommendItem

class SearchInteraction(context: InteractionContext) : AbstractInteraction(context) {
    companion object {
        const val NAME = "SearchPage"
        const val ROUTE = NAME
    }

    val gotoSelectRoute: (RecommendItem<*>) -> Unit = {
        LOGGER.d("#gotoSelectRoute args : item=$it")
        context.navController.navigate("${SelectRouteInteraction.NAME}/${it.id}")
    }
}
