package com.github.hemoptysisheart.parking.core.model

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.content.ContextCompat.checkSelfPermission
import com.github.hemoptysisheart.parking.core.util.Logger
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PermissionModelImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PermissionModel {
    companion object {
        private const val TAG = "PermissionModelImpl"
        private val LOGGER = Logger(TAG)
    }

    override var location: Boolean = false
        get() = PERMISSION_GRANTED == checkSelfPermission(context, ACCESS_FINE_LOCATION)
        private set

    override fun toString() = "$TAG(location=$location)"
}