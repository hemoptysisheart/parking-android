package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.client.google.MapsClient
import com.github.hemoptysisheart.parking.client.google.data.NearbySearchParams
import com.github.hemoptysisheart.parking.client.google.data.PlaceTypeResultOnly
import com.github.hemoptysisheart.parking.core.domain.place.PlaceGooglePlace
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.search.Query
import javax.inject.Inject

class PlaceModelImpl @Inject constructor(
        private val client: MapsClient
) : PlaceModel {
    companion object {
        private val LOGGER = AndroidLogger(PlaceModelImpl::class)
    }

    init {
        LOGGER.i("#init complete.")
    }

    override suspend fun searchDestination(query: Query): List<Place> {
        LOGGER.v("#searchDestination args : query=$query")

        val params = NearbySearchParams(
                query.center.longitude,
                query.center.latitude,
                radius = query.distance.value,
                keyword = query.query,
                type = PlaceTypeResultOnly.POINT_OF_INTEREST
        )
        val list = client.nearBy(params)
                .map { PlaceGooglePlace(it) }

        LOGGER.v("#searchDestination return : $list")
        return list
    }
}