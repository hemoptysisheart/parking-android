package com.github.hemoptysisheart.parking.domain.route

import com.github.hemoptysisheart.parking.domain.place.Geolocation
import java.time.Duration

/**
 * 경로 구간
 *
 * 1. [Route]
 *      1. [SubRoute]
 *          1. [RouteLeg]
 *              1. [RouteStep]
 */
interface RouteLeg {
    val start: Geolocation

    val end: Geolocation

    val stepList: List<RouteStep>

    val overview: List<Geolocation>

    val distance: Long?

    val duration: Duration?
}
