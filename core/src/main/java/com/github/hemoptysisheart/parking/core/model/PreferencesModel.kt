package com.github.hemoptysisheart.parking.core.model

import android.content.SharedPreferences
import android.util.Log
import com.github.hemoptysisheart.parking.domain.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.InstallPreferences
import com.github.hemoptysisheart.parking.domain.Preferences
import java.time.Instant
import java.util.*

class PreferencesModel(
    sharedPreferences: SharedPreferences
) : Preferences {
    class InstallPreferencesModel internal constructor(
        private val sharedPreferences: SharedPreferences
    ) : InstallPreferences {
        companion object {
            private const val TAG = "InstallPreferences"

            const val INSTALL_ID = "$TAG.InstallPreferences"
        }

        override var installId = sharedPreferences.getString(INSTALL_ID, null)?.run {
            UUID.fromString(this)
        }
            private set(value) {
                Log.v(TAG, "#installId set : $value")
                sharedPreferences.edit()
                    .putString(INSTALL_ID, "$value")
                    .apply()
                field = value
            }

        override val initialized: Boolean = null != installId

        override fun initialize(params: Nothing?) {
            if (initialized) {
                throw IllegalStateException("already initialized.")
            }

            installId = UUID.randomUUID()
        }

        override fun toString() = "$TAG(installId=$installId)"
    }

    class ExecutionPreferencesModel internal constructor(
        private val sharedPreferences: SharedPreferences
    ) : ExecutionPreferences {
        companion object {
            private const val TAG = "ExecutionPreferencesModel"

            const val INIT_START_AT = "$TAG.initStartAt"
            const val COLD_START_COUNT = "$TAG.coldStartCount"
            const val LAST_COLD_START_AT = "$TAG.lastColdStartAt"
            const val FOREGROUND_COUNT = "$TAG.foregroundCount"
            const val LAST_FOREGROUND_AT = "$TAG.lastForegroundAt"
        }

        override var initStartAt: Instant = sharedPreferences.getLong(INIT_START_AT, 0L).run {
            Instant.ofEpochMilli(this)
        }
            private set(value) {
                Log.v(TAG, "#initStartAt set : $value")
                sharedPreferences.edit().putLong(INIT_START_AT, value.toEpochMilli()).apply()
                field = value
            }

        override var coldStartCount: Long = sharedPreferences.getLong(COLD_START_COUNT, 0L)
            private set(value) {
                Log.v(TAG, "#coldStartCount set : $value")
                sharedPreferences.edit().putLong(COLD_START_COUNT, value).apply()
                field = value
            }

        override var lastColdStartAt: Instant = sharedPreferences.getLong(LAST_COLD_START_AT, 0L).run {
            Instant.ofEpochMilli(this)
        }
            private set(value) {
                Log.v(TAG, "#lastColdStartAt set : $value")
                sharedPreferences.edit().putLong(LAST_COLD_START_AT, value.toEpochMilli()).apply()
                field = value
            }

        override var foregroundCount: Long = sharedPreferences.getLong(FOREGROUND_COUNT, 0L)
            private set(value) {
                Log.v(TAG, "#foregroundCount set : $value")
                sharedPreferences.edit().putLong(FOREGROUND_COUNT, value).apply()
                field = value
            }

        override var lastForegroundAt: Instant = sharedPreferences.getLong(LAST_FOREGROUND_AT, 0L).run {
            Instant.ofEpochMilli(this)
        }
            private set(value) {
                Log.v(TAG, "#lastForegroundAt set : $value")
                sharedPreferences.edit().putLong(LAST_FOREGROUND_AT, value.toEpochMilli()).apply()
                field = value
            }

        fun increaseColdStart(timestamp: Instant) {
            if (0L == coldStartCount) {
                initStartAt = timestamp
            }
            coldStartCount++
            lastColdStartAt = timestamp
        }

        fun increaseForeground(timestamp: Instant) {
            foregroundCount++
            lastForegroundAt = timestamp
        }

        override fun toString() = "$TAG(initStartAt=$initStartAt, " +
                "coldStartCount=$coldStartCount, lastColdStartAt=$lastColdStartAt, " +
                "foregroundCount=$foregroundCount, lastForegroundAt=$lastForegroundAt)"
    }

    companion object {
        private const val TAG = "PreferencesModel"
    }

    override val install = InstallPreferencesModel(sharedPreferences)

    override val execution = ExecutionPreferencesModel(sharedPreferences)

    override fun toString() = "$TAG(install=$install, execution=$execution)"
}
