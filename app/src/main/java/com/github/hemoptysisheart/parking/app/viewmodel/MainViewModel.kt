package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.ui.state.OverlayState.*
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel.MapControl.GOTO_DESTINATION
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel.MapControl.GOTO_HERE
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.core.logging.logSet
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItem
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationModel: LocationModel,
    private val placeModel: PlaceModel
) : ViewModel() {
    companion object {
        private val TAG = MainViewModel::class.simpleName!!

        /**
         * 지도 기본 확대 수준.
         */
        const val DEFAULT_ZOOM_LEVEL = 17.0F
    }

    /**
     * VM이 외부 라이브러리인 Compose의 지도 UI를 조작할 때 사용.
     */
    enum class MapControl {
        /**
         * 현재 위치로 지도 중심을 이동.
         */
        GOTO_HERE,

        /**
         * 목적지로 지도 중심을 이동.
         */
        GOTO_DESTINATION
    }

    /**
     * 위치정보 갱신 콜백.
     */
    private val locationCallback: (GeoLocation) -> Unit = {
        viewModelScope.launch {
            if (null == here.value) {
                Log.v(TAG, "#locationCallback set GOTO_HERE : here=$it")
                mapControl.emit(GOTO_HERE)
            }
            here.emit(it)
        }
    }

    /**
     * 오버레이 표시 상태.
     */
    val overlay = MutableStateFlow(COLLAPSE)

    /**
     * 위치가 바뀔 경우 갱신해서 UI에 반영한다.
     */
    val here = MutableStateFlow<GeoLocation?>(null)

    /**
     * 목적지.
     */
    val destination = MutableStateFlow<Location?>(null)

    /**
     * 목적지 검색어.
     */
    val destinationQuery = MutableStateFlow("")

    /**
     * 목적지 검색 결과.
     */
    val destinationSearchResult = MutableStateFlow(listOf<RecommendItem<*>>())

    private val destinationSearchJobLock = Any()
    private var destinationSearchJob: Job? = null

    val parking = MutableStateFlow(listOf<RecommendItemLocation>())

    val mapControl = MutableStateFlow<MapControl?>(null)

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
    var zoom: Float = DEFAULT_ZOOM_LEVEL
        set(value) {
            logSet(TAG, "zoom", value)
            field = value
        }

    init {
        locationModel.addCallback(TAG, locationCallback)
    }

    fun searchDestination(query: String) {
        logArgs(TAG, "search", "query" to query)

        viewModelScope.launch {
            this@MainViewModel.destinationQuery.emit(query)
        }

        synchronized(destinationSearchJobLock) {
            destinationSearchJob?.run {
                Log.d(TAG, "#searchDestination cancel search job : searchDestinationJob=$destinationSearchJob")
                if (isActive) {
                    cancel()
                }
                destinationSearchJob = null
            }

            destinationSearchJob = viewModelScope.launch {
                val result = placeModel.searchDestination(center!!.toGeoLocation(), query)
                Log.d(TAG, "#searchDestination : result=$result")
                destinationSearchResult.emit(result.places)
            }
        }
    }

    fun setDestination(location: Location) {
        Log.v(TAG, "#setDestination args : location=$location")

        viewModelScope.launch {
            destination.emit(location)
            mapControl.emit(GOTO_DESTINATION)
            overlay.emit(COLLAPSE)
        }

        viewModelScope.launch {
            val result = placeModel.searchParking(location)
            parking.emit(result.places)
        }
    }

    fun onHideOverlay() {
        viewModelScope.launch {
            overlay.emit(HIDE)
        }
    }

    fun onShowOverlay() {
        viewModelScope.launch {
            overlay.emit(COLLAPSE)
        }
    }

    fun onCollapseOverlay() {
        viewModelScope.launch {
            overlay.emit(COLLAPSE)
        }
    }

    fun onExtendOverlay() {
        viewModelScope.launch {
            overlay.emit(EXTEND)
        }
    }

    fun done(control: MapControl) {
        viewModelScope.launch {
            if (control != mapControl.value) {
                Log.w(TAG, "#done value does not match : control=$control, mapContorl=${mapControl.value}")
            }
            mapControl.emit(null)
        }
    }

    override fun onCleared() {
        Log.d(TAG, "#onCleared called.")

        locationModel.removeCallback(TAG)
    }

    override fun toString() = "$TAG(overlay=${overlay.value}, here=${here.value}, " +
            "destinationQuery=${destinationQuery.value}, destinationSearchResult=${destinationSearchResult.value}" +
            "center=$center, zoom=$zoom)"
}
