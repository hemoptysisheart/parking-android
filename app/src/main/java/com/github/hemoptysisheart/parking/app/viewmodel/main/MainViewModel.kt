package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.extension.latLng
import com.github.hemoptysisheart.parking.core.model.SensorModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.deprecate.GeoLocation
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 앱을 실행했을 때 나오는 초기 화면.
 * 지도를 출력하며 다음 행동을 유도한다.
 *
 * TODO 헤더에 안내문구 추가. 초기화면 헤더는 안내를 포함해 다용도로 쓸 수 있는 공간이다. 활용법을 찾아야 한다.
 * TODO 즐겨찾기 기능 추가 후 화면에 표시하기.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val sensorModel: SensorModel
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
        sensorModel.addLocationCallback(this, locationCallback)
    }

    override fun onCleared() {
        sensorModel.removeLocationCallback(this)
    }

    override fun toString() =
        "$TAG(initialized=$initialized, showHeader=${showHeader.value}, cameraGoto=${cameraGoto.value}"
}
