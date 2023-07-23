package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.PermissionModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LocationPermissionViewModel @Inject constructor(
    private val wizardPreferences: WizardPreferences,
    private val permissionModel: PermissionModel
) : BaseViewModel() {
    companion object {
        private const val TAG = "LocationPermissionViewModel"
        private val LOGGER = Logger(TAG)
    }

    val permission = MutableStateFlow(permissionModel.location)
    val permissionRequestedCount = MutableStateFlow(0)

    fun onClickRequestPermission() {
        LOGGER.d("#onClickRequestPermission called.")

        launch {
            wizardPreferences.locationPermissionRequested()

            permission.emit(permissionModel.location)
            permissionRequestedCount.emit(permissionRequestedCount.value + 1)
        }
    }

    override fun onResume(owner: LifecycleOwner) {
        LOGGER.v("#onResume args : owner=$owner")
        super.onResume(owner)

        launch {
            permission.emit(permissionModel.location)
        }
    }
}
