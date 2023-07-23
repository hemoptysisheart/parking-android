package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.SensorModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.deprecate.Location
import com.github.hemoptysisheart.parking.domain.deprecate.RecommendItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 목적지 검색 화면.
 *
 * TODO 검색어 입력 전에 추천 검색어 및 결과에서 선택한 했던 항목 등 추천 항목 보이기.
 * TODO 검색 결과가 없을 때 화면.
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val sensorModel: SensorModel,
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private const val TAG = "SearchViewModel"
        private val LOGGER = Logger(TAG)
    }

    private var searchJob: Job? = null

    final var here: Location = sensorModel.location
        get() = sensorModel.location
        private set

    val query = MutableStateFlow("")

    val resultList = MutableStateFlow(listOf<RecommendItem>())

    val onQueryChange: (String) -> Unit = { query ->
        LOGGER.d("#onQueryChange args : query=$query")

        viewModelScope.launch {
            this@SearchViewModel.query.emit(query)
        }

        searchJob?.cancel()
        if (query.isNotEmpty()) {
            searchJob = viewModelScope.launch {
                resultList.emit(
                    locationModel.searchDestination(sensorModel.location, query)
                        .placeList
                )
            }
        }
    }

    override fun toString() = "$TAG(sensorModel=$sensorModel, locationModel=$locationModel, " +
            "query=${query.value}, resultList=${resultList.value})"
}
