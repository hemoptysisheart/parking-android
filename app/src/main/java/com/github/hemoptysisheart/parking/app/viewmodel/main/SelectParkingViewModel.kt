package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.domain.common.Types
import com.github.hemoptysisheart.parking.core.domain.search.Query
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.util.NonNegativeInt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
final class SelectParkingViewModel @Inject constructor(
        savedStateHandle: SavedStateHandle,
        private val placeModel: PlaceModel,
        private val locationModel: LocationModel,
        private val searchPreferences: SearchPreferences
) : BaseViewModel() {
    val destination: Place

    val parkingRadius: NonNegativeInt
        get() = searchPreferences.parking.distance

    private val _parkingList = MutableStateFlow(emptyList<Place>())
    val parkingList: StateFlow<List<Place>> = _parkingList

    private val _here = MutableStateFlow(locationModel.location!!)
    val here: StateFlow<Geolocation> = _here

    init {
        val id = SelectParkingInteraction.args(savedStateHandle)
        logger.d("#init : id=$id")
        if (Types.PLACE_GMP != id.type) {
            throw IllegalArgumentException("unsupported type : id=$id")
        }
        destination = viewModelScope.async {
            placeModel.read(id)
                    ?: throw IllegalArgumentException("destination does not exist : id=$id")
        }.getCompleted()

        val job = launch {
            val query = Query(
                    query = null,
                    center = destination.geolocation,
                    distance = searchPreferences.parking.distance
            )
            val parkingList = placeModel.searchParking(query)
            logger.d("#onStart : parkingList=$parkingList")
            _parkingList.emit(parkingList)
        }

        launch {
            job.join()
            logger.d("#init complete.")
        }
    }

    fun onMoveCamera(target: Geolocation, zoom: Float) {
        logger.d("#onMoveCamera args : target=$target, zoom=$zoom")
    }

    override fun onResume(owner: LifecycleOwner) {
        logger.d("#onResume args : owner=$owner")
        super.onResume(owner)

        launch {
            _here.emit(locationModel.location!!)
        }
    }

    override fun toString() = "SelectParkingViewModel(destination=${destination})"
}
