package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.place.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
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
        private val placeModel: PlaceModel
) : BaseViewModel() {
    final lateinit var parking: Place
        private set
    final lateinit var destination: Place
        private set

    init {
        val args = SelectRouteInteraction.args(savedStateHandle)
        logger.v("#init : args=$args")

        viewModelScope.async {
            parking = placeModel.read(args.parking)
                    ?: throw IllegalArgumentException("parking does not exist : args=$args")
            destination = placeModel.read(args.destination)
                    ?: throw IllegalArgumentException("destination does not exist : args=$args")
        }.getCompleted()

        logger.d("#init complete.")
    }

    override fun toString() = "SelectRouteViewModel(parking=$parking, destination=$destination)"
}
