package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location

object PreviewModel {
    val LOCATION_MODEL = object : LocationModel {
        override val location: GeoLocation = GeoLocation(37.5638354, 126.9040477)

        override fun addCallback(key: String, callback: (GeoLocation) -> Unit) {}

        override fun removeCallback(key: String) {}
    }

    val PLACE_MODEL = object : GeoSearchModel {
        override suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult {
            return PlaceSearchResult(center, query, listOf(), null)
        }

        override suspend fun searchParking(destination: Location): PlaceSearchResult {
            return PlaceSearchResult(destination.toGeoLocation(), null, listOf(), null)
        }

        override suspend fun searchPath(origin: Location, destination: Location, mode: TransportationMode) {
        }
    }
}
