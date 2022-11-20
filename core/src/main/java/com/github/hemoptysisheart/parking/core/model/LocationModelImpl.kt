package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.repository.LocationRepository
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.domain.Location
import java.math.BigDecimal
import java.time.Instant
import java.util.*

class LocationModelImpl(
    private val repository: LocationRepository
) : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName
    }

    private val updateCallbacks = Collections.synchronizedSet(mutableSetOf<LocationModel.UpdateCallback>())

    override lateinit var current: Location
        private set

    override suspend fun update(src: android.location.Location, timestamp: Instant): Location {
        val latitude = BigDecimal(src.latitude, LocationDegree.find(src.accuracy).latitudeMathContext)
        val longitude = BigDecimal(src.longitude, LocationDegree.find(src.accuracy).longitudeMathContext)
        val entity = repository.create(LocationEntity(latitude, longitude, timestamp))
        current = entity
        for (callback in updateCallbacks) {
            callback.onUpdate(entity)
        }

        Log.v(TAG, "#update return : $entity")
        return entity
    }

    override fun addCallback(callback: LocationModel.UpdateCallback) {
        Log.v(TAG, "#addCallback args : callback=$callback")

        updateCallbacks.add(callback)
    }

    override fun removeCallback(callback: LocationModel.UpdateCallback): Boolean {
        Log.v(TAG, "#removeCallback args : callback=$callback")

        return updateCallbacks.remove(callback)
    }

    override fun toString() = "$TAG(repository=$repository)"
}
