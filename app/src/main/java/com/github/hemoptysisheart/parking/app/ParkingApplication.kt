package com.github.hemoptysisheart.parking.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.github.hemoptysisheart.parking.core.logging.AndroidLoggingHandler
import com.github.hemoptysisheart.parking.core.model.PreferencesModel.ExecutionPreferencesModel
import com.github.hemoptysisheart.parking.domain.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.InstallPreferences
import com.github.hemoptysisheart.util.TimeProvider
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

@HiltAndroidApp
class ParkingApplication : Application() {
    companion object {
        private val TAG = ParkingApplication::class.simpleName
    }

    private val activityCallbacks = object : ActivityLifecycleCallbacks {
        private val counter = AtomicInteger()

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

        override fun onActivityStarted(activity: Activity) {}

        override fun onActivityResumed(activity: Activity) {
            Log.v(TAG, "#activityCallbacks.onActivityResumed args : activity=$activity")

            val count = counter.incrementAndGet()
            Log.i(TAG, "#activityCallbacks.onActivityResumed : count=$count")
            if (1 == count) {
                (executionPreferences as ExecutionPreferencesModel).increaseForeground(timeProvider.instant())
            }
        }

        override fun onActivityPaused(activity: Activity) {
            Log.v(TAG, "#activityCallbacks.onActivityPaused args : activity=$activity")

            val count = counter.decrementAndGet()
            Log.i(TAG, "#activityCallbacks.onActivityPaused : count=$count")
        }

        override fun onActivityStopped(activity: Activity) {}

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

        override fun onActivityDestroyed(activity: Activity) {}
    }

    @Inject
    lateinit var timeProvider: TimeProvider

    @Inject
    lateinit var installPreferences: InstallPreferences

    @Inject
    lateinit var executionPreferences: ExecutionPreferences

    override fun onCreate() {
        Log.i(TAG, "#onCreate called.")
        super.onCreate()

        registerActivityLifecycleCallbacks(activityCallbacks)

        if (!installPreferences.initialized) {
            installPreferences.initialize()
        }
        (executionPreferences as ExecutionPreferencesModel).increaseColdStart(timeProvider.instant())
        Log.i(TAG, "#onCreate : installPreferences=$installPreferences, executionPreferences=$executionPreferences")

        AndroidLoggingHandler.setup()
        MainScope().launch {
            // TODO
        }
    }
}
