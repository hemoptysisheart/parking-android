package com.github.hemoptysisheart.parking.app.viewmodel.launcher

import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(LauncherViewModel::class)
    }

    init {
        LOGGER.i("#init called.")
    }
}
