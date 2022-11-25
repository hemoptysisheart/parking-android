package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.domain.Location
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.time.temporal.ChronoUnit.MILLIS

object DummyLocationModel : LocationModel {
    override var location: Location = LocationEntity(
        0.0,
        0.0,
        Instant.now().truncatedTo(ChronoUnit.MILLIS)
    )
        private set

    override suspend fun update(src: android.location.Location, timestamp: Instant): Location {
        location = LocationEntity(src.latitude, src.longitude, timestamp.truncatedTo(MILLIS))
        return location
    }
}