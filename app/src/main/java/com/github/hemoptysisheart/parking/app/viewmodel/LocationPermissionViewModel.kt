package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.core.model.PermissionModel
import com.github.hemoptysisheart.parking.core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LocationPermissionViewModel @Inject constructor(
    private val permissionModel: PermissionModel
) : BaseViewModel() {
    companion object {
        private const val TAG = "LocationPermissionViewModel"
        private val LOGGER = Logger(TAG)
    }

    val permission = MutableStateFlow(permissionModel.location)

    fun refreshPermission() {
        LOGGER.d("#refreshPermission called.")

        launch {
            permission.emit(permissionModel.location)
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
