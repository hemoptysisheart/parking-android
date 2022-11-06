package com.github.hemoptysisheart.parking.domain

import java.math.BigDecimal

data class SimpleLocation(
    override val latitude: BigDecimal,
    override val longitude: BigDecimal
) : Location {
    constructor(latitude: Double, longitude: Double) : this(BigDecimal(latitude), BigDecimal(longitude))

    constructor(latitude: String, longitude: String) : this(BigDecimal(latitude), BigDecimal(longitude))
}