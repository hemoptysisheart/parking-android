package com.github.hemoptysisheart.parking.app

import android.app.Application
import android.util.Log
import com.github.hemoptysisheart.parking.core.logging.AndroidLoggingHandler
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class ParkingApplication : Application() {
    companion object {
        private val TAG = ParkingApplication::class.simpleName
    }

    override fun onCreate() {
        Log.i(TAG, "#onCreate called.")
        super.onCreate()

        AndroidLoggingHandler.setup()
        MainScope().launch {
            // TODO
        }
    }
}
