package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.ui.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.SensorModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [경로 선택 화면](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?type=design&node-id=505-508&mode=design)
 *
 * 목적지를 선택한 후, 가능한 여러 경로를 보여준다.
 * 각 경로의 정보를 보여주면서 사용자가 선택할 수 있도록 하고, 안내 화면으로 넘어가야 한다.
 */
@HiltViewModel
class SelectRouteViewModel @Inject constructor(
    handle: SavedStateHandle,
    private val sensorModel: SensorModel,
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private const val TAG = "SelectRouteViewModel"
        private val LOGGER = Logger(TAG)
    }

    val destinationId = SelectRouteInteraction.navArgs(handle)

    /**
     * TODO `state`로 넘겨받을 수 있는 방식으로 변경.
     */
    val origin = sensorModel.location

    val destination = MutableStateFlow<Location?>(null)

    val focusedRoute = MutableStateFlow<Route?>(null)

    val routeList = MutableStateFlow<List<Route>>(listOf())

    init {
        viewModelScope.launch {
            // 목적지 표시.
            val destination = locationModel.read(destinationId)
                ?: throw IllegalArgumentException("location does not exist : destinationId=$destinationId")
            this@SelectRouteViewModel.destination.emit(destination)

            // 주차장 우선 표시.
            val routeList = locationModel.searchRoute(origin, destination)
            this@SelectRouteViewModel.routeList.emit(routeList)

            // 경로 채워넣기.
            if (routeList.isNotEmpty()) {
                this@SelectRouteViewModel.routeList.emit(routeList.mapNotNull { locationModel.read(it.id) })
                focusedRoute.emit(this@SelectRouteViewModel.routeList.value[0])
            }
        }
    }

    fun focus(route: Route) {
        LOGGER.d("#focus args : route=$route")
        viewModelScope.launch {
            focusedRoute.emit(route)
        }
    }

    override fun toString() = "$TAG(" +
            "sensorModel=$sensorModel, locationModel=$locationModel, " +
            "destinationId=$destinationId, " +
            "origin=$origin, destination=${destination.value}, " +
            "focusedRoute=${focusedRoute.value}, routeList=${routeList.value}" +
            ")"
}
