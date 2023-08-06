package com.github.hemoptysisheart.parking.app.viewmodel.main

import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.DistanceSettingViewModelet
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchSettingViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(SearchSettingViewModel::class)
    }

    @Suppress("LeakingThis")
    val destination = DistanceSettingViewModelet(
            base = this,
            enabled = true,
            distance = NonNegativeInt(100_000),
            unit = DistanceUnit.KILOMETER,
            label = R.string.page_search_setting_distance_label,
            description = R.string.page_search_setting_distance_description,
            defaultDistance = NonNegativeInt(100_000),
            distanceRange = 0..1_000_000
    )

    @Suppress("LeakingThis", "LeakingThis")
    val parking = DistanceSettingViewModelet(
            base = this,
            enabled = true,
            distance = NonNegativeInt(200),
            unit = DistanceUnit.METER,
            label = R.string.page_search_setting_parking_label,
            description = R.string.page_search_setting_parking_description,
            defaultDistance = NonNegativeInt(200),
            distanceRange = 0..5_000
    )
}
