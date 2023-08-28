package com.github.hemoptysisheart.parking.domain.route

/**
 * 전체 경로의 일부. 차량이동 경로 혹은 도보 이동 경로.
 *
 * 1. [Route]
 *      1. [SubRoute]
 *          1. [RouteLeg]
 *              1. [RouteStep]
 */
interface SubRoute {
    /**
     * 출발
     */
    val start: Waypoint

    /**
     * 도착
     */
    val end: Waypoint

    /**
     * 이동수단
     */
    val transportation: Transportation

    /**
     * 하위 경로
     */
    val legList: List<RouteLeg>
}
