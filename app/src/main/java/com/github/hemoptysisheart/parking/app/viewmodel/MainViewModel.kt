package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel.Status.*
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.core.logging.logSet
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.GeoLocation
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

    enum class Status {
        /**
         * 초기 상태.
         */
        INIT,

        /**
         * 현재 위치 획득.
         */
        LOCATION_READY,

        /**
         * 지도 UI 컴포넌트와 VM 연동 완료.
         */
        UI_LINKED;
    }

    /**
     * 위치정보 갱신 콜백.
     */
    private val locationCallback: (GeoLocation) -> Unit = {
        viewModelScope.launch {
            if (INIT == status.value) {
                status.emit(LOCATION_READY)
            }
            here.emit(it)
        }
    }

    val status = MutableStateFlow(INIT)

    /**
     * 위치가 바뀔 경우 갱신해서 UI에 반영한다.
     */
    val here = MutableStateFlow(locationModel.location)

    /**
     * 목적지 검색어.
     */
    val query = MutableStateFlow("")

    /**
     * UI에서 지도 중심을 받는다.
     */
    var center: LatLng? = null
        set(value) {
            logSet(TAG, "center", value)
            field = value
        }

    /**
     * UI에서 지도 확대 수준을 받는다.
     */
    var zoom: Float? = null
        set(value) {
            logSet(TAG, "zoom", value)
            field = value
        }

    init {
        locationModel.addCallback(TAG, locationCallback)
    }

    /**
     * UI가 VM과 연동됐음을 알릴 때 사용.
     */
    fun ready() {
        viewModelScope.launch {
            status.emit(UI_LINKED)
        }
    }

    fun search(query: String) {
        logArgs(TAG, "search", "query" to query)

        viewModelScope.launch {
            this@MainViewModel.query.emit(query)
        }

        viewModelScope.launch {
            // TODO 검색
        }
    }

    override fun onCleared() {
        Log.d(TAG, "#onCleared called.")

        locationModel.removeCallback(TAG)
    }

    override fun toString() = "$TAG(status=${status.value}, here=${here.value}, center=$center, zoom=$zoom)"
}
