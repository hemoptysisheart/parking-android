package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.room.entity.LocationEntity
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val placeModel: PlaceModel,
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private val TAG = MapViewModel::class.simpleName
    }

    val location: MutableStateFlow<Location> = MutableStateFlow(
        LocationEntity(
            BigDecimal(0.0),
            BigDecimal(0.0),
            Instant.now().truncatedTo(ChronoUnit.MILLIS)
        )
    )

    val zoom = MutableStateFlow(17.0F)

    private val locationUpdateCallback: (Location) -> Unit = {
        viewModelScope.launch {
            location.emit(it)
        }
    }

    val destination: MutableStateFlow<Place?> = MutableStateFlow(null)

    fun loadPlace(id: UUID) {
        viewModelScope.launch {
            val p = placeModel.read(id)
            Log.v(TAG, "#loadPlace : p=$p")
            destination.emit(p)
        }
    }

    override fun toString() = "$TAG(destination=$destination)"
}