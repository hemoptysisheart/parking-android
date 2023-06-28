package com.github.hemoptysisheart.parking.app.ui.interaction.wizard

import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.Interaction

class InstructionInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "Wizard"

        const val ROUTE_PATTERN = NAME
    }
}
