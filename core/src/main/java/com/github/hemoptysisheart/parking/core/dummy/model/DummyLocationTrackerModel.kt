package com.github.hemoptysisheart.parking.core.dummy.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.model.LocationTrackerModel

object DummyLocationTrackerModel : LocationTrackerModel {
    private val TAG = DummyLocationTrackerModel::class.simpleName

    override fun start() {
        Log.v(TAG, "#start called.")
    }
}