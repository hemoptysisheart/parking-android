package com.github.hemoptysisheart.parking.domain.search

import com.github.hemoptysisheart.parking.domain.route.Route

/**
 * 추천 경로.
 */
interface RecommendItemRoute : RecommendItem<Route> {
    /**
     * 추천 경로.
     */
    val route: Route
}