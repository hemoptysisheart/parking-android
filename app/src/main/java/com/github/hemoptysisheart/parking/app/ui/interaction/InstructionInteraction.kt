package com.github.hemoptysisheart.parking.app.ui.interaction

class InstructionInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "Wizard"

        const val ROUTE_PATTERN = NAME
    }
}
