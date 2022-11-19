package com.github.hemoptysisheart.parking.app

import android.app.Application
import android.util.Log
import com.github.hemoptysisheart.parking.core.model.HwSensorModel
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
    lateinit var hwSensorModel: HwSensorModel

    override fun onCreate() {
        super.onCreate()

        MainScope().launch {
            Log.i(TAG, "#onCreate start initialize.")

            hwSensorModel.configure()
        }
    }
}
