package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.app.navigation.NavigationPageNavigation
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val locationModel: LocationModel
) : ViewModel() {
    companion object {
        private const val TAG = "NavigationViewModel"
        private val LOGGER = Logger(TAG)
    }

    private val id = NavigationPageNavigation.arguments(savedStateHandle)
}
