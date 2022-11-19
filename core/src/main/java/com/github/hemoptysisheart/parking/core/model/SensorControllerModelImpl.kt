package com.github.hemoptysisheart.parking.core.model

import android.annotation.SuppressLint
import android.os.Looper
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.Priority
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SensorControllerModelImpl @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val locationModel: LocationModel
) : SensorControllerModel {
    companion object {
        private val TAG = SensorControllerModelImpl::class.simpleName
    }

    private val scope = CoroutineScope(Dispatchers.IO)

    @SuppressLint("MissingPermission")
    override fun configure() {
        Log.v(TAG, "#start called.")

        locationClient.requestLocationUpdates(
            LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 2_000L)
                .setMinUpdateIntervalMillis(1_000L)
                .build(),
            {
                scope.launch {
                    Log.v(TAG, "#start : location=$it")
                    locationModel.update(it)
                }
            },
            Looper.getMainLooper()
        )
    }
}
