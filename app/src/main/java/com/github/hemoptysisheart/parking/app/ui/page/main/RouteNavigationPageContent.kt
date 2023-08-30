package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.hemoptysisheart.parking.app.interaction.main.RouteNavigationInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.routenavigation.RouteNavigationMap
import com.github.hemoptysisheart.parking.app.ui.template.routenavigation.RouteStepList
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.route.SubRoute

/**
 * 경로 안내
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-693
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54312-34862&mode=design
 */
@Composable
fun RouteNavigationPageContent(
        interaction: RouteNavigationInteraction,
        drive: SubRoute,
        walk: SubRoute,
        here: Geolocation
) {
    LOGGER.v("#RouteNavigationPageContent args : drive=${drive.id}, walk=${walk.id}")

    Column(
            modifier = Modifier
                    .fillMaxSize()
    ) {
        RouteNavigationMap(drive, walk, here)
        RouteStepList(drive, walk, interaction::closeRouteNavigation)
    }
}

@Composable
@ComponentPreview
fun Preview_RouteNavigationPageContent() {
    ComponentPreviewContainer {
        // RouteNavigationPageContent(RouteNavigationInteraction(it))
    }
}
