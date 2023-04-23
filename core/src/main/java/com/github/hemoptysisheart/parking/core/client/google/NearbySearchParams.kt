package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.data.PlaceType
import com.github.hemoptysisheart.parking.core.client.google.data.RankBy
import java.util.*

/**
 * [주변 지역 검색](https://developers.google.com/maps/documentation/places/web-service/search-nearby) 파라미터.
 */
data class NearbySearchParams(
    /**
     * 검색할 위치의 위도.
     * [location](https://developers.google.com/maps/documentation/places/web-service/search-nearby#location)
     */
    val longitude: Double,
    /**
     * 검색할 위치의 경도.
     * [location](https://developers.google.com/maps/documentation/places/web-service/search-nearby#location)
     */
    val latitude: Double,
    /**
     * 검색어.
     * [keyword](https://developers.google.com/maps/documentation/places/web-service/search-nearby#keyword)
     */
    val keyword: String? = null,
    /**
     * 검색할 언어. `null`이면 `PlacesClientConfig.locale`을 사용한다.
     * [language](https://developers.google.com/maps/documentation/places/web-service/search-nearby#language)
     *
     * [영어가 아닌 언어로 Google Maps Platform 제품을 표시하려면 어떻게 해야 하나요?](https://developers.google.com/maps/faq#languagesupport) 참조.
     */
    val locale: Locale? = null,
    /**
     * [minprice](https://developers.google.com/maps/documentation/places/web-service/search-nearby#minprice)
     */
    val minPrice: Int? = null,
    /**
     * [maxprice](https://developers.google.com/maps/documentation/places/web-service/search-nearby#maxprice)
     */
    val maxPrice: Int? = null,
    /**
     * [opennow](https://developers.google.com/maps/documentation/places/web-service/search-nearby#opennow)
     */
    val open: Boolean? = null,
    /**
     * 검색할 위치([longitude], [latitude])의 반경. 미터(meter) 단위.
     * [radius](https://developers.google.com/maps/documentation/places/web-service/search-nearby#radius)
     */
    val radius: Int? = null,
    val rankBy: RankBy? = null,
    val type: PlaceType? = null
) {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        const val PRICE_MIN = 0
        const val PRICE_MAX = 4
        val MAX_PRICE_RANGE = PRICE_MIN..PRICE_MAX
    }

    init {
        minPrice?.also {
            when {
                it < PRICE_MIN -> throw IllegalArgumentException("minPrice is less than min : minPrice=$it, min=$PRICE_MIN")
                it > PRICE_MAX -> throw IllegalArgumentException("minPrice is greater than max : minPrice=$it, max=$PRICE_MAX")
            }
        }
        maxPrice?.also {
            when {
                it < PRICE_MIN -> throw IllegalArgumentException("maxPrice is less than min : maxPrice=$it, min=$PRICE_MIN")
                it > PRICE_MAX -> throw IllegalArgumentException("maxPrice is greater than max : maxPrice=$it, min=$PRICE_MAX")
                null != minPrice && it < minPrice -> throw IllegalArgumentException("maxPrice is less than minPrice : maxPrice=$maxPrice, minPrice=$minPrice")
            }
        }
    }
}
