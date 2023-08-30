package com.github.hemoptysisheart.parking.domain.route

import com.github.hemoptysisheart.parking.domain.place.Geolocation
import java.time.Duration

/**
 * 경로 상세 이동
 *
 * 1. [Route]
 *      1. [SubRoute]
 *          1. [RouteLeg]
 *              1. [RouteStep]
 */
interface RouteStep {
    val start: Geolocation
    val end: Geolocation

    /**
     * 방향
     */
    val maneuver: Maneuver?

    /**
     * 거리
     */
    val distance: Long?

    /**
     * 시간
     */
    val duration: Duration?

    /**
     * 안내 문구.
     */
    val guide: String

    /**
     * 경로
     */
    val overview: List<Geolocation>
}
