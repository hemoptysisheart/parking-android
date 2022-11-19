package com.github.hemoptysisheart.parking.core.dummy.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.model.SensorControllerModel

object DummySensorControllerModel : SensorControllerModel {
    private val TAG = DummySensorControllerModel::class.simpleName

    override fun configure() {
        Log.v(TAG, "#start called.")
    }
}