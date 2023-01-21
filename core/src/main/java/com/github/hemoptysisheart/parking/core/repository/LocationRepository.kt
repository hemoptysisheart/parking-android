package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.domain.Location

@Deprecated("나중에.")
interface LocationRepository {
    suspend fun create(location: Location): Location
}