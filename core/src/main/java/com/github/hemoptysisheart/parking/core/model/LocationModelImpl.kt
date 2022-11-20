package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.repository.LocationRepository
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.util.TimeProvider
import java.math.BigDecimal
import java.time.Instant

class LocationModelImpl(
    private val repository: LocationRepository,
    private val timeProvider: TimeProvider
) : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName
    }

    override var location: Location = LocationEntity(BigDecimal(0.0), BigDecimal(0.0), timeProvider.instant())
        private set

    override suspend fun update(src: android.location.Location, timestamp: Instant): Location {
        val latitude = BigDecimal(src.latitude, LocationDegree.find(src.accuracy).latitudeMathContext)
        val longitude = BigDecimal(src.longitude, LocationDegree.find(src.accuracy).longitudeMathContext)
        val entity = repository.create(LocationEntity(latitude, longitude, timestamp))
        location = entity

        Log.v(TAG, "#update return : $entity")
        return entity
    }

    override fun toString() = "$TAG(repository=$repository, timeProvider=$timeProvider)"
}