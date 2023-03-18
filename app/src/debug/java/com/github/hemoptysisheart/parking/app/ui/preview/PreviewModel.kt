package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.model.GeoSearchModelImpl
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.dto.PlaceSearchResult
import com.github.hemoptysisheart.parking.core.model.dto.RouteSearchResult
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Overview

object PreviewModel {
    val LOCATION_MODEL = object : LocationModel {
        override val location: GeoLocation = GeoLocation(37.5638354, 126.9040477)

        override fun addCallback(key: Any, callback: (GeoLocation) -> Unit) {}

        override fun removeCallback(key: Any) {}
    }

    val PLACE_MODEL = object : GeoSearchModel {
        override suspend fun searchDestination(center: GeoLocation, query: String): PlaceSearchResult {
            return PlaceSearchResult(center, query, listOf(), null)
        }

        override suspend fun searchParking(destination: Location): PlaceSearchResult {
            return PlaceSearchResult(GeoLocation(destination.latitude, destination.longitude), null, listOf(), null)
        }

        override suspend fun searchRoute(
            origin: Location,
            destination: Location,
            mode: TransportationMode
        ): RouteSearchResult {
            return RouteSearchResult(
                origin,
                destination,
                GeoSearchModelImpl.TRANSPORTATION_MODE_MAP[mode]!!,
                Overview(listOf())
            )
        }
    }
}
