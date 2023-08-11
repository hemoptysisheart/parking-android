package com.github.hemoptysisheart.parking.core.model

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import androidx.core.content.ContextCompat
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.google.android.gms.location.FusedLocationProviderClient

class LocationModelImpl(
        private val context: Context,
        private val client: FusedLocationProviderClient
) : LocationModel {
    companion object {
        private val LOGGER = AndroidLogger(LocationModelImpl::class)
    }

    private val locationCallback: (Location) -> Unit = {
        this@LocationModelImpl.location = Geolocation(it.latitude, it.longitude)
    }

    override var granted: Boolean = false
        get() = PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, ACCESS_FINE_LOCATION)
        private set

    override var location: Geolocation = Geolocation(0.0, 0.0)
        get() {
            if (!granted) {
                throw IllegalStateException("not granted.")
            }
            return field
        }
        private set

    init {
        reset()
    }

    @SuppressLint("MissingPermission")
    override fun reset() {
        LOGGER.d("#reset called.")
        if (granted) {
            client.lastLocation.addOnSuccessListener(locationCallback)
        }
    }
}
