package com.github.hemoptysisheart.parking.core.dummy.model

import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.domain.Location
import java.math.BigDecimal
import java.time.Instant
import java.time.temporal.ChronoUnit.MILLIS

object DummyLocationModel : LocationModel {
    override var current: Location = LocationEntity(
        BigDecimal(35.583323),
        BigDecimal(139.540254),
        Instant.now().truncatedTo(MILLIS)
    )

    override suspend fun update(src: android.location.Location, timestamp: Instant): Location {
        current = LocationEntity(BigDecimal(src.latitude), BigDecimal(src.longitude), timestamp.truncatedTo(MILLIS))
        return current
    }

    override fun addCallback(callback: LocationModel.UpdateCallback) {
    }

    override fun removeCallback(callback: LocationModel.UpdateCallback): Boolean {
        return true
    }
}