package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.client.google.data.DirectionsStep
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.route.Maneuver
import com.github.hemoptysisheart.parking.domain.route.RouteStep
import java.time.Duration

data class RouteStepImpl(
        override val start: Geolocation,
        override val end: Geolocation,
        override val maneuver: Maneuver?,
        override val distance: Long?,
        override val duration: Duration?,
        override val guide: String,
        override val overview: List<Geolocation>
) : RouteStep

fun DirectionsStep.toRouteStep() = RouteStepImpl(
        start = Geolocation(startLocation.latitude, startLocation.longitude),
        end = Geolocation(endLocation.latitude, endLocation.longitude),
        maneuver = maneuver?.domain,
        distance = distance?.number?.toLong(),
        duration = duration.let { Duration.ofSeconds(it.number.toLong()) },
        guide = html,
        overview = polyline.points.map { Geolocation(it.latitude, it.longitude) }
)