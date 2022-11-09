package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationModel: LocationModel,
    private val placeModel: PlaceModel
) : ViewModel() {
    companion object {
        private val TAG = MapViewModel::class.simpleName
    }

    val place: MutableStateFlow<Place?> = MutableStateFlow(null)

    fun loadPlace(id: UUID) {
        viewModelScope.launch {
            place.emit(placeModel.read(id))
        }
    }
}