package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.core.client.google.dto.DirectionsRoute
import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode
import com.github.hemoptysisheart.parking.domain.Location

/**
 * 경로 검색 결과.
 */
data class RouteSearchResult(
    /**
     * 출발지.
     */
    val origin: Location,
    /**
     * 목적지.
     */
    val destination: Location,
    /**
     * 이동 방법.
     */
    val mode: TransportationMode,
    /**
     * 경로.
     *
     * TODO 자체 타입으로 변경.
     */
    val route: DirectionsRoute?
)
