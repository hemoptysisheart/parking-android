package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.domain.Location

interface LocationModel {
    fun update(location: Location)
}