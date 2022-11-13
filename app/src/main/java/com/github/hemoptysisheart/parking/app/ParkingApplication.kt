package com.github.hemoptysisheart.parking.app

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
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

    override fun onCreate() {
        super.onCreate()

        MainScope().launch {
            Log.i(TAG, "#onCreate start process initialize.")
        }
    }
}
