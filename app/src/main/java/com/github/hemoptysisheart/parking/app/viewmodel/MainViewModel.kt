package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.google.android.gms.maps.model.CameraPosition
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
        private const val TAG = "MainViewModel"
        private val LOGGER = Logger(TAG)
    }

    private var initialized = false

    /**
     * 위치정보 갱신 콜백.
     */
    private val locationCallback: (GeoLocation) -> Unit = {
        viewModelScope.launch {
            if (!initialized) {
                LOGGER.d("#locationCallback initialize : here=$it")
                initialized = true
                cameraGoto.emit(CameraPosition.fromLatLngZoom(it.latLng, 17f))
            }
        }
    }

    val showHeader = MutableStateFlow(true)

    val cameraGoto = MutableStateFlow<CameraPosition?>(null)

    val onMapClick: (LatLng) -> Unit = {
        LOGGER.v("#onMapClick args : latLng=$it")
        viewModelScope.launch {
            val value = !showHeader.value
            showHeader.emit(value)
        }
    }

    val onCameraPositionChange: (CameraPosition) -> Unit = {
        LOGGER.v("#onCameraPositionChange args : position=$it")
        viewModelScope.launch {
            if (null != cameraGoto.value) {
                cameraGoto.emit(null)
            }
        }
    }

    init {
        locationModel.addCallback(this, locationCallback)
    }

    override fun onCleared() {
        locationModel.removeCallback(this)
    }

    override fun toString() =
        "$TAG(initialized=$initialized, showHeader=${showHeader.value}, cameraPosition=${cameraGoto}"
}
