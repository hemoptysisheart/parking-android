package com.github.hemoptysisheart.parking.core.extension

import com.github.hemoptysisheart.parking.core.client.google.data.Bounds
import com.github.hemoptysisheart.parking.domain.deprecate.GeoBounds

fun Bounds.toGeoBounds() = GeoBounds(northEast.location, southWest.location)
