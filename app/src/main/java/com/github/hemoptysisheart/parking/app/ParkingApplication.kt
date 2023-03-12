package com.github.hemoptysisheart.parking.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.github.hemoptysisheart.parking.app.activity.LauncherActivity
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.core.logging.AndroidLoggingHandler
import com.github.hemoptysisheart.parking.core.model.PreferencesModel.ExecutionPreferencesModel
import com.github.hemoptysisheart.parking.domain.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.InstallPreferences
import com.github.hemoptysisheart.util.TimeProvider
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.Instant
import javax.inject.Inject

@HiltAndroidApp
class ParkingApplication : Application() {
    companion object {
        private val TAG = ParkingApplication::class.simpleName
    }

    private val activityCallbacks = object : ActivityLifecycleCallbacks {
        private val countLock = Any()
        private var count = 0
        private var countDecreasedAt: Instant = Instant.MIN

        /**
         * 단순히 액티비티를 이동하더라도 [Activity.onPause]를 먼저 호출하기 때문에 [LauncherActivity]->[MainActivity]로 이동해도
         * 포어그라운드 실행이 2번으로 계산된다. 그래서 [count]가 `0`인 상태를 100ms 이상인 경우만 포어그라운드로 돌아온 것으로 간주한다.
         */
        private val minBackgroundDuration = Duration.ofMillis(100L)

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

        override fun onActivityStarted(activity: Activity) {}

        override fun onActivityResumed(activity: Activity) {
            Log.v(TAG, "#activityCallbacks.onActivityResumed args : activity=$activity")

            synchronized(countLock) {
                count++
                Log.i(TAG, "#activityCallbacks.onActivityResumed : count=$count")
                if (1 == count && minBackgroundDuration < Duration.between(countDecreasedAt, timeProvider.instant())) {
                    (executionPreferences as ExecutionPreferencesModel).increaseForeground(timeProvider.instant())
                }
            }
        }

        override fun onActivityPaused(activity: Activity) {
            Log.v(TAG, "#activityCallbacks.onActivityPaused args : activity=$activity")

            synchronized(countLock) {
                count--
                countDecreasedAt = timeProvider.instant()
                Log.i(TAG, "#activityCallbacks.onActivityPaused : count=$count")
            }
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
