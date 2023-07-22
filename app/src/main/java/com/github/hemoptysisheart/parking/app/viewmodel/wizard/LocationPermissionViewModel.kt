package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.PermissionModel
import com.github.hemoptysisheart.parking.core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.concurrent.atomic.AtomicInteger
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
    private val requestCount = AtomicInteger(0)

    fun refreshPermission(onFinally: () -> Unit = {}) {
        LOGGER.d("#refreshPermission called.")

        val count = requestCount.incrementAndGet()
        LOGGER.d("#refreshPermission : count=$count")
        launch {
            permission.emit(permissionModel.location)
            onFinally()
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
