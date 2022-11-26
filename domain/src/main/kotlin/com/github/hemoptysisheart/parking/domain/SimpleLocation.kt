package com.github.hemoptysisheart.parking.domain

import java.time.Instant

@Deprecated("Use `com.github.hemoptysisheart.parking.core.room.entity.LocationEntity`.")
data class SimpleLocation(
    override val id: Long = 1L,
    override val latitude: Double,
    override val longitude: Double,
    override val createdAt: Instant = Instant.now()
) : Location {
    override fun toString() = "(%.6f, %.6f)".format(latitude, longitude)
}