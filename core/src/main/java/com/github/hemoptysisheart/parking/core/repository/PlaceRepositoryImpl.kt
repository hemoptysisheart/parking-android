package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.client.google.MapsClient
import com.github.hemoptysisheart.parking.client.google.data.NearbySearchParams
import com.github.hemoptysisheart.parking.client.google.data.PlaceTypeResultOnly
import com.github.hemoptysisheart.parking.core.domain.place.toDomain
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.util.NonNegativeInt
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
        private val client: MapsClient
) : PlaceRepository {
    companion object {
        private val LOGGER = AndroidLogger(PlaceRepositoryImpl::class)
    }

    /**
     * [cache] write lock.
     */
    private val cacheLock = Mutex()
    private val cache = mutableMapOf<Identifier, Place>()

    override suspend fun read(id: Identifier): Place? {
        LOGGER.v("#read args : id=$id")

        val place = cache[id]

        LOGGER.v("#read return : $place")
        return place
    }

    override suspend fun list(
            query: String,
            center: Geolocation,
            radius: NonNegativeInt,
            language: Locale?
    ): List<Place> {
        LOGGER.v("#list args : query=$query, center=$center, radius=$radius, language=$language")

        val params = NearbySearchParams(
                center.longitude,
                center.latitude,
                radius = radius.value,
                keyword = query,
                locale = language?.locale,
                type = PlaceTypeResultOnly.POINT_OF_INTEREST
        )
        val list = client.nearBy(params)
                .map { it.toDomain() }

        cacheLock.withLock {
            for (p in list) {
                cache[p.id] = p
            }
            LOGGER.d("#list : cache=$cache")
        }

        LOGGER.v("#list return : $list")
        return list
    }

    override fun toString() = "PlaceRepositoryImpl(cache=$cache)"
}
