package com.github.hemoptysisheart.parking.core.model

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject

class LocationTrackerModelImpl @Inject constructor(
    private val client: FusedLocationProviderClient
) : LocationTrackerModel {
    companion object {
        private val TAG = LocationTrackerModelImpl::class.simpleName
    }

    @Deprecated("Remove & call save location info.")
    private lateinit var location: Location

    @SuppressLint("MissingPermission")
    override fun start() {
        Log.v(TAG, "#start called.")

        client.lastLocation.addOnSuccessListener {
            location = it
        }
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    override fun toString() =
        "$TAG(client=$client, location=${if (this::location.isInitialized) location else "[ not initialized ]"})"
}