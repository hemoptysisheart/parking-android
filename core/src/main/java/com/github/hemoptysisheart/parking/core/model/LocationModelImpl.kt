package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.repository.LocationRepository
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.util.TimeProvider
import java.math.BigDecimal

class LocationModelImpl(
    private val repository: LocationRepository,
    private val timeProvider: TimeProvider
) : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName
    }

    override suspend fun update(src: android.location.Location): Location {
        val latitude = BigDecimal(src.latitude, LocationDegree.find(src.verticalAccuracyMeters).latitudeMathContext)
        val longitude = BigDecimal(src.longitude, LocationDegree.find(src.accuracy).longitudeMathContext)
        val entity = repository.create(LocationEntity(latitude, longitude, timeProvider.instant()))

        Log.v(TAG, "#update return : $entity")
        return entity
    }

    override fun toString() = "$TAG(repository=$repository, timeProvider=$timeProvider)"
}