package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val placeModel: PlaceModel
) : ViewModel() {
    companion object {
        private val TAG = SearchViewModel::class.simpleName
    }

    val query = MutableStateFlow("")

    fun search(query: String) {
        viewModelScope.launch {
            this@SearchViewModel.query.emit(query)
        }
    }

    @Deprecated("prototyping code")
    val places = MutableStateFlow(placeModel.places)

    @Deprecated("prototyping code")
    fun read(id: UUID) = placeModel.read(id)

    override fun toString() = "$TAG(query=${query.value}, places=$places)"
}