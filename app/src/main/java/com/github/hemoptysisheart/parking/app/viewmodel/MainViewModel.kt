package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private val TAG = MainViewModel::class.simpleName!!
    }

    val here = MutableStateFlow(locationModel.location)

    val center = MutableStateFlow<LatLng?>(null)
    val zoom = MutableStateFlow(17.0F)

    init {
        locationModel.addCallback(TAG) {
            viewModelScope.launch {
                here.emit(it)

                if (null == center.value) {
                    center.emit(LatLng(it.latitude, it.longitude))
                }
            }
        }
    }

    override fun onCleared() {
        Log.v(TAG, "#onCleared called.")

        locationModel.removeCallback(TAG)
    }

    override fun toString() = "$TAG(here=${here.value}, center=${center.value}, zoom=${zoom.value})"
}
