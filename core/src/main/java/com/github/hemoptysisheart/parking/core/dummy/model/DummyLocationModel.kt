package com.github.hemoptysisheart.parking.core.dummy.model

import android.util.Log
import com.github.hemoptysisheart.parking.core.model.LocationModel

object DummyLocationModel : LocationModel {
    private val TAG = DummyLocationModel::class.simpleName

    override fun init() {
        Log.v(TAG, "#init called.")
    }

    override fun test() {
        Log.v(TAG, "#test called.")
    }
}