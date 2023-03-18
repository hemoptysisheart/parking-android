package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectRouteViewModel @Inject constructor(
    private val geoSearchModel: GeoSearchModel
) : ViewModel() {
    companion object {
        private const val TAG = "SelectRouteViewModel"
        private val LOGGER = Logger(TAG)
    }

    val location = MutableStateFlow<Location?>(null)

    fun init(id: String) {
        viewModelScope.launch {
            location.emit(geoSearchModel.read(id))
        }
    }
}
