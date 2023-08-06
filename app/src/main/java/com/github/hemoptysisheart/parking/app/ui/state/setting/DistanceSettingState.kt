package com.github.hemoptysisheart.parking.app.ui.state.setting

import androidx.annotation.StringRes
import com.github.hemoptysisheart.parking.app.ui.state.UiState
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt

data class DistanceSettingState(
        @StringRes val label: Int,
        @StringRes val description: Int?,
        val enable: Boolean,
        /**
         * 거리. meter 단위.
         */
        val distance: NonNegativeInt?,
        /**
         * 거리 표시 단위.
         */
        val unit: DistanceUnit
) : UiState()
