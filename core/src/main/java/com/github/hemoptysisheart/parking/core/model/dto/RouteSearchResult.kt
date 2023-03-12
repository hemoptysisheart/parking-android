package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Overview
import com.github.hemoptysisheart.parking.domain.Transport

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
    val transport: Transport,
    /**
     * 대략적인 경로.
     */
    val overview: Overview
)
