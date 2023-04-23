package com.github.hemoptysisheart.parking.app.ui.interaction

class MainInteraction(context: InteractionContext) : AbstractInteraction(context) {
    companion object {
        const val NAME = "MainPage"

        const val ROUTE = NAME
    }

    fun search() = context.navController.navigate(SearchInteraction.NAME)
}
