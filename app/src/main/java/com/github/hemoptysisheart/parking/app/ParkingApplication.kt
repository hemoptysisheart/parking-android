package com.github.hemoptysisheart.parking.app

import android.app.Application
import android.util.Log
import com.github.hemoptysisheart.parking.core.logging.AndroidLoggingHandler
import com.github.hemoptysisheart.parking.core.model.SensorControllerModel
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
    lateinit var sensorControllerModel: SensorControllerModel

    override fun onCreate() {
        super.onCreate()

        AndroidLoggingHandler.setup()
        MainScope().launch {
            Log.i(TAG, "#onCreate start initialize.")
            sensorControllerModel.configure()
        }
    }
}
