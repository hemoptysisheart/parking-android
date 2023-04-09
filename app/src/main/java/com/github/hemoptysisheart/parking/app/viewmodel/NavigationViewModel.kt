package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.app.navigation.NavigationPageNavigation
import com.github.hemoptysisheart.parking.core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class NavigationViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        private const val TAG = "NavigationViewModel"
        private val LOGGER = Logger(TAG)
    }

    private val id = NavigationPageNavigation.arguments(savedStateHandle)
}
