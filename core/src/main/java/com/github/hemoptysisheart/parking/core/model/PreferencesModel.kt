package com.github.hemoptysisheart.parking.core.model

import android.content.SharedPreferences
import com.github.hemoptysisheart.parking.domain.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.Preferences
import java.time.Instant
import java.time.Instant.ofEpochMilli

class PreferencesModel(
    sharedPreferences: SharedPreferences
) : Preferences {
    class ExecutionPreferencesModel internal constructor(
        private val sharedPreferences: SharedPreferences
    ) : ExecutionPreferences {
        companion object {
            private const val TAG = "ExecutionPreferencesModel"

            const val INIT_START_AT = "$TAG.initStartAt"
            const val COLD_START_COUNT = "$TAG.coldStartCount"
            const val LAST_COLD_START_AT = "$TAG.lastColdStartAt"
        }

        override var initStartAt: Instant = sharedPreferences.getLong(INIT_START_AT, 0L).run { ofEpochMilli(this) }
            set(value) {
                sharedPreferences.edit().putLong(INIT_START_AT, value.toEpochMilli()).apply()
                field = value
            }

        override var coldStartCount: Long = sharedPreferences.getLong(COLD_START_COUNT, 0L)
            set(value) {
                sharedPreferences.edit().putLong(COLD_START_COUNT, value).apply()
                field = value
            }

        override var lastColdStartAt: Instant =
            sharedPreferences.getLong(LAST_COLD_START_AT, 0L).run { ofEpochMilli(this) }
            set(value) {
                sharedPreferences.edit().putLong(LAST_COLD_START_AT, value.toEpochMilli()).apply()
                field = value
            }

        fun increaseColdStart(now: Instant) {
            if (0L == coldStartCount) {
                initStartAt = now
            }
            coldStartCount++
            lastColdStartAt = now
        }

        override fun toString() =
            "$TAG(initStartAt=$initStartAt, coldStartCount=$coldStartCount, lastColdStartAt=$lastColdStartAt)"
    }

    override val execution = ExecutionPreferencesModel(sharedPreferences)
}