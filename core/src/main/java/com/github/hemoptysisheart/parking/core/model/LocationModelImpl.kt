package com.github.hemoptysisheart.parking.core.model

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject

class LocationModelImpl @Inject constructor(
    private val client: FusedLocationProviderClient
) : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName
    }

    private lateinit var location: Location

    @SuppressLint("MissingPermission")
    override fun init() {
        Log.v(TAG, "#init called.")

        client.lastLocation.addOnSuccessListener {
            location = it
        }
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    override fun toString() =
        "$TAG(client=$client, location=${if (this::location.isInitialized) location else "[ not initialized ]"})"
}