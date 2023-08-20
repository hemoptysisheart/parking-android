package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.util.NonNegativeInt

interface PlaceRepository {
    suspend fun read(id: Identifier): Place?

    suspend fun list(query: String, center: Geolocation, radius: NonNegativeInt, language: Locale? = null): List<Place>
}
