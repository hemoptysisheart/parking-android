package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.repository.PlaceRepository
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.place.Place
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

    override suspend fun searchDestination(query: Query): List<Place> {
        LOGGER.v("#searchDestination args : query=$query")

        val list = placeRepository.list(query.query, query.center, query.distance, searchPreferences.language)

        LOGGER.v("#searchDestination return : $list")
        return list
    }
}