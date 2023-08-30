package com.github.hemoptysisheart.parking.core.model

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import androidx.core.content.ContextCompat.checkSelfPermission
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocationModelImpl(
        initLocation: Geolocation,
        private val context: Context,
        private val client: FusedLocationProviderClient,
        private val wizardPreferences: WizardPreferences
) : LocationModel {
    companion object {
        private val LOGGER = AndroidLogger(LocationModelImpl::class)
    }

    private val locationCallback: (Location) -> Unit = {
        val geolocation = Geolocation(it.latitude, it.longitude)
        location = geolocation
        _locations.value = geolocation
        wizardPreferences.lastLocation(geolocation)
    }

    override val granted: Boolean
        get() {
            val granted = PERMISSION_GRANTED == checkSelfPermission(context, ACCESS_FINE_LOCATION)
            LOGGER.v("#granted return : $granted")
            return granted
        }

    override var location: Geolocation? = wizardPreferences.lastLocation
        get() {
            LOGGER.v("#location return : $field")
            return field
        }
        private set

    private val _locations = MutableStateFlow(initLocation)

    override val locations: StateFlow<Geolocation> = _locations

    init {
        reset()
    }

    @SuppressLint("MissingPermission")
    override fun reset() {
        LOGGER.d("#reset called.")
        if (granted) {
            client.lastLocation.addOnSuccessListener(locationCallback)
        }
    }
}
