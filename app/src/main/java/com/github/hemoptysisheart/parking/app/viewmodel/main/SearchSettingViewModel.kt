package com.github.hemoptysisheart.parking.app.viewmodel.main

import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.DistanceSettingViewModelet
import com.github.hemoptysisheart.parking.core.domain.common.NullLocale
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.parking.domain.common.Locale
import com.github.hemoptysisheart.util.NonNegativeInt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SearchSettingViewModel @Inject constructor(
        private val searchPreferences: SearchPreferences
) : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(SearchSettingViewModel::class)
    }

    @Suppress("LeakingThis")
    val destination = DistanceSettingViewModelet(
            base = this,
            enabled = searchPreferences.destination.enable,
            distance = searchPreferences.destination.distance,
            unit = searchPreferences.destination.unit,
            label = R.string.page_search_setting_distance_label,
            description = R.string.page_search_setting_distance_description,
            defaultDistance = NonNegativeInt(100_000),
            distanceRange = 0..1_000_000,
            postChange = this::postChange
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
            distanceRange = 0..5_000,
            postChange = this::postChange
    )

    private val _language = MutableStateFlow<Locale>(NullLocale)
    val language: StateFlow<Locale> = _language

    /**
     * 변경 후 공통 처리.
     */
    suspend fun postChange() {
        LOGGER.v("#postChange called.")

        // TODO 저장
        searchPreferences.destination.enable = destination.enable.value
        searchPreferences.destination.distance = destination.distance.value
        searchPreferences.destination.unit = destination.unit.value
    }

    fun onChangeLanguage(language: Locale) {
        LOGGER.d("#onChangeLanguage args : language=$language")

        launch {
            _language.emit(language)
            postChange()
        }
    }
}
