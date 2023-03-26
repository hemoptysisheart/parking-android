package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.app.domain.RouteImpl
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_ECOLO_PARK_KABUKICHO_29
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_신주쿠역
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewOverview.OVERVIEW_DRIVE_신주쿠역_TO_ECOLO_PARK_KABUKICHO_29
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewOverview.OVERVIEW_WALKING_ECOLO_PARK_KABUKICHO_29_TO_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.domain.PartialRoute

@Suppress("NonAsciiCharacters")
object PreviewRoute {
    val ROUTE_新宿駅_패밀리마트_카부키쵸키타점 =
        RouteImpl(LOCATION_신주쿠역, LOCATION_ECOLO_PARK_KABUKICHO_29, LOCATION_패밀리마트_카부키쵸키타점).apply {
            driving = PartialRoute(OVERVIEW_DRIVE_신주쿠역_TO_ECOLO_PARK_KABUKICHO_29)
            walking = PartialRoute(OVERVIEW_WALKING_ECOLO_PARK_KABUKICHO_29_TO_패밀리마트_카부키쵸키타점)
        }
}
