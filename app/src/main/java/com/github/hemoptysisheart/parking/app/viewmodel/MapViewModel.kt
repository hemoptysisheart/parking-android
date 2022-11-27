package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.MapModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.model.param.MapStateParams
import com.github.hemoptysisheart.parking.domain.MapState
import com.github.hemoptysisheart.parking.domain.Place
import com.github.hemoptysisheart.util.TimeProvider
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationModel: LocationModel,
    private val placeModel: PlaceModel,
    private val mapModel: MapModel,
    private val timeProvider: TimeProvider
) : ViewModel() {
    companion object {
        private val TAG = MapViewModel::class.simpleName
    }

    /**
     * 지도에 표시할 목적지.
     */
    val destination: MutableStateFlow<Place?> = MutableStateFlow(null)

    /**
     * 지도 중심.
     */
    val center = MutableStateFlow(LatLng(locationModel.location.latitude, locationModel.location.longitude))

    /**
     * 지도의 확대 수준.
     */
    val zoom = MutableStateFlow(MapState.ZOOM_DEFAULT)

    /**
     * 지도 상태를 갱신한다.
     */
    fun update(center: LatLng, zoom: Float) = viewModelScope.launch {
        Log.v(TAG, "#update args : center=$center, zoom=$zoom")
        this@MapViewModel.center.emit(center)
        this@MapViewModel.zoom.emit(zoom)
        mapModel.update(MapStateParams(center, zoom, timeProvider.instant()))
    }

    /**
     * 지도에 표시하기 위해 목적지를 지정한다.
     */
    fun setDestination(id: UUID) = viewModelScope.launch {
        destination.emit(placeModel.read(id))
    }

    override fun toString() = "$TAG(destination=$destination)"
}