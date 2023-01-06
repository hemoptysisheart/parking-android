package com.github.hemoptysisheart.parking.app.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.model.data.SearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val placeModel: PlaceModel,
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private val TAG = SearchViewModel::class.simpleName
    }

    val query = MutableStateFlow("")

    val searchResult = mutableStateOf<SearchResult?>(null)

    @Deprecated("prototyping code")
    val places = MutableStateFlow(placeModel.places)

    @Deprecated("prototyping code")
    fun read(id: UUID) = viewModelScope.launch {
        placeModel.read(id)
    }

    fun search(query: String) = viewModelScope.launch {
        Log.v(TAG, "#search args : query=$query")

        this@SearchViewModel.query.emit(query)
        val result = placeModel.search(query, locationModel.location)
        Log.v(TAG, "#search : result=$result")

        // TODO 장소 검색을 선점형으로 바꾸기.
        searchResult.value = result
    }

    override fun toString() = "$TAG(query=${query.value}, places=$places)"
}
