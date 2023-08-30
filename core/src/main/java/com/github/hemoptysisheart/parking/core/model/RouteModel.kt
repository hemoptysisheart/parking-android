package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Transportation
import com.github.hemoptysisheart.parking.domain.route.Waypoint

interface RouteModel {
    /**
     * 경로 검색
     */
    suspend fun search(start: Waypoint, end: Waypoint, transportation: Transportation): List<SubRoute>
}