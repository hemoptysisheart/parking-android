package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(LocationViewModel::class)
    }
}
