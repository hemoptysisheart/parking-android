package com.github.hemoptysisheart.parking.app.viewmodel.launcher

import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * [스플래시](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-641)
 */
@HiltViewModel
class LauncherViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(LauncherViewModel::class)
    }

    init {
        LOGGER.i("#init called.")
    }
}
