package com.github.hemoptysisheart.parking.core.model.data

import com.github.hemoptysisheart.parking.domain.GeoLocation

data class DestinationSearchResult(
    val center: GeoLocation,
    val query: String,
    val predictionList: List<RecommendItemPlaceAutocompletePrediction>
)
