package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.ui.interaction.main.NavigationInteraction
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.SensorModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.deprecate.GeoLocation
import com.github.hemoptysisheart.parking.domain.deprecate.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    handle: SavedStateHandle,
    private val sensorModel: SensorModel,
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private const val TAG = "NavigationViewModel"
        private val LOGGER = Logger(TAG)
    }

    private val hereCallback: (GeoLocation) -> Unit = {
        viewModelScope.launch {
            here.emit(it)
        }
    }

    val routeId = NavigationInteraction.navArgs(handle)

    val here = MutableStateFlow(sensorModel.location)
    val route = MutableStateFlow<Route?>(null)

    init {
        sensorModel.addLocationCallback(TAG, hereCallback)

        viewModelScope.launch {
            val r = locationModel.read(routeId)
            route.emit(r)
        }
    }

    override fun toString() = "$TAG(routeId=$routeId, route=${route.value})"
}
