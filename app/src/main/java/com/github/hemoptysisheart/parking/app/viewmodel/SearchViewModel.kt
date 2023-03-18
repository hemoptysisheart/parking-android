package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.RecommendItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val locationModel: LocationModel,
    private val geoSearchModel: GeoSearchModel
) : ViewModel() {
    companion object {
        private const val TAG = "SearchViewModel"
        private val LOGGER = Logger(TAG)
    }

    var here: Location = locationModel.location
        get() = locationModel.location
        private set

    private var searchJob: Job? = null

    val query = MutableStateFlow("")

    val resultList = MutableStateFlow(listOf<RecommendItem<*>>())

    val onQueryChange: (String) -> Unit = { it ->
        LOGGER.d("#onQueryChange args : query=$it")

        viewModelScope.launch {
            query.emit(it)
        }

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            resultList.emit(
                geoSearchModel.searchDestination(locationModel.location, it)
                    .places
            )
        }
    }

    fun select(item: RecommendItem<*>) {
        LOGGER.d("#select args : item=$item")
    }
}
