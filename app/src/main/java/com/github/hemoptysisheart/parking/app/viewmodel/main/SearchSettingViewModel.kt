package com.github.hemoptysisheart.parking.app.viewmodel.main

import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.state.setting.DistanceSettingState
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.DistanceSettingViewModelet
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SearchSettingViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(SearchSettingViewModel::class)
    }

    private val _destination = MutableStateFlow(
            DistanceSettingState(
                    R.string.page_search_setting_distance_label,
                    R.string.page_search_setting_distance_description,
                    true,
                    NonNegativeInt(100_000),
                    DistanceUnit.KILOMETER
            )
    )

    val destination = DistanceSettingViewModelet(
            this,
            true,
            NonNegativeInt(100_000),
            DistanceUnit.KILOMETER,
            R.string.page_search_setting_distance_label,
            R.string.page_search_setting_distance_description
    )

    private val _parking = MutableStateFlow(
            DistanceSettingState(
                    R.string.page_search_setting_parking_label,
                    R.string.page_search_setting_parking_description,
                    true,
                    NonNegativeInt(200),
                    DistanceUnit.METER
            )
    )
    val parking: StateFlow<DistanceSettingState> = _parking

    val _d = object : ViewModelet(this) {
        fun onChangeEnable(enable: Boolean) {
            LOGGER.d("#onChangeEnable args : enable=$enable")
        }
    }

    fun onChangeEnable(state: DistanceSettingState, enable: Boolean) {
        LOGGER.d("#onChangeEnable args : state=$state, enable=$enable")

        this@SearchSettingViewModel.launch {
        }
    }

    fun onChangeDestinationEnable(enable: Boolean) {
        LOGGER.d("#onChangeDestinationEnable args : enable=$enable")

        launch {
            _destination.emit(_destination.value.copy(enable = enable))
        }
    }

    fun onChangeDestinationDistance(distance: String) {
        LOGGER.d("#onChangeDestinationDistance args : distance=$distance")

        launch {
            val d = NonNegativeInt(distance.toInt(10))
            _destination.emit(_destination.value.copy(distance = d))
        }
    }

    fun onChangeDestinationDistanceUnit(unit: DistanceUnit?) {
        LOGGER.d("#onChangeDestinationDistanceUnit args : unit=$unit")
        if (null == unit) return

        launch {
            _destination.emit(_destination.value.copy(unit = unit))
        }
    }
}
