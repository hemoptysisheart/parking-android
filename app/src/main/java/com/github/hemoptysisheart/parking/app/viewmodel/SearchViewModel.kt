package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val placeModel: PlaceModel
) : ViewModel() {
    companion object {
        private val TAG = SearchViewModel::class.simpleName
    }

    val places = MutableStateFlow(placeModel.places)

    fun read(id: UUID) = placeModel.read(id)

    override fun toString() = "$TAG(places=$places)"
}