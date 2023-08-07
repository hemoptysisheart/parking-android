package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.annotation.StringRes
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * [com.github.hemoptysisheart.parking.app.ui.template.setting.DistanceSetting]용 VM.
 */
class DistanceSettingViewModelet(
        base: BaseViewModel,
        enabled: Boolean,
        distance: NonNegativeInt,
        unit: DistanceUnit,
        @StringRes val label: Int,
        @StringRes val description: Int,
        val defaultDistance: NonNegativeInt,
        val distanceRange: IntRange,
        private val postChange: suspend () -> Unit = { }
) : BaseViewModel.ViewModelet(base) {
    private val logger = AndroidLogger(this::class, key)

    private val _enable = MutableStateFlow(enabled)
    val enable: StateFlow<Boolean> = _enable

    private val _distance = MutableStateFlow(distance)
    val distance: StateFlow<NonNegativeInt> = _distance

    private val _unit = MutableStateFlow(unit)
    val unit: StateFlow<DistanceUnit> = _unit

    fun onToggleEnable(enable: Boolean) {
        logger.d("#onChangeEnabled($key) args : enable=$enable")

        launch {
            _enable.emit(enable)

            postChange()
        }
    }

    fun onChangeDistance(distance: String) {
        logger.d("#onChangeDistance ($key) args")

        val d = try {
            NonNegativeInt(distance.toInt())
        } catch (e: NumberFormatException) {
            logger.w("#onChangeDistance ($key) fail to parse. use default. : distance=$distance", e)
            defaultDistance
        }

        launch {
            _distance.emit(d)

            postChange()
        }
    }

    fun onChangeUnit(unit: DistanceUnit?) {
        logger.i("#onChangeUnit ($key) args : unit=$unit")
        if (null == unit) return

        launch {
            _unit.emit(unit)

            postChange()
        }
    }
}