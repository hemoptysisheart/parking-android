package com.github.hemoptysisheart.parking.domain

/**
 * 장소 검색 조건.
 */
data class SearchFilter(
    /**
     * 검색어.
     */
    val query: String,
    /**
     * 검색할 위치.
     */
    val location: GeoLocation,
    /**
     * 검색 반경.
     */
    val radius: Int = RADIUS_DEFAULT
) {
    companion object {
        /**
         * 기본 검색 반경.
         */
        const val RADIUS_DEFAULT = 5_000

        /**
         * 최소 검색 반경.
         */
        const val RADIUS_MIN = 500
    }

    init {
        when {
            RADIUS_MIN > radius ->
                throw IllegalArgumentException("too small radius : radius=$radius, min=$RADIUS_MIN")
        }
    }
}
