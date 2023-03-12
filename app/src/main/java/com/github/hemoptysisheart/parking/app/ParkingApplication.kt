package com.github.hemoptysisheart.parking.app

import android.app.Application
import android.util.Log
import com.github.hemoptysisheart.parking.core.logging.AndroidLoggingHandler
import com.github.hemoptysisheart.parking.core.model.PreferencesModel
import com.github.hemoptysisheart.parking.domain.ExecutionPreferences
import com.github.hemoptysisheart.util.TimeProvider
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class ParkingApplication : Application() {
    companion object {
        private val TAG = ParkingApplication::class.simpleName
    }

    @Inject
    lateinit var timeProvider: TimeProvider

    @Inject
    lateinit var executionPreferences: ExecutionPreferences

    override fun onCreate() {
        Log.i(TAG, "#onCreate called.")
        super.onCreate()

        (executionPreferences as PreferencesModel.ExecutionPreferencesModel)
            .increaseColdStart(timeProvider.instant())
        Log.i(TAG, "#onCreate : executionPreferences=$executionPreferences")

        AndroidLoggingHandler.setup()
        MainScope().launch {
            // TODO
        }
    }
}
