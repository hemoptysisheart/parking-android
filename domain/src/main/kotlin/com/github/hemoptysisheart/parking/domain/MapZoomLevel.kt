package com.github.hemoptysisheart.parking.domain

/**
 * 지도의 확대 수준에 관한 정보.
 *
 * TODO 대응하는 검색 범위 추가.
 */
enum class MapZoomLevel(
    /**
     * 소수점 버림 한 확대 수준.
     */
    val level: Int
) {
    LV_3(3),
    LV_4(4),
    LV_5(5),
    LV_6(6),
    LV_7(7),
    LV_8(8),
    LV_9(9),
    LV_10(10),
    LV_11(11),
    LV_12(12),
    LV_13(13),
    LV_14(14),
    LV_15(15),
    LV_16(16),
    LV_17(17),
    LV_18(18),
    LV_19(19),
    LV_20(20),
    LV_21(21);

    companion object {
        /**
         * `zoom`에 해당하는 정보를 반환한다.
         */
        operator fun get(zoom: Float): MapZoomLevel {
            return values().firstOrNull { it.level >= zoom }
                ?: LV_21
        }
    }
}
