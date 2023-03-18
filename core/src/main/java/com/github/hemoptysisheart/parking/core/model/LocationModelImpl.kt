package com.github.hemoptysisheart.parking.core.model

import android.annotation.SuppressLint
import android.os.Looper
import com.github.hemoptysisheart.parking.core.logging.logArgs
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.google.android.gms.location.*
import com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY

@SuppressLint("MissingPermission")  // TODO 권한 확인 추가 하고 삭제.
class LocationModelImpl(
    private val client: FusedLocationProviderClient
) : LocationModel {
    companion object {
        private val TAG = LocationModelImpl::class.simpleName!!

        /**
         * 초기 좌표.
         */
        val INIT_LOCATION = GeoLocation(0.0, 0.0)
    }

    private val callbacks = mutableMapOf<Any, (GeoLocation) -> Unit>()

    /**
     * `lateinit var`로 설정 하거나 `null`로 설정 할 수 없으니 초기 좌표로 설정한다.
     */
    override var location: GeoLocation = INIT_LOCATION
        private set(value) {
            for (callback in callbacks.values) {
                callback(value)
            }
            field = value
        }

    /**
     * TODO `LauncherActivity`에서 권한을 확인 한 후에 쓸 수 있도록 메서드로 변경.
     */
    init {
        client.lastLocation.addOnSuccessListener {
            // 앱 실행시 위치 정보 설정하기.
            location = GeoLocation(it.latitude, it.longitude)
        }

        client.requestLocationUpdates(
            LocationRequest.Builder(PRIORITY_HIGH_ACCURACY, 5_000L)
                .setMinUpdateIntervalMillis(1_000L)
                .build(),
            { this.location = GeoLocation(it.latitude, it.longitude) },
            Looper.getMainLooper()
        )
    }

    override fun addCallback(key: Any, callback: (GeoLocation) -> Unit) {
        logArgs(TAG, "addCallback", "key" to key, "callback" to callback)

        callbacks[key] = callback
    }

    override fun removeCallback(key: Any) {
        logArgs(TAG, "removeCallback", "key" to key)

        callbacks.remove(key)
    }

    override fun toString() = "$TAG(here=$location)"
}
