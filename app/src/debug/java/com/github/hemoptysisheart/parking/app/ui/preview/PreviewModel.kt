package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.client.google.data.TransportationMode
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PermissionModel
import com.github.hemoptysisheart.parking.core.model.SensorModel
import com.github.hemoptysisheart.parking.core.model.data.DestinationSearchResult
import com.github.hemoptysisheart.parking.core.model.data.PlaceSearchResult
import com.github.hemoptysisheart.parking.core.model.data.RouteSearchResult
import com.github.hemoptysisheart.parking.core.model.data.TransportMapping
import com.github.hemoptysisheart.parking.domain.*
import com.github.hemoptysisheart.util.truncateToMillis
import java.time.Instant
import java.util.*

val INSTALL_PREFERENCES_MODEL = object : InstallPreferences {
    override val installId: UUID = UUID.randomUUID()
}

val EXECUTION_PREFERENCES_MODEL = object : ExecutionPreferences {
    override var initStartAt: Instant = Instant.now().truncateToMillis()
    override var coldStartCount: Long = 1L
    override var lastColdStartAt: Instant = Instant.now()
    override var foregroundCount: Long = 1L
    override var lastForegroundAt: Instant = Instant.now()
}

val WIZARD_PREFERENCES_MODEL = object : WizardPreferences {
    override var bootUpShow = true
    override var showCount = 1
    override var lastShownAt = Instant.now().truncateToMillis()
    override fun increaseShowCount() {
        showCount++
        lastShownAt = Instant.now().truncateToMillis()
    }
}

val PREFERENCES_MODEL = object : Preferences {
    override val install = INSTALL_PREFERENCES_MODEL
    override val execution = EXECUTION_PREFERENCES_MODEL
    override val wizard = WIZARD_PREFERENCES_MODEL
}

val SENSOR_MODEL = object : SensorModel {
    override val location: GeoLocation = GeoLocation(37.5638354, 126.9040477)

    override fun addLocationCallback(key: Any, callback: (GeoLocation) -> Unit) {}

    override fun removeLocationCallback(key: Any) {}
}

val LOCATION_MODEL = object : LocationModel {
    override suspend fun searchDestination(center: GeoLocation, query: String): DestinationSearchResult {
        return DestinationSearchResult(center, query, listOf())
    }

    override suspend fun read(id: String): Location? = null

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
            TransportMapping[mode],
            listOf(
                PartialRoute(
                    "preview data",
                    GeoBounds(
                        northEast = GeoLocation(35.6982605, 139.7074366),
                        southWest = GeoLocation(35.6896586, 139.7028543)
                    ),
                    listOf(),   // TODO 내용 채우기.
                    listOf()    // TODO 내용 채우기.
                )
            )
        )
    }

    override suspend fun searchRoute(origin: Location, destination: Location): List<Route> {
        TODO("Not yet implemented")
    }

    override suspend fun read(id: UUID): Route? {
        TODO("Not yet implemented")
    }
}

val PERMISSION_MODEL = object : PermissionModel {
    override var location: Boolean = false
}