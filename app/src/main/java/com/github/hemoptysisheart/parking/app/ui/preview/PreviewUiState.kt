package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.state.setting.DistanceSettingState
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt

fun previewDistanceSettingState(
        label: Int = R.string.page_search_setting_distance_label,
        description: Int? = R.string.page_search_setting_distance_description,
        enable: Boolean = true,
        distance: Int = 1_234,
        unit: DistanceUnit = DistanceUnit.KILOMETER
) = DistanceSettingState(
        label = label,
        description = description,
        enable = enable,
        distance = NonNegativeInt(distance),
        unit = unit,
)
