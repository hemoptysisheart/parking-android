package com.github.hemoptysisheart.parking.core.client.google.dto

/**
 * 장소 페이지.
 */
class NearbySearchResult(
    val meta: ResultMeta<NearbySearchParams>,
    /**
     * 장소 목록.
     */
    val places: List<PlaceDto>,
    /**
     * 다음 페이지 토큰.
     */
    val nextToken: String? = null
) {
    val hasNext = null != nextToken

    override fun toString() =
        "${NearbySearchResult::class.simpleName}(meta=$meta, places=$places, nextToken=$nextToken)"
}