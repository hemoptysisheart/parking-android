package com.github.hemoptysisheart.parking.domain

import java.math.BigDecimal

data class SimpleLocation(
    override val id: Long = 1L,
    override val latitude: BigDecimal,
    override val longitude: BigDecimal
) : Location {
    constructor(id: Long = 1L, latitude: Double, longitude: Double) : this(
        id,
        BigDecimal(latitude),
        BigDecimal(longitude)
    )

    constructor(id: Long = 1L, latitude: String, longitude: String) : this(
        id,
        BigDecimal(latitude),
        BigDecimal(longitude)
    )

    override fun toString() = "($latitude, $longitude)"
}