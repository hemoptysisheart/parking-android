package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.response.PlacesNearbySearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesApi {
    companion object {
        const val PARAM_KEY = "key"
        const val PARAM_LOCATION = "location"
        const val PARAM_KEYWORD = "keyword"
        const val PARAM_LANGUAGE = "language"
        const val PARAM_MIN_PRICE = "minprice"
        const val PARAM_MAX_PRICE = "maxprice"
        const val PARAM_OPEN = "opennow"
        const val PARAM_RADIUS = "radius"
        const val PARAM_RANK_BY = "rankby"
        const val PARAM_TYPE = "type"
    }

    @GET("/maps/api/place/nearbysearch/json")
    suspend fun nearBy(
        @Query(PARAM_KEYWORD) keyword: String? = null,
        @Query(PARAM_LOCATION) location: String,
        @Query(PARAM_LANGUAGE) language: String? = null,
        @Query(PARAM_MIN_PRICE) minPrice: Int? = null,
        @Query(PARAM_MAX_PRICE) maxPrice: Int? = null,
        @Query(PARAM_OPEN) open: Boolean? = null,
        @Query(PARAM_RADIUS) radius: Int? = null,
        @Query(PARAM_RANK_BY) rankBy: String? = null,
        @Query(PARAM_TYPE) type: String? = null,
        @Query(PARAM_KEY) key: String
    ): PlacesNearbySearchResponse
}