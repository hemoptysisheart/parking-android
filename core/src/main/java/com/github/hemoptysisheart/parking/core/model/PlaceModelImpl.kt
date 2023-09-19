package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.repository.PlaceRepository
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.place.PlaceType.DESTINATION
import com.github.hemoptysisheart.parking.domain.place.PlaceType.PARKING
import com.github.hemoptysisheart.parking.domain.search.Query
import javax.inject.Inject

class PlaceModelImpl @Inject constructor(
        private val searchPreferences: SearchPreferences,
        private val placeRepository: PlaceRepository
) : PlaceModel {
    companion object {
        private val LOGGER = AndroidLogger(PlaceModelImpl::class)
    }

    init {
        LOGGER.i("#init complete.")
    }

    override suspend fun read(id: Identifier): Place? {
        LOGGER.v("#read args : id=$id")

        val place = placeRepository.read(id)

        LOGGER.v("#read return : $place")
        return place
    }

    override suspend fun searchDestination(query: Query): List<Place> {
        LOGGER.v("#searchDestination args : query=$query")

        val list = placeRepository.search(
                type = DESTINATION,
                center = query.center,
                radius = query.distance,
                language = searchPreferences.language
        )

        LOGGER.v("#searchDestination return : $list")
        return list
    }

    override suspend fun searchParking(query: Query): List<Place> {
        LOGGER.v("#searchParking args : query=$query")
        if (query.query.isNotEmpty()) {
            LOGGER.w("#searchParking query is not empty : query=$query")
        }

        val list = placeRepository.search(
                type = PARKING,
                center = query.center,
                radius = query.distance,
                language = searchPreferences.language
        )

        LOGGER.v("#searchParking return : $list")
        return list
    }
}
