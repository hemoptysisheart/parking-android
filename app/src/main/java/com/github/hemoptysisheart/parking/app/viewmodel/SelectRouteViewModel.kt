package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.domain.RouteImpl
import com.github.hemoptysisheart.parking.app.navigation.SelectRoutePageNavigation.Companion.PARAM_DESTINATION_ID
import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode.DRIVING
import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode.WALKING
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.SensorModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.PartialRoute
import com.github.hemoptysisheart.parking.domain.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectRouteViewModel @Inject constructor(
    state: SavedStateHandle,
    private val sensorModel: SensorModel,
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private const val TAG = "SelectRouteViewModel"
        private val LOGGER = Logger(TAG)
    }

    private val SavedStateHandle.destinationId: String
        get() {
            val id = get<String>(PARAM_DESTINATION_ID)
                ?: throw IllegalStateException("$PARAM_DESTINATION_ID is not exist.")
            LOGGER.v("#state.destinationId : $id")
            return id
        }

    /**
     * TODO `state`로 넘겨받을 수 있는 방식으로 변경.
     */
    val origin = sensorModel.location

    val destination = MutableStateFlow<Location?>(null)

    val focusedRoute = MutableStateFlow<Route?>(null)

    val routeMap = MutableStateFlow<Map<Location, Route>>(mapOf())

    init {
        viewModelScope.launch {
            val destination = locationModel.read(state.destinationId)
                ?: throw IllegalArgumentException("location does not exist : id=${state.destinationId}")
            this@SelectRouteViewModel.destination.emit(destination)

            val routeMap = locationModel.searchParking(destination).places.map {
                RouteImpl(origin, it.item, destination)
            }.associateBy { it.parking }
            this@SelectRouteViewModel.routeMap.emit(routeMap)

            if (routeMap.isNotEmpty()) {
                this@SelectRouteViewModel.routeMap.emit(
                    routeMap.values.map { fill(it) }
                        .associateBy { it.parking }
                )
                focusedRoute.emit(this@SelectRouteViewModel.routeMap.value.values.toList()[0])
            }
        }
    }

    private suspend fun fill(src: Route): Route {
        val route = RouteImpl(src.origin, src.parking, src.destination)
        route.driving = PartialRoute(locationModel.searchRoute(origin, src.parking, DRIVING).overview)
        route.walking = PartialRoute(locationModel.searchRoute(src.parking, src.destination, WALKING).overview)
        return route
    }

    override fun toString() = "$TAG(sensorModel=$sensorModel, locationModel=$locationModel, " +
            "origin=$origin, destination=${destination.value}, " +
            "focusedRoute=${focusedRoute.value}, routeMap=${routeMap.value})"
}
