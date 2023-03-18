package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationModel: LocationModel,
    private val geoSearchModel: GeoSearchModel
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
                LOGGER.i("#locationCallback initialize : here=$it")
                center.emit(it.latLng)
                initialized = true
            }
        }
    }

    val showHeader = MutableStateFlow(true)
    val center = MutableStateFlow<LatLng?>(null)

    val onMapClick: (LatLng) -> Unit = {
        LOGGER.d("#onMapClick args : latLng=$it")
        viewModelScope.launch {
            val value = !showHeader.value
            showHeader.emit(value)
        }
    }

    init {
        locationModel.addCallback(this, locationCallback)
    }

    override fun onCleared() {
        locationModel.removeCallback(this)
    }
}
