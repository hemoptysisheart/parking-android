package com.github.hemoptysisheart.parking.app.ui.interaction

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.github.hemoptysisheart.parking.app.ui.interaction.CommonInteraction.Companion.LOGGER
import com.github.hemoptysisheart.parking.domain.Route


/**
 * [경로 선택 화면](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?type=design&node-id=505-508&mode=design)
 *
 * 목적지를 선택한 후, 가능한 여러 경로를 보여준다.
 * 각 경로의 정보를 보여주면서 사용자가 선택할 수 있도록 하고, 안내 화면으로 넘어가야 한다.
 *
 * @see com.github.hemoptysisheart.parking.app.ui.page.SelectRoutePage
 */
class SelectRouteInteraction(commonInteraction: CommonInteraction) : Interaction by commonInteraction {
    companion object {
        const val NAME = "SelectRoute"

        const val ARG_DESTINATION_ID = "destinationId"

        const val ROUTE = "$NAME/{$ARG_DESTINATION_ID}"

        val ARGUMENTS = listOf(
            navArgument(ARG_DESTINATION_ID) { type = NavType.StringType }
        )

        val navArgs = NavArgs {
            val id = it.get<String>(ARG_DESTINATION_ID)
                ?: throw IllegalStateException("$ARG_DESTINATION_ID is not exist.")
            LOGGER.v("#navArgs : $id")
            id
        }
    }

    fun gotoNavigation(route: Route) {
        LOGGER.d("#gotoNavigation args : route=$route")

        navController.navigate("${NavigationInteraction.NAME}/${route.id}")
    }
}
