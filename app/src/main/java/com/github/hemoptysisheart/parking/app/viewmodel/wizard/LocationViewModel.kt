package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
        private val locationModel: LocationModel
) : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(LocationViewModel::class)
    }

    private val _granted = MutableStateFlow(locationModel.granted)
    val granted: StateFlow<Boolean> = _granted

    val location: Geolocation?
        get() = if (locationModel.granted) {
            locationModel.location
        } else {
            null
        }

    override fun onResume(owner: LifecycleOwner) {
        LOGGER.d("#onResume args : owner=$owner")
        super.onResume(owner)

        locationModel.reset()
        launch {
            _granted.emit(locationModel.granted)
        }
    }
}
