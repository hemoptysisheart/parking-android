package com.github.hemoptysisheart.parking.app.viewmodel

import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * [랜딩 맵](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-645)
 */
@HiltViewModel
class LandingMapViewModel @Inject constructor(
        private val locationModel: LocationModel
) : BaseViewModel() {
    companion object {
        const val DEFAULT_ZOOM = 17F
    }

    /**
     * 지도 중심.
     */
    private val _center = MutableStateFlow(locationModel.location!!)
    val center: StateFlow<Geolocation> = _center

    init {
        if (!locationModel.granted) {
            throw IllegalStateException("location permission does not granted.")
        }

        logger.i("#init complete.")
    }
}
