package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.core.client.google.dto.Bounds
import com.github.hemoptysisheart.parking.domain.GeoBounds

fun Bounds.toGeoBounds() = GeoBounds(northEast.location, southWest.location)
