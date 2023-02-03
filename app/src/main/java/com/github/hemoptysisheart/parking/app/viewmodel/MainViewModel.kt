package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private val TAG = MainViewModel::class.simpleName!!
    }

    /**
     * 위치정보 갱신 콜백.
     */
    private val locationCallback: (GeoLocation) -> Unit = {
        center = LatLng(it.latitude, it.longitude)
    }

    /**
     * 위치가 바뀔 경우 갱신해서 UI에 반영한다.
     */
    val here = MutableStateFlow(locationModel.location)

    /**
     * UI에서 지도 중심을 받는다.
     */
    var center: LatLng? = null
        set(value) {
            Log.v(TAG, "#center args : value=$value")
            field = value
        }

    /**
     * UI에서 지도 확대 수준을 받는다.
     */
    var zoom: Float = 17.0F
        set(value) {
            Log.v(TAG, "#zoom args : value=$value")
            field = value
        }

    init {
        locationModel.addCallback(TAG, locationCallback)
    }

    override fun onCleared() {
        Log.v(TAG, "#onCleared called.")

        locationModel.removeCallback(TAG)
    }

    override fun toString() = "$TAG(here=${here.value}, center=$center, zoom=$zoom)"
}
