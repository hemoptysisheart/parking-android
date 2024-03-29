package com.github.hemoptysisheart.parking.app.viewmodel.main

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.domain.search.Query
import com.github.hemoptysisheart.parking.core.domain.search.RecommendItemPlaceImpl
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.common.Object
import com.github.hemoptysisheart.parking.domain.search.RecommendItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * 목적지 검색
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
    val query = VmProperty("")

    /**
     * 검색 결과를 포함한 추천 목록.
     */
    val recommendItemList = VmProperty<List<RecommendItem<out Object>>?>(null)

    /**
     * 검색 결과에서 상세보기를 선택한 아이템.
     */
    val detail = VmProperty<Object?>(null)

    init {
        logger.d("#init complete.")
    }

    private suspend fun search(query: String) {
        this@DestinationSearchViewModel.query.set(query)

        if (query.isNotEmpty()) {
            val list = placeModel.searchDestination(
                    Query(
                            query = query,
                            center = locationModel.location!!,
                            distance = searchPreferences.destination.distance
                    )
            ).map { RecommendItemPlaceImpl(it) }
            recommendItemList.set(list)
        }
    }

    fun onChangeQuery(query: String) {
        logger.d("#onChangeQuery args : query=$query")

        searchJob?.cancel()
        searchJob = launch(progress = true) {
            search(query)
        }
    }

    fun showDetail(obj: Object) {
        logger.d("#showDetail args : obj=$obj")

        launch {
            detail.set(obj)
        }
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        searchJob?.cancel()
        searchJob = launch(true) {
            search(query.get())
        }
    }

    fun clearDetail() {
        logger.d("#clearDetail called.")

        launch {
            detail.set(null)
        }
    }

    override fun toString() = "$tag(query=$query, recommendItemList=$recommendItemList, detail=$detail)"
}
