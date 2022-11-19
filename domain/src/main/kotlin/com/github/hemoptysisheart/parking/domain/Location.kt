package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.Creatable
import java.math.BigDecimal

/**
 * 앱 사용중 위치 정보.
 */
interface Location : Creatable {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        val ID_VALIDATOR: (Long) -> Unit = { id ->
            if (0L > id) {
                throw IllegalArgumentException("id must be positive long : id=$id")
            }
        }

        val LATITUDE_MIN = BigDecimal("-90.0")
        val LATITUDE_MAX = BigDecimal("90.0")
        val LATITUDE_VALIDATOR: (BigDecimal) -> Unit = { latitude ->
            when {
                LATITUDE_MIN > latitude ->
                    throw IllegalArgumentException("latitude less than min : latitude=$latitude, MIN=$LATITUDE_MIN")
                LATITUDE_MAX < latitude ->
                    throw IllegalArgumentException("latitude greater than max : latitude=$latitude, MAX=$LATITUDE_MAX")
            }
        }

        val LONGITUDE_MIN = BigDecimal("-180.0")
        val LONGITUDE_MAX = BigDecimal("180.0")
        val LONGITUDE_VALIDATOR: (BigDecimal) -> Unit = { longitude ->
            when {
                LONGITUDE_MIN > longitude ->
                    throw IllegalArgumentException("longitude less than min : longitude=$longitude, MIN=$LONGITUDE_MIN")
                LONGITUDE_MAX < longitude ->
                    throw IllegalArgumentException("longitude greater than max : longitude=$longitude, MAX=$LONGITUDE_MAX")
            }
        }
    }

    val id: Long

    /**
     * 위도
     */
    val latitude: BigDecimal

    /**
     * 경도
     */
    val longitude: BigDecimal
}