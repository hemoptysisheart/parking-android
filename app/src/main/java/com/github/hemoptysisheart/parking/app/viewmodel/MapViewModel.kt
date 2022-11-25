package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.MapModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
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

    val location = MutableStateFlow(locationModel.location)

    val destination: MutableStateFlow<Place?> = MutableStateFlow(null)

    fun updateMapCenter(latLng: LatLng) = viewModelScope.launch {
        mapModel.setCenter(latLng, timeProvider.instant())
    }

    fun updateMapZoomLevel(zoom: Float) = viewModelScope.launch {
        mapModel.setZoom(zoom, timeProvider.instant())
    }

    fun loadPlace(id: UUID) {
        viewModelScope.launch {
            destination.emit(placeModel.read(id))
        }
    }

    override fun toString() = "$TAG(destination=$destination)"
}