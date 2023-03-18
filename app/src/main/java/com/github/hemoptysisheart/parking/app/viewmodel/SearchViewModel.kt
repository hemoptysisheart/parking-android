package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val geoSearchModel: GeoSearchModel
) : ViewModel() {
    companion object {
        private const val TAG = "SearchViewModel"
        private val LOGGER = Logger(TAG)
    }

    val query = MutableStateFlow("")

    val onQueryChange: (String) -> Unit = {
        LOGGER.d("#onQueryChange args : query=$it")
    }
}
