package com.github.hemoptysisheart.parking.core.model.app

import android.content.SharedPreferences
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.app.InstallPreferences
import com.github.hemoptysisheart.parking.domain.app.Preferences
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.util.TimeProvider
import java.time.Instant
import java.util.UUID

class PreferencesModel(
        sharedPreferences: SharedPreferences,
        timeProvider: TimeProvider
) : Preferences {
    companion object {
        internal const val TAG = "PreferencesModel"
    }

    class InstallPreferencesModel internal constructor(
            sharedPreferences: SharedPreferences,
            private val editor: SharedPreferences.Editor
    ) : InstallPreferences {
        companion object {
            private const val TAG = "${PreferencesModel.TAG}.InstallPreferences"
            private val LOGGER = AndroidLogger(TAG)

            const val INSTALL_ID = "$TAG.installId"
        }

        override val installId: UUID

        init {
            installId = sharedPreferences.getString(INSTALL_ID, null).let {
                if (null == it) {
                    val id = UUID.randomUUID()
                    editor.putString(INSTALL_ID, "$id")
                    id
                } else {
                    UUID.fromString(it)
                }
            }
            LOGGER.v("#init complete : $this")
        }

        override fun toString() = "(installId=$installId)"
    }

    class ExecutionPreferencesModel internal constructor(
            sharedPreferences: SharedPreferences,
            timeProvider: TimeProvider,
            private val editor: SharedPreferences.Editor
    ) : ExecutionPreferences {
        companion object {
            private const val TAG = "${PreferencesModel.TAG}.ExecutionPreferences"
            private val LOGGER = AndroidLogger(TAG)

            const val INIT_START_AT = "$TAG.initStartAt"
            const val COLD_START_COUNT = "$TAG.coldStartCount"
            const val LAST_COLD_START_AT = "$TAG.lastColdStartAt"
            const val FOREGROUND_COUNT = "$TAG.foregroundCount"
            const val LAST_FOREGROUND_AT = "$TAG.lastForegroundAt"
        }

        override val initStartAt: Instant

        override var coldStartCount: Long = sharedPreferences.getLong(COLD_START_COUNT, 0L)
            private set(value) {
                LOGGER.v("#coldStartCount set : $value")
                editor.putLong(COLD_START_COUNT, value)
                        .apply()
                field = value
            }

        override var lastColdStartAt: Instant = sharedPreferences.getLong(LAST_COLD_START_AT, Long.MIN_VALUE).run {
            Instant.ofEpochMilli(this)
        }
            private set(value) {
                LOGGER.v("#lastColdStartAt set : $value")
                editor.putLong(LAST_COLD_START_AT, value.toEpochMilli())
                        .apply()
                field = value
            }

        override var foregroundCount: Long = sharedPreferences.getLong(FOREGROUND_COUNT, 0L)
            private set(value) {
                LOGGER.v("#foregroundCount set : $value")
                editor.putLong(FOREGROUND_COUNT, value)
                        .apply()
                field = value
            }

        override var lastForegroundAt: Instant = sharedPreferences.getLong(LAST_FOREGROUND_AT, Long.MIN_VALUE).run {
            Instant.ofEpochMilli(this)
        }
            private set(value) {
                LOGGER.v("#lastForegroundAt set : $value")
                editor.putLong(LAST_FOREGROUND_AT, value.toEpochMilli())
                        .apply()
                field = value
            }

        init {
            val now = timeProvider.instant()
            initStartAt = sharedPreferences.getLong(INIT_START_AT, Long.MIN_VALUE).run {
                if (Long.MIN_VALUE == this) {
                    editor.putLong(INIT_START_AT, now.toEpochMilli())
                    now
                } else {
                    Instant.ofEpochMilli(this)
                }
            }
            coldStartCount++
            lastColdStartAt = now
        }

        fun increaseForeground(timestamp: Instant) {
            LOGGER.v("#increaseForeground args : timestamp=$timestamp")
            foregroundCount++
            lastForegroundAt = timestamp
        }

        override fun toString() = "(initStartAt=$initStartAt, " +
                "coldStartCount=$coldStartCount, lastColdStartAt=$lastColdStartAt, " +
                "foregroundCount=$foregroundCount, lastForegroundAt=$lastForegroundAt)"
    }

    class WizardPreferencesModel(
            sharedPreferences: SharedPreferences,
            private val timeProvider: TimeProvider,
            private val editor: SharedPreferences.Editor
    ) : WizardPreferences {
        companion object {
            private const val TAG = "${PreferencesModel.TAG}.WizardPreferencesModel"
            private val LOGGER = AndroidLogger(TAG)

            const val KEY_BOOT_UP_SHOW = "$TAG.bootUpShow"
            const val KEY_USED_COUNT = "$TAG.usedCount"
            const val KEY_LAST_USED_AT = "$TAG.lastUsedAt"
            const val KEY_LOCATION_PERMISSION_REQUESTED = "$TAG.locationPermissionRequested"
            const val KEY_LAST_LOCATION = "$TAG.lastLocation"
        }

        override var bootUpShow = sharedPreferences.getBoolean(KEY_BOOT_UP_SHOW, true)
            set(value) {
                LOGGER.v("#bootUpShow set : $value")

                editor.putBoolean(KEY_BOOT_UP_SHOW, value)
                        .apply()
                field = value
            }
        override var showCount = sharedPreferences.getInt(KEY_USED_COUNT, 0)
            set(value) {
                LOGGER.v("#usedCount set : $value")

                editor.putInt(KEY_USED_COUNT, value)
                        .apply()
                field = value
            }
        override var lastShownAt = Instant.ofEpochMilli(sharedPreferences.getLong(KEY_LAST_USED_AT, 0L))
            set(value) {
                LOGGER.v("#lastUsedAt set : $value")

                editor.putLong(KEY_LAST_USED_AT, value.toEpochMilli())
                        .apply()
                field = value
            }

        override var locationPermissionRequestCount = sharedPreferences.getInt(KEY_LOCATION_PERMISSION_REQUESTED, 0)
            set(value) {
                LOGGER.v("#locationPermissionRequested set : $value")
                if (0 >= value) {
                    throw IllegalArgumentException("value is less than zero : value=$value")
                }

                editor.putInt(KEY_LOCATION_PERMISSION_REQUESTED, value)
                        .apply()

                field = value
            }
        override var lastLocation = sharedPreferences.getString(KEY_LAST_LOCATION, null)?.let { Geolocation.parse(it) }
            private set(value) {
                LOGGER.v("#lastLocation set : $value")

                editor.putString(KEY_LAST_LOCATION, value?.toSimpleString())
                        .apply()
                field = value
            }

        override fun increaseShowCount() {
            showCount++
            lastShownAt = timeProvider.instant()
        }

        override fun locationPermissionRequested() {
            locationPermissionRequestCount++
        }

        override fun lastLocation(location: Geolocation) {
            lastLocation = location
        }

        override fun toString() = "$TAG(bootUpShow=$bootUpShow, showCount=$showCount, lastShownAt=$lastShownAt, " +
                "locationPermissionRequestCount=$locationPermissionRequestCount, lastLocation=$lastLocation)"
    }

    private val editor = sharedPreferences.edit()

    override val install = InstallPreferencesModel(sharedPreferences, editor)

    override val execution = ExecutionPreferencesModel(sharedPreferences, timeProvider, editor)

    override val wizard = WizardPreferencesModel(sharedPreferences, timeProvider, editor)

    override val search = SearchPreferencesModel(sharedPreferences, editor)

    init {
        editor.commit()
    }

    override fun toString() = "$TAG(install=$install, execution=$execution, wizard=$wizard)"
}
