package com.github.hemoptysisheart.parking.core.domain.route

import com.github.hemoptysisheart.parking.core.domain.common.AbstractObject
import com.github.hemoptysisheart.parking.core.domain.common.Types.ROUTE
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.route.Route
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Waypoint
import java.net.URLEncoder.encode
import java.nio.charset.StandardCharsets.UTF_8

data class RouteImpl(
        override val start: Waypoint,
        override val parking: Place,
        override val destination: Place,
        override val drive: SubRoute,
        override val walk: SubRoute
) : AbstractObject(identifier(start, parking, destination)), Route {
    companion object {
        fun identifier(origin: Waypoint, parking: Place, destination: Place) =
                Identifier(ROUTE, encode("${origin.geolocation}:${parking.id}:${destination.id}", UTF_8))
    }

    override fun toSimpleString() = "${start.geolocation} => ${parking.id} => ${destination.id}"
}
