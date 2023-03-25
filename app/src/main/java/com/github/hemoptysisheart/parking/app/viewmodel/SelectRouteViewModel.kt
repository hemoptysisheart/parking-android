package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.domain.RouteImpl
import com.github.hemoptysisheart.parking.app.navigation.SelectRoutePageNavigation.Companion.PARAM_ID
import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode.DRIVING
import com.github.hemoptysisheart.parking.core.client.google.dto.TransportationMode.WALKING
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
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
    private val locationModel: LocationModel,
    private val geoSearchModel: GeoSearchModel
) : ViewModel() {
    companion object {
        private const val TAG = "SelectRouteViewModel"
        private val LOGGER = Logger(TAG)
    }

    private val SavedStateHandle.id: String
        get() {
            val id = get<String>(PARAM_ID)
                ?: throw IllegalStateException("$PARAM_ID is not exist.")
            LOGGER.v("#state.id : $id")
            return id
        }

    /**
     * TODO `state`로 넘겨받을 수 있는 방식으로 변경.
     */
    val origin = locationModel.location

    val destination = MutableStateFlow<Location?>(null)

    val focusedRoute = MutableStateFlow<Route?>(null)

    val routeMap = MutableStateFlow<Map<Location, Route>>(mapOf())

    init {
        val job = viewModelScope.launch {
            val destination = geoSearchModel.read(state.id)
                ?: throw IllegalArgumentException("location does not exist : id=${state.id}")
            this@SelectRouteViewModel.destination.emit(destination)

            val routeMap = geoSearchModel.searchParking(destination).places.map {
                RouteImpl(origin, it.item, destination)
            }.associateBy { it.parking }
            this@SelectRouteViewModel.routeMap.emit(routeMap)
        }

        viewModelScope.launch {
            job.join()
            if (routeMap.value.isNotEmpty()) {
                focusedRoute.emit(routeMap.value.entries.toList()[0].value)

                this@SelectRouteViewModel.routeMap.emit(
                    routeMap.value.values.map { fill(it) }
                        .associateBy { it.parking }
                )
            }
        }
    }

    private suspend fun fill(src: Route): Route {
        val route = RouteImpl(src.origin, src.parking, src.destination)
        route.driving = PartialRoute(geoSearchModel.searchRoute(origin, src.parking, DRIVING).overview)
        route.walking = PartialRoute(geoSearchModel.searchRoute(src.parking, src.destination, WALKING).overview)
        return route
    }
}
