package com.github.hemoptysisheart.parking.domain

import java.math.BigDecimal
import java.time.Instant

@Deprecated("Use `com.github.hemoptysisheart.parking.core.room.entity.LocationEntity`.")
data class SimpleLocation(
    override val id: Long = 1L,
    override val latitude: BigDecimal,
    override val longitude: BigDecimal,
    override val createdAt: Instant = Instant.now()
) : Location {
    constructor(id: Long = 1L, latitude: Double, longitude: Double) : this(
        id,
        BigDecimal(latitude),
        BigDecimal(longitude)
    )

    override fun toString() = "($latitude, $longitude)"
}