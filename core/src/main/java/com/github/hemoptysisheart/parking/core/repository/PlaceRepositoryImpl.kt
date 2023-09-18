package com.github.hemoptysisheart.parking.core.repository

import com.github.hemoptysisheart.parking.client.google.MapsClient
import com.github.hemoptysisheart.parking.client.google.data.CircularBias
import com.github.hemoptysisheart.parking.client.google.data.Field
import com.github.hemoptysisheart.parking.client.google.data.FieldCategory
import com.github.hemoptysisheart.parking.client.google.data.FindPlaceParams
import com.github.hemoptysisheart.parking.client.google.data.InputType
import com.github.hemoptysisheart.parking.client.google.data.LatLng
import com.github.hemoptysisheart.parking.client.google.data.NearbySearchParams
import com.github.hemoptysisheart.parking.client.google.data.PlaceTypeResultOnly
import com.github.hemoptysisheart.parking.client.google.data.PlaceTypes
import com.github.hemoptysisheart.parking.client.google.data.Platform
import com.github.hemoptysisheart.parking.core.domain.place.toPlace
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.place.PlaceType
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

    override suspend fun search(
            type: PlaceType,
            query: String,
            center: Geolocation,
            radius: NonNegativeInt,
            language: Locale?
    ): List<Place> {
        LOGGER.v("#search args : type=$type, query=$query, center=$center, radius=$radius, language=$language")

        val params = FindPlaceParams(
                input = query,
                inputType = InputType.TEXT_QUERY,
                fields = Field[Platform.ANDROID, FieldCategory.BASIC],
                locationBias = CircularBias(radius.value, LatLng(center.latitude, center.longitude))
        )
        val list = client.findPlace(params).map { it.toPlace(type) }

        cacheLock.withLock {
            for (p in list) {
                cache[p.id] = p
            }
            LOGGER.v("#search : cache=$cache")
        }

        LOGGER.v("#search return : $list")
        return list
    }

    override suspend fun search(type: PlaceType, center: Geolocation, radius: NonNegativeInt, language: Locale?): List<Place> {
        LOGGER.v("#search args : type=$type, center=$center, radius=$radius, language=$language")

        val params = NearbySearchParams(
                center.longitude,
                center.latitude,
                radius.value,
                locale = language?.locale,
                type = when (type) {
                    PlaceType.UNSPECIFIED -> null
                    PlaceType.DESTINATION -> PlaceTypeResultOnly.POINT_OF_INTEREST
                    PlaceType.PARKING -> PlaceTypes.PARKING
                }
        )
        val list = client.nearBy(params)
                .map { it.toPlace(type) }
        cacheLock.withLock {
            for (p in list) {
                cache[p.id] = p
            }
        }

        LOGGER.v("#search args : type=$type, center=$center, radius=$radius, language=$language")
        return list
    }

    override fun toString() = "PlaceRepositoryImpl(cache=$cache)"
}
