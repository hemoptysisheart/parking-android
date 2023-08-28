package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.domain.route.RouteImpl
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.model.RouteModel
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.route.Route
import com.github.hemoptysisheart.parking.domain.route.Transportation.DRIVING
import com.github.hemoptysisheart.parking.domain.route.Transportation.WALKING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * 경로 선택
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-681
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54312-34855&mode=design
 */
@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
class SelectRouteViewModel @Inject constructor(
        savedStateHandle: SavedStateHandle,
        private val locationModel: LocationModel,
        private val placeModel: PlaceModel,
        private val routeModel: RouteModel
) : BaseViewModel() {
    final lateinit var parking: Place
        private set
    final lateinit var destination: Place
        private set

    private val _here = MutableStateFlow(locationModel.location!!)
    val here: StateFlow<Geolocation> = _here

    private val _routeList = MutableStateFlow(listOf<Route>())
    val routeList: StateFlow<List<Route>> = _routeList

    init {
        val args = SelectRouteInteraction.args(savedStateHandle)
        logger.v("#init : args=$args")

        viewModelScope.async {
            parking = placeModel.read(args.parking)
                    ?: throw IllegalArgumentException("parking does not exist : args=$args")
            destination = placeModel.read(args.destination)
                    ?: throw IllegalArgumentException("destination does not exist : args=$args")
        }.getCompleted()

        launch(requestSignal = true) {
            val here = locationModel.location!!
            val driveList = routeModel.search(here, parking.geolocation, WALKING)
            val walkList = routeModel.search(parking.geolocation, destination.geolocation, DRIVING)

            val routeList = mutableListOf<RouteImpl>()
            for (drive in driveList) {
                for (walk in walkList) {
                    routeList.add(RouteImpl(here, parking, destination, drive, walk))
                }
            }
            _routeList.emit(routeList.toList())
        }

        logger.d("#init complete.")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        launch {
            _here.emit(locationModel.location!!)
        }
    }

    override fun toString() = "SelectRouteViewModel(parking=$parking, destination=$destination, here=${here.value})"
}
