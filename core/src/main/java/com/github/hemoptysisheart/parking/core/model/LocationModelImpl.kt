package com.github.hemoptysisheart.parking.core.model

import android.util.Log
import com.github.hemoptysisheart.parking.domain.Location

class LocationModelImpl : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName
    }

    override fun update(location: Location) {
        Log.v(TAG, "#update args : location=$location")
    }
}