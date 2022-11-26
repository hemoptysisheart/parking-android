package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.domain.Location

interface LocationRepository {
    suspend fun create(location: Location): Location
}