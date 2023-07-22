package com.github.hemoptysisheart.parking.app.ui.interaction.main

import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction.Companion.LOGGER
import com.github.hemoptysisheart.parking.app.ui.interaction.Interaction
import com.github.hemoptysisheart.parking.domain.RecommendItem

/**
 * [목적지 검색 화면](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?type=design&node-id=112-509&mode=design)에서
 * 사용할 수 있는 인터렉션.
 *
 * @see com.github.hemoptysisheart.parking.app.ui.page.SearchDestinationPage [목적지 검색 화면](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?type=design&node-id=112-509&mode=design).
 */
class SearchDestinationPageInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "SearchPage"

        const val ROUTE = NAME
    }

    fun gotoSelectRoute(item: RecommendItem) {
        val route = "${SelectRouteInteraction.NAME}/${item.id}"
        LOGGER.d("#gotoSelectRoute args : item=$item, route=$route")
        navController.navigate(route)
    }
}
