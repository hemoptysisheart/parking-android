package com.github.hemoptysisheart.parking.domain

/**
 * 목적지까지 경로.
 *
 * TODO 경로 타입 정리.
 */
interface Route {
    /**
     * 출발지(현재위치).
     */
    val origin: Location

    /**
     * 주차장.
     */
    val parking: Location

    /**
     * 목적지.
     */
    val destination: Location

    /**
     * 출발지에서 주차장까지 운전경로.
     */
    val driving: PartialRoute

    /**
     * 주차장에서 목적지까지 걷는 경로.
     */
    val walking: PartialRoute

    val distance: Double?
}
