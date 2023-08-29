package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.client.google.data.DirectionsRoute
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.route.RouteLeg
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Transportation
import com.github.hemoptysisheart.parking.domain.route.Waypoint
import java.time.Duration

data class SubRouteImpl(
        override val start: Waypoint,
        override val end: Waypoint,
        override val transportation: Transportation,
        override val legList: List<RouteLeg>
) : SubRoute {
    override val overview: List<Geolocation> = legList.flatMap { it.overview }

    override val distance: Long = legList.sumOf { it.distance }

    override val duration = legList.sumOf { it.duration.toSeconds() }
            .run { Duration.ofSeconds(this) }!!
}

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