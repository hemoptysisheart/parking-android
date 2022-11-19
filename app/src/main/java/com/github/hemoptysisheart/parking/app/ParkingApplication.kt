package com.github.hemoptysisheart.parking.app

import android.app.Application
import android.content.SharedPreferences
import android.os.Looper
import android.util.Log
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.Priority
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class ParkingApplication : Application() {
    companion object {
        val TAG = ParkingApplication::class.simpleName
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var locationClient: FusedLocationProviderClient

    @Inject
    lateinit var locationModel: LocationModel

    override fun onCreate() {
        super.onCreate()

        MainScope().launch {
            Log.i(TAG, "#onCreate start process initialize.")
            configureSensor()
        }
    }

    private suspend fun configureSensor() {
        // Location
        locationClient.requestLocationUpdates(
            LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5_000L), {},
            Looper.getMainLooper()
        )
    }
}
