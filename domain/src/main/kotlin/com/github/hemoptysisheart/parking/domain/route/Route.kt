package com.github.hemoptysisheart.parking.domain.route

import com.github.hemoptysisheart.parking.domain.common.Object
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 경로
 *
 * 1. [Route]
 *     1. [RouteLeg]
 *         1. [RouteStep]
 */
interface Route : Object {
    /**
     * 출발 장소
     */
    val origin: Place

    /**
     * 주차장
     */
    val parkingLot: Place

    /**
     * 목적지
     */
    val destination: Place

    /**
     * 운전 경로
     *
     * [origin] -> [parkingLot]
     */
    val driveLegs: List<RouteLeg>

    /**
     * 도보 경로
     *
     * [parkingLot] -> [destination]
     */
    val walkLegs: List<RouteLeg>
}