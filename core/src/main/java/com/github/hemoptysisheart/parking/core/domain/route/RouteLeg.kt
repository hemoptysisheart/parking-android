package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.client.google.data.DirectionsLeg
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.route.RouteLeg
import com.github.hemoptysisheart.parking.domain.route.RouteStep
import java.time.Duration

data class RouteLegImpl(
        override val start: Geolocation,
        override val end: Geolocation,
        override val stepList: List<RouteStep>,
        override val distance: Long?,
        override val duration: Duration?
) : RouteLeg {
    override val overview: List<Geolocation> = stepList.flatMap { it.overview }
}

fun DirectionsLeg.toRouteLeg() = RouteLegImpl(
        start = Geolocation(startLocation.latitude, startLocation.longitude),
        end = Geolocation(endLocation.latitude, endLocation.longitude),
        stepList = steps.map { it.toRouteStep() },
        distance = distance?.number?.toLong(),
        duration = duration?.let { Duration.ofSeconds(it.number.toLong()) }
)