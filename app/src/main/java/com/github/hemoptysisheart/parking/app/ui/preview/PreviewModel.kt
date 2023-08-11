package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.github.hemoptysisheart.parking.core.domain.common.SystemLocale
import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.model.GlobalChannelImpl
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.app.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.app.InstallPreferences
import com.github.hemoptysisheart.parking.domain.app.Preferences
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences.Companion.DESTINATION_DISTANCE_DEFAULT
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.parking.domain.place.Geolocation
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

        override fun increaseShowCount() {
            showCount++
        }

        override fun locationPermissionRequested() {
            locationPermissionRequestCount++
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
        granted: Boolean = true,
        geolocation: Geolocation = Geolocation(0.0, 0.0)
) = object : LocationModel {
    override val granted: Boolean = granted

    override val location: Geolocation = geolocation

    override fun reset() {}
}
