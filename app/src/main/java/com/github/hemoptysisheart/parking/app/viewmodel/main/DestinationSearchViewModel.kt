package com.github.hemoptysisheart.parking.app.viewmodel.main

import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.domain.search.Query
import com.github.hemoptysisheart.parking.core.domain.search.RecommendItemPlaceImpl
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.search.RecommendItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * 목적지 검색
 *
 * - https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-653
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54311-34835&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1445&mode=design
 */
@HiltViewModel
class DestinationSearchViewModel @Inject constructor(
        private val searchPreferences: SearchPreferences,
        private val locationModel: LocationModel,
        private val placeModel: PlaceModel
) : BaseViewModel() {
    private var searchJob: Job? = null

    /**
     * 목적지 검색어
     */
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    /**
     * 검색 결과를 포함한 추천 목록.
     */
    private val _recommendItemList = MutableStateFlow<List<RecommendItem<*>>?>(null)
    val recommendItemList: StateFlow<List<RecommendItem<*>>?> = _recommendItemList

    init {
        logger.d("#init complete.")
    }

    fun onChangeQuery(query: String) {
        logger.d("#onChangeQuery args : query=$query")

        searchJob?.cancel()
        searchJob = launch(progress = true) {
            _query.emit(query)

            if (query.isEmpty()) {
                _recommendItemList.emit(emptyList())
            } else {
                val list = placeModel.searchDestination(
                        Query(query, locationModel.location!!, searchPreferences.destination.distance)
                ).map { RecommendItemPlaceImpl(it) }
                _recommendItemList.emit(list)
            }
        }
    }

    fun showDetail(place: Place) {
        logger.d("#showDetail args : place=$place")
    }
}
