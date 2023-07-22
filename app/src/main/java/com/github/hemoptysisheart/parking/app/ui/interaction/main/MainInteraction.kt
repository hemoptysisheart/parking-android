package com.github.hemoptysisheart.parking.app.ui.interaction.main

import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.Interaction

class MainInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "MainPage"

        const val ROUTE = NAME
    }

    fun search() = navController.navigate(SearchDestinationPageInteraction.NAME)
}
