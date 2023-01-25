package com.github.hemoptysisheart.parking.core.model

import android.annotation.SuppressLint
import android.os.Looper
import android.util.Log
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.google.android.gms.location.*
import com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY

@SuppressLint("MissingPermission")  // TODO 권한 확인 추가 하고 삭제.
class LocationModelImpl(
    private val client: FusedLocationProviderClient
) : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName
    }

    private val callbacks = mutableMapOf<String, (GeoLocation) -> Unit>()

    override var location: GeoLocation = GeoLocation(0.0, 0.0)
        private set(value) {
            Log.v(TAG, "#location : $value")

            for (callback in callbacks.values) {
                callback(value)
            }
            field = value
        }

    init {
        client.requestLocationUpdates(
            LocationRequest.Builder(PRIORITY_HIGH_ACCURACY, 5_000L)
                .setMinUpdateIntervalMillis(1_000L)
                .build(),
            { this.location = GeoLocation(it.latitude, it.longitude) },
            Looper.getMainLooper()
        )

        client.lastLocation.addOnSuccessListener {
            location = GeoLocation(it.latitude, it.longitude)
        }
    }

    override fun addCallback(key: String, callback: (GeoLocation) -> Unit) {
        Log.v(TAG, "#addCallback args : key=$key, callback=$callback")

        callbacks[key] = callback
    }

    override fun removeCallback(key: String) {
        Log.v(TAG, "#removeCallback args : key=$key")

        callbacks.remove(key)
    }

    override fun toString() = "$TAG(here=$location)"
}
