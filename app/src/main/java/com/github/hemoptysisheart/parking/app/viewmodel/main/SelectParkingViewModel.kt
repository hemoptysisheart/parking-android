package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.domain.common.Types
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.place.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SelectParkingViewModel @Inject constructor(
        private val savedStateHandle: SavedStateHandle,
        private val placeModel: PlaceModel
) : BaseViewModel() {

    private val _destination = MutableStateFlow<Place?>(null)
    val destination: StateFlow<Place?> = _destination

    override fun onStart(owner: LifecycleOwner) {
        logger.d("#onStart args : owner=$owner")
        super.onStart(owner)

        val id = SelectParkingInteraction.args(savedStateHandle)
        if (Types.PLACE_GMP != id.type) {
            throw IllegalArgumentException("unsupported type : id=$id")
        }

        launch {
            val place = placeModel.read(id)
            logger.d("#onStart : place=$place")
            _destination.emit(place)
        }
    }

    override fun toString() = "SelectParkingViewModel(destination=${destination.value})"
}
