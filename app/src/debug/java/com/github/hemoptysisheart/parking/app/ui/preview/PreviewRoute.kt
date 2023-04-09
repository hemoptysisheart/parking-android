package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_ECOLO_PARK_KABUKICHO_29
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_신주쿠역
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewOverview.OVERVIEW_DRIVE_신주쿠역_TO_ECOLO_PARK_KABUKICHO_29
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewOverview.OVERVIEW_WALKING_ECOLO_PARK_KABUKICHO_29_TO_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.domain.GeoBounds
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.PartialRoute
import com.github.hemoptysisheart.parking.domain.Route

@Suppress("NonAsciiCharacters")
object PreviewRoute {
    val ROUTE_新宿駅_패밀리마트_카부키쵸키타점 = Route(
        LOCATION_신주쿠역,
        LOCATION_ECOLO_PARK_KABUKICHO_29,
        LOCATION_패밀리마트_카부키쵸키타점
    ).apply {
        driving = PartialRoute(
            "DRIVE_신주쿠역_TO_ECOLO_PARK_KABUKICHO_29",
            GeoBounds(
                northEast = GeoLocation(35.6982605, 139.7074366),
                southWest = GeoLocation(35.6896586, 139.7028543)
            ),
            OVERVIEW_DRIVE_신주쿠역_TO_ECOLO_PARK_KABUKICHO_29,
            listOf()    // TODO 내용 채우기
        )
        walking = PartialRoute(
            "WALKING_ECOLO_PARK_KABUKICHO_29_TO_패밀리마트_카부키쵸키타점",
            GeoBounds(
                northEast = GeoLocation(35.6980957, 139.7032697),
                southWest = GeoLocation(35.697859, 139.7026791)
            ),
            OVERVIEW_WALKING_ECOLO_PARK_KABUKICHO_29_TO_패밀리마트_카부키쵸키타점,
            listOf()    // TODO 내용 채우기.
        )
    }
}
