package com.github.hemoptysisheart.parking.app.interaction.main

import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction
import com.github.hemoptysisheart.parking.app.interaction.Interaction
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 목적지 검색
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-653
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54311-34835&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1445&mode=design
 */
class DestinationSearchInteraction(private val base: BaseInteraction) : Interaction by base {
    companion object {
        private val LOGGER = AndroidLogger(DestinationSearchInteraction::class)

        const val ROUTE_PATTERN = "main/destinationSearch"
    }

    fun gotoSelectParking(place: Place) {
        LOGGER.i("#gotoSelectParking args : place=$place")

        base.navController.navigate(SelectParkingInteraction.route(place))
    }

    fun gotoSearchSetting() {
        LOGGER.i("#gotoSearchSetting called.")

        base.navController.navigate(SearchSettingInteraction.ROUTE_PATTERN)
    }
}
