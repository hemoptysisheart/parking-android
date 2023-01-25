package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private val TAG = MainViewModel::class.simpleName!!
    }

    var here by mutableStateOf(locationModel.location)

    init {
        locationModel.addCallback(TAG) {
            here = it
        }
    }

    override fun onCleared() {
        Log.v(TAG, "#onCleared called.")

        locationModel.removeCallback(TAG)
    }

    override fun toString() = "$TAG(here=$here)"
}
