package com.github.hemoptysisheart.parking.core.model

import android.annotation.SuppressLint
import android.location.Location
import android.os.Looper
import android.util.Log
import com.github.hemoptysisheart.parking.domain.SimpleLocation
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import javax.inject.Inject

class LocationTrackerModelImpl @Inject constructor(
    private val client: FusedLocationProviderClient,
    private val locationModel: LocationModel
) : LocationTrackerModel, LocationListener {
    companion object {
        private val TAG = LocationTrackerModelImpl::class.simpleName
    }

    @SuppressLint("MissingPermission")
    override fun start() {
        Log.v(TAG, "#start called.")

        val request = LocationRequest()
        request.interval = 10_000L
        request.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        client.requestLocationUpdates(request, this, Looper.getMainLooper())
    }

    override fun onLocationChanged(location: Location) {
        locationModel.update(SimpleLocation(location.latitude, location.longitude))
    }
}
