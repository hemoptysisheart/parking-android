package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.domain.Coordinate
import com.github.hemoptysisheart.util.TimeProvider

class LocationModelImpl(
    private val timeProvider: TimeProvider
) : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName
    }

    override var location = Coordinate(0.0, 0.0)
        private set

    override suspend fun update(src: android.location.Location): Coordinate {
        Log.v(TAG, "#update args : src=$src")
        location = Coordinate(src.latitude, src.longitude)
        return location
    }

    override fun toString() = "$TAG(location=$location, timeProvider=$timeProvider)"
}