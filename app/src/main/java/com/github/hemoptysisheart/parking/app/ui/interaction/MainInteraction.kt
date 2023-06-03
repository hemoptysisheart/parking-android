package com.github.hemoptysisheart.parking.app.ui.interaction

class MainInteraction(commonInteraction:CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "MainPage"

        const val ROUTE = NAME
    }

    fun search() = navController.navigate(SearchInteraction.NAME)
}
