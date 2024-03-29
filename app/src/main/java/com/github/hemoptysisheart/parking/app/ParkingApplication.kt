package com.github.hemoptysisheart.parking.app

import android.app.Activity
import android.app.Application
import com.github.hemoptysisheart.parking.BuildConfig
import com.github.hemoptysisheart.parking.app.activity.LauncherActivity
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.support.ActivityLifecycleCallbacksAdapter
import com.github.hemoptysisheart.parking.core.logging.AndroidLoggingHandler
import com.github.hemoptysisheart.parking.core.model.app.PreferencesModel.ExecutionPreferencesModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.app.InstallPreferences
import com.github.hemoptysisheart.util.TimeProvider
import dagger.hilt.android.HiltAndroidApp
import java.lang.reflect.Field
import java.time.Duration
import java.time.Instant
import javax.inject.Inject

@HiltAndroidApp
class ParkingApplication : Application() {
    companion object {
        private val LOGGER = AndroidLogger(ParkingApplication::class)

        private val BUILD_CONFIG_PROPERTY_SENSITIVE_NAMES = setOf("token", "key", "secret")

        private fun isSensitive(field: Field): Boolean {
            for (pattern in BUILD_CONFIG_PROPERTY_SENSITIVE_NAMES) {
                if (field.name.contains(pattern, true)) {
                    return true
                }
            }
            return false
        }
    }

    private val activityLifecycleCallbacks = object : ActivityLifecycleCallbacksAdapter() {
        private val countLock = Any()
        private var count = 0
        private var countDecreasedAt: Instant = Instant.MIN

        /**
         * 단순히 액티비티를 이동하더라도 [Activity.onPause]를 먼저 호출하기 때문에 [LauncherActivity]->[MainActivity]로 이동해도
         * 포어그라운드 실행이 2번으로 계산된다. 그래서 [count]가 `0`인 상태를 100ms 이상인 경우만 포어그라운드로 돌아온 것으로 간주한다.
         */
        private val minBackgroundDuration = Duration.ofMillis(100L)

        override fun onActivityResumed(activity: Activity) {
            LOGGER.v("#activityCallbacks.onActivityResumed args : activity=$activity")

            synchronized(countLock) {
                count++
                LOGGER.i("#activityCallbacks.onActivityResumed : count=$count")
                if (1 == count && minBackgroundDuration < Duration.between(countDecreasedAt, timeProvider.instant())) {
                    (executionPreferences as ExecutionPreferencesModel).increaseForeground(timeProvider.instant())
                }
            }
        }

        override fun onActivityPaused(activity: Activity) {
            LOGGER.v("#activityCallbacks.onActivityPaused args : activity=$activity")

            synchronized(countLock) {
                count--
                countDecreasedAt = timeProvider.instant()
                LOGGER.i("#activityCallbacks.onActivityPaused : count=$count")
            }
        }
    }

    @Inject
    lateinit var timeProvider: TimeProvider

    @Inject
    lateinit var installPreferences: InstallPreferences

    @Inject
    lateinit var executionPreferences: ExecutionPreferences

    override fun onCreate() {
        LOGGER.i("#onCreate called.")
        super.onCreate()

        for (field in BuildConfig::class.java.declaredFields) {
            if (isSensitive(field)) {
                LOGGER.d("#onCreate : BuildConfig.${field.name}=${"${field.get(null)}".take(3)}************")
            } else {
                LOGGER.d("#onCreate : BuildConfig.${field.name}=${field.get(null)}")
            }
        }

        registerActivityLifecycleCallbacks(activityLifecycleCallbacks)

        LOGGER.i("#onCreate : installPreferences=$installPreferences, executionPreferences=$executionPreferences")

        AndroidLoggingHandler.setup()
    }
}
