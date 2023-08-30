package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.client.google.data.DirectionsRoute
import com.github.hemoptysisheart.parking.core.domain.common.AbstractObject
import com.github.hemoptysisheart.parking.core.domain.common.Types.SUB_ROUTE
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
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
) : AbstractObject(identifier(start, end, transportation)), SubRoute {
    companion object {
        @Suppress("IMPLICIT_CAST_TO_ANY")
        fun identifier(start: Waypoint, end: Waypoint, transportation: Transportation): Identifier {
            val key = "${
                when (start) {
                    is Geolocation -> start.toSimpleString()
                    is Place -> start.id
                    else -> throw IllegalArgumentException("unsupported type : start=$start")
                }
            }:${
                when (end) {
                    is Geolocation -> end.toSimpleString()
                    is Place -> end.id
                    else -> throw IllegalArgumentException("unsupported type : end=$end")
                }
            }:$transportation"
            return Identifier(SUB_ROUTE, key)
        }
    }

    override val overview: List<Geolocation> = legList.flatMap { it.overview }

    override val distance: Long = legList.sumOf { it.distance ?: 0L }

    override val duration = legList.sumOf { it.duration?.toSeconds() ?: 0L }
            .run { Duration.ofSeconds(this) }!!

    override fun toSimpleString() = "$id"
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