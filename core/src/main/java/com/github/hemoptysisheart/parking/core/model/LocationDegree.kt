package com.github.hemoptysisheart.parking.core.model

import android.location.Location
import java.math.MathContext

/**
 * 참고 : [Decimal degrees](https://en.wikipedia.org/wiki/Decimal_degrees)
 */
enum class LocationDegree(
    /**
     * [Location.accuracy]
     */
    val minAccuracy: Int,
    /**
     * [minAccuracy]에 따른 위도 유효숫자 적용.
     */
    val latitudeMathContext: MathContext,
    /**
     * [minAccuracy]에 따른 경도 유효숫자 적용.
     */
    val longitudeMathContext: MathContext
) {
    DEGREE_0(111_000, MathContext(4), MathContext(5)),
    DEGREE_1(11_100, MathContext(5), MathContext(6)),
    DEGREE_2(1_110, MathContext(6), MathContext(7)),
    DEGREE_3(111, MathContext(7), MathContext(8)),
    DEGREE_4(11, MathContext(8), MathContext(9)),
    DEGREE_5(1, MathContext(9), MathContext(10));

    companion object {
        fun find(accuracy: Float): LocationDegree {
            return values().toList().sortedBy { it.minAccuracy }.firstOrNull { it.minAccuracy <= accuracy }
                ?: DEGREE_5
        }
    }
}