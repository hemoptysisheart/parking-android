package com.github.hemoptysisheart.parking.app.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * [랜딩 맵](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-645)
 */
@HiltViewModel
class LandingMapViewModel @Inject constructor() : BaseViewModel() {
    init {
        logger.i("#init called.")
    }
}
