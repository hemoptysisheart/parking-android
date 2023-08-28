package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.github.hemoptysisheart.parking.core.domain.common.SystemLocale
import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.model.GlobalChannelImpl
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.model.RouteModel
import com.github.hemoptysisheart.parking.domain.app.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.app.InstallPreferences
import com.github.hemoptysisheart.parking.domain.app.Preferences
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences.Companion.DESTINATION_DISTANCE_DEFAULT
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.route.SubRoute
import com.github.hemoptysisheart.parking.domain.route.Transportation
import com.github.hemoptysisheart.parking.domain.route.Waypoint
import com.github.hemoptysisheart.parking.domain.search.Query
import com.github.hemoptysisheart.util.NonNegativeInt
import com.github.hemoptysisheart.util.truncateToMillis
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.UUID

@Composable
private fun previewGlobalChannelImpl() = remember {
    GlobalChannelImpl()
}

@Composable
fun previewGlobalChannelConsumer(): GlobalChannelConsumer = previewGlobalChannelImpl()

@Composable
fun previewGlobalChannel(): GlobalChannel = previewGlobalChannelImpl()

fun previewPreferencesModel(): Preferences = object : Preferences {
    override val install = object : InstallPreferences {
        override val installId = UUID.randomUUID()
    }

    override val execution = object : ExecutionPreferences {
        override val initStartAt = Instant.now().truncatedTo(ChronoUnit.MILLIS)
        override val coldStartCount: Long = 1L
        override val lastColdStartAt: Instant = initStartAt
        override val foregroundCount: Long = 1L
        override val lastForegroundAt: Instant = initStartAt
    }

    override val wizard = object : WizardPreferences {
        override var bootUpShow: Boolean = true
        override var showCount: Int = 0
        override val lastShownAt: Instant = Instant.now().truncateToMillis()
        override var locationPermissionRequestCount: Int = 0
        override var lastLocation: Geolocation? = null

        override fun increaseShowCount() {
            showCount++
        }

        override fun locationPermissionRequested() {
            locationPermissionRequestCount++
        }

        override fun lastLocation(location: Geolocation) {
            lastLocation = location
        }
    }

    override val search = object : SearchPreferences {
        override val destination = object : SearchPreferences.Distance {
            override var enable: Boolean = true
            override var distance = NonNegativeInt(DESTINATION_DISTANCE_DEFAULT)
            override var unit: DistanceUnit = DistanceUnit.KILOMETER
        }

        override val parking = object : SearchPreferences.Distance {
            override var enable: Boolean = true
            override var distance = NonNegativeInt(200)
            override var unit = DistanceUnit.METER
        }

        override var language: Locale = SystemLocale
    }
}

fun previewLocationModel(
        granted: () -> Boolean = { true },
        geolocation: () -> Geolocation = { GEOLOCATION_시부야역 }
) = object : LocationModel {
    override val granted: Boolean = granted()

    override val location: Geolocation = geolocation()

    override fun reset() {}
}

fun previewPlaceModel(
        searchList: () -> List<Place> = { emptyList() }
) = object : PlaceModel {
    val places = listOf(
            PLACE_로손편의점_니시신주쿠_7_10_19,
            PLACE_로손편의점_오사키_1_11_2,
            PLACE_로손오오테센터빌딩점_1_1_3,
            PLACE_로손편의점_스미요시_2_22,
            PLACE_PALACE_BLDG_PARKING_LOT,
            PLACE_OTEMACHI_FIRST_SQARE_PARKING_LOT,
            PLACE_丸の内ガーデンタワー_バイク駐車場,
            PLACE_TIMES_NIHON_SEIMEI_MARUNOUCHI_GARDEN_TOWER,
            PLACE_OTEMACHI_BUILDING_PARKING,
            PLACE_OTEMACHIONE_BIKE_LOCKER,
            PLACE_MODE_GAKUEN_COCOON_TOWER_PARKING_LOT
    ).associateBy { it.id }.toMutableMap()

    override suspend fun read(id: Identifier) = places[id]

    override suspend fun searchParking(query: Query): List<Place> = emptyList()

    override suspend fun searchDestination(query: Query) = searchList()
}

fun previewRouteModel(): RouteModel = object : RouteModel {
    override suspend fun search(start: Waypoint, end: Waypoint, transportation: Transportation): List<SubRoute> {
        TODO("Not yet implemented")
    }
}
