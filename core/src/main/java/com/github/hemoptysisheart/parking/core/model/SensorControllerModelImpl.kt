package com.github.hemoptysisheart.parking.core.model

import android.annotation.SuppressLint
import android.os.Looper
import android.util.Log
import com.github.hemoptysisheart.parking.domain.SimpleLocation
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.Priority
import javax.inject.Inject

class SensorControllerModelImpl @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val locationModel: LocationModel
) : SensorControllerModel {
    companion object {
        private val TAG = SensorControllerModelImpl::class.simpleName
    }

    @SuppressLint("MissingPermission")
    override fun configure() {
        Log.v(TAG, "#start called.")

        locationClient.requestLocationUpdates(
            LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5_000L).build(),
            {
                locationModel.update(SimpleLocation(Long.MAX_VALUE, it.latitude, it.longitude))
            },
            Looper.getMainLooper()
        )
    }
}
