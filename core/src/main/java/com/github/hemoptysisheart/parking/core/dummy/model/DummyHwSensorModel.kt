package com.github.hemoptysisheart.parking.core.dummy.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.model.HwSensorModel

object DummyHwSensorModel : HwSensorModel {
    private val TAG = DummyHwSensorModel::class.simpleName

    override fun configure() {
        Log.v(TAG, "#start called.")
    }
}