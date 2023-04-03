package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.core.client.google.dto.DirectionsRoute
import com.github.hemoptysisheart.parking.domain.PartialRoute

fun DirectionsRoute.toPartialRoute() = PartialRoute(
    summary = summary,
    bounds = bounds.toGeoBounds(),
    overview = overviewPolyline.points.map { it.location },
    legList = legs.map { it.toNaviLeg() }
)
