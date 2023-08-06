package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.annotation.StringRes
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt
import kotlinx.coroutines.flow.MutableStateFlow

class DistanceSettingViewModelet(
        base: BaseViewModel,
        enabled: Boolean,
        distance: NonNegativeInt,
        unit: DistanceUnit,
        @StringRes val label: Int,
        @StringRes val description: Int,
) : BaseViewModel.ViewModelet(base) {
    private val logger = AndroidLogger(this::class, key)
    private val vm = this

    val enable = MutableStateFlow(enabled)
    val distance = MutableStateFlow(distance)
    val unit = MutableStateFlow(unit)

    fun onChangeEnable(enable: Boolean) {
        logger.d("#onChangeEnabled($key) args : enable=$enable")

        launch {
            vm.enable.emit(enable)
        }
    }

    fun onChangeDistance(distance: String) {
        logger.d("#onChangeDistance ($key) args")

        launch {
            vm.distance.emit(NonNegativeInt(distance.toInt()))
        }
    }

    fun onChangeUnit(unit: DistanceUnit?) {
        logger.i("#onChangeUnit ($key) args : unit=$unit")
        if (null == unit) return

        launch {
            vm.unit.emit(unit)
        }
    }
}