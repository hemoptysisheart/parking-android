package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Transportation
import com.github.hemoptysisheart.parking.domain.route.Waypoint

interface RouteRepository {
    /**
     * 경로 검색하기.
     */
    suspend fun search(start: Waypoint, end: Waypoint, transportation: Transportation): List<SubRoute>
}
