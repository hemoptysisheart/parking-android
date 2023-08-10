package com.github.hemoptysisheart.parking.core.model.app

import android.content.SharedPreferences
import com.github.hemoptysisheart.parking.core.domain.common.Locale.Companion.NAME_NULL_LOCALE
import com.github.hemoptysisheart.parking.core.domain.common.Locale.Companion.NAME_SYSTEM_LOCALE
import com.github.hemoptysisheart.parking.core.domain.common.NullLocale
import com.github.hemoptysisheart.parking.core.domain.common.SystemLocale
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences.Companion.DESTINATION_DISTANCE_DEFAULT
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences.Companion.PARKING_DISTANCE_DEFAULT
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit.KILOMETER
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit.METER
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.util.NonNegativeInt

class SearchPreferencesModel(
        sharedPreferences: SharedPreferences,
        private val editor: SharedPreferences.Editor
) : SearchPreferences {
    companion object {
        private const val TAG = "${PreferencesModel.TAG}.SearchPreferencesModel"
        private val LOGGER = AndroidLogger(TAG)

        private const val KEY_DESTINATION_ENABLE = "$TAG.destination.enable"
        private const val KEY_DESTINATION_DISTANCE = "$TAG.destination.distance"
        private const val KEY_DESTINATION_UNIT = "$TAG.destination.unit"
        private const val KEY_PARKING_ENABLE = "$TAG.parking.enable"
        private const val KEY_PARKING_DISTANCE = "$TAG.parking.distance"
        private const val KEY_PARKING_UNIT = "$TAG.parking.unit"
        private const val KEY_LANGUAGE = "$TAG.language"
    }

    override val destination = object : SearchPreferences.Distance {
        override var enable: Boolean = sharedPreferences.getBoolean(KEY_DESTINATION_ENABLE, true)
            set(value) {
                LOGGER.v("#destination.enable set : $value")

                editor.putBoolean(KEY_DESTINATION_ENABLE, value)
                        .apply()
                field = value
            }

        override var distance =
                NonNegativeInt(sharedPreferences.getInt(KEY_DESTINATION_DISTANCE, DESTINATION_DISTANCE_DEFAULT))
            set(value) {
                LOGGER.v("#destination.distance set : $value")

                editor.putInt(KEY_DESTINATION_DISTANCE, value.value)
                        .apply()
                field = value
            }

        override var unit = DistanceUnit[sharedPreferences.getInt(KEY_DESTINATION_UNIT, KILOMETER.ordinal)]
            set(value) {
                LOGGER.v("#distance.unit set : $value")

                editor.putInt(KEY_DESTINATION_UNIT, value.ordinal)
                        .apply()
                field = value
            }

        override fun toString() = "(enable=$enable, distance=$distance, unit=$unit)"
    }

    override val parking = object : SearchPreferences.Distance {
        override var enable: Boolean = sharedPreferences.getBoolean(KEY_PARKING_ENABLE, true)
            set(value) {
                LOGGER.v("#parking.enable set : $value")

                editor.putBoolean(KEY_PARKING_ENABLE, value)
                        .apply()
                field = value
            }

        override var distance = NonNegativeInt(sharedPreferences.getInt(KEY_PARKING_DISTANCE, PARKING_DISTANCE_DEFAULT))
            set(value) {
                LOGGER.v("#parking.distance set : $value")

                editor.putInt(KEY_PARKING_DISTANCE, value.value)
                        .apply()
                field = value
            }

        override var unit = DistanceUnit[sharedPreferences.getInt(KEY_PARKING_UNIT, METER.ordinal)]
            set(value) {
                LOGGER.v("#parking.unit set : $value")

                editor.putInt(KEY_PARKING_UNIT, value.ordinal)
                        .apply()
                field = value
            }

        override fun toString() = "(enable=$enable, distance=$distance, unit=$unit)"
    }

    init {
        LOGGER.d("#init : ${
            mapOf(
                    KEY_DESTINATION_ENABLE to sharedPreferences.getBoolean(KEY_DESTINATION_ENABLE, false),
                    KEY_DESTINATION_DISTANCE to sharedPreferences.getInt(KEY_DESTINATION_DISTANCE, 0),
                    KEY_DESTINATION_UNIT to sharedPreferences.getString(KEY_DESTINATION_UNIT, null),
                    KEY_PARKING_ENABLE to sharedPreferences.getBoolean(KEY_PARKING_ENABLE, false),
                    KEY_PARKING_DISTANCE to sharedPreferences.getInt(KEY_PARKING_DISTANCE, 0),
                    KEY_PARKING_UNIT to sharedPreferences.getString(KEY_PARKING_UNIT, null),
                    KEY_LANGUAGE to sharedPreferences.getString(KEY_LANGUAGE, null)
            )
        }")
    }

    override var language: Locale = com.github.hemoptysisheart.parking.core.domain.common.Locale[
            sharedPreferences.getString(KEY_LANGUAGE, NAME_NULL_LOCALE)!!]
        set(value) {
            LOGGER.v("#language set : $value")

            val name = when (value) {
                is NullLocale -> NAME_NULL_LOCALE
                is SystemLocale -> NAME_SYSTEM_LOCALE
                else -> throw IllegalArgumentException("unsupported type : value=$value, value.type=${value::class}")
            }
            editor.putString(KEY_LANGUAGE, name)
                    .apply()
            field = value
        }

    override fun toString() = "SearchPreferencesModel(editor=$editor, destination=$destination)"
}
