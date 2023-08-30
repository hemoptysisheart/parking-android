package com.github.hemoptysisheart.parking.domain.route

import com.github.hemoptysisheart.parking.domain.common.Object
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 경로
 *
 * 1. [Route]
 *      1. [SubRoute]
 *          1. [RouteLeg]
 *              1. [RouteStep]
 */
@Deprecated(
        "Pair<SubRoute, SubRoute>로 충분할 듯.",
        ReplaceWith("com.github.hemoptysisheart.parking.domain.route.SubRoute")
)
interface Route : Object {
    /**
     * 출발
     */
    val start: Waypoint

    /**
     * 주차장
     */
    val parking: Place

    /**
     * 도착
     */
    val destination: Place

    /**
     * 차량 이동
     */
    val drive: SubRoute

    /**
     * 도보 이동
     */
    val walk: SubRoute
}
