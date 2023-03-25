package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.app.navigation.SelectRoutePageNavigation.Companion.PARAM_ID
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItemLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectRouteViewModel @Inject constructor(
    state: SavedStateHandle,
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

    lateinit var destination: MutableStateFlow<Location>
        private set

    val parkingList = MutableStateFlow(listOf<RecommendItemLocation>())

    init {
        viewModelScope.launch {
            destination = geoSearchModel.read(state.id)?.let {
                LOGGER.d("#init : location=$it")
                MutableStateFlow(it)
            } ?: throw IllegalArgumentException("location does not exist : id=${state.id}")

            coroutineScope {
                launch {
                    val result = geoSearchModel.searchParking(destination.value)
                    parkingList.emit(result.places)
                }
            }
        }
    }
}
