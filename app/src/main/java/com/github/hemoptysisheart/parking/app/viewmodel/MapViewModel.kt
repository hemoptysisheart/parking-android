package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private val TAG = MapViewModel::class.simpleName
    }

    fun test() {
        Log.v(TAG, "#test called")
        locationModel.test()
    }
}