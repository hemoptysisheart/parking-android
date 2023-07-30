package com.github.hemoptysisheart.parking.domain.route

import com.github.hemoptysisheart.parking.domain.place.Geolocation

/**
 * 경로 구간
 *
 * 1. [Route]
 *     1. [RouteLeg]
 *         1. [RouteStep]
 */
interface RouteLeg {
    val start: Geolocation

    val end: Geolocation

    val overview: List<Geolocation>

    val steps: List<RouteStep>
}
