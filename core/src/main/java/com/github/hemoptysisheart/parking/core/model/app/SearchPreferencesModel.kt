package com.github.hemoptysisheart.parking.core.model.app

import android.content.SharedPreferences
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences.Companion.DEFAULT_DESTINATION_DISTANCE
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit.KILOMETER
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
                NonNegativeInt(sharedPreferences.getInt(KEY_DESTINATION_DISTANCE, DEFAULT_DESTINATION_DISTANCE))
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

        init {
            LOGGER.i("#init complete : $this")
        }
    }

    override fun toString() = "SearchPreferencesModel(editor=$editor, destination=$destination)"
}
