package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
        private val locationModel: LocationModel,
        private val wizardPreferences: WizardPreferences
) : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(LocationViewModel::class)
    }


    private val _granted = MutableStateFlow(locationModel.granted)
    val granted: StateFlow<Boolean> = _granted

    private val _permissionRequestCount = MutableStateFlow(wizardPreferences.locationPermissionRequestCount)
    val permissionRequestCount: StateFlow<Int> = _permissionRequestCount

    private val _location = MutableStateFlow<Geolocation?>(null)
    val location: StateFlow<Geolocation?> = _location

    fun onClickRequestPermission() {
        LOGGER.d("#onClickRequestPermission called.")

        wizardPreferences.locationPermissionRequested()
    }

    override fun onResume(owner: LifecycleOwner) {
        LOGGER.d("#onResume args : owner=$owner")
        super.onResume(owner)

        locationModel.reset()

        launch {
            _permissionRequestCount.emit(wizardPreferences.locationPermissionRequestCount)

            delay(100)
            _granted.emit(locationModel.granted)
            if (locationModel.granted) {
                _location.emit(locationModel.location)
            }
        }
    }
}
