package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.client.google.data.DirectionsRoute
import com.github.hemoptysisheart.parking.domain.route.RouteLeg
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Transportation
import com.github.hemoptysisheart.parking.domain.route.Waypoint

data class SubRouteImpl(
        override val start: Waypoint,
        override val end: Waypoint,
        override val transportation: Transportation,
        override val legList: List<RouteLeg>
) : SubRoute

fun DirectionsRoute.toSubRoute(
        start: Waypoint,
        end: Waypoint,
        transportation: Transportation
): SubRoute = SubRouteImpl(
        start = start,
        end = end,
        transportation = transportation,
        legList = legs.map { it.toRouteLeg() }
)