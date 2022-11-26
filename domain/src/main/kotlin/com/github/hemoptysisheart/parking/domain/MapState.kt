package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.Creatable
import com.github.hemoptysisheart.util.RangeValidator

interface MapState : Creatable {
    companion object {
        const val ZOOM_DEFAULT = 17.0F

        /**
         * 참고 : [public static CameraUpdate newLatLngZoom (LatLng latLng, float zoom)](https://developers.google.com/android/reference/com/google/android/gms/maps/CameraUpdateFactory#public-static-cameraupdate-newlatlngzoom-latlng-latlng,-float-zoom)
         */
        const val ZOOM_MIN = 2.0F

        /**
         * 참고 : [public static CameraUpdate newLatLngZoom (LatLng latLng, float zoom)](https://developers.google.com/android/reference/com/google/android/gms/maps/CameraUpdateFactory#public-static-cameraupdate-newlatlngzoom-latlng-latlng,-float-zoom)
         */
        const val ZOOM_MAX = 21.0F

        val ZOOM_VALIDATOR = RangeValidator(min = ZOOM_MIN, max = ZOOM_MAX, includeMin = true, includeMax = true)
    }

    val id: Long

    val latitude: Double

    val longitude: Double

    val zoom: Float
}