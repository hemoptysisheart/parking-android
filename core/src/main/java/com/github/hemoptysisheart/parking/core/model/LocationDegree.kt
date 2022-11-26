package com.github.hemoptysisheart.parking.core.model

import android.location.Location

/**
 * 참고 : [Decimal degrees](https://en.wikipedia.org/wiki/Decimal_degrees)
 */
enum class LocationDegree(
    /**
     * [Location.getAccuracy] 최소값. meter 단위.
     */
    val minAccuracy: Int
) {
    DEGREE_0(111_000),
    DEGREE_1(11_100),
    DEGREE_2(1_110),
    DEGREE_3(111),
    DEGREE_4(11),
    DEGREE_5(1);

    companion object {
        fun find(accuracy: Float): LocationDegree {
            return values().toList().sortedBy { it.minAccuracy }.firstOrNull { it.minAccuracy <= accuracy }
                ?: DEGREE_5
        }
    }
}