package com.github.hemoptysisheart.parking.core.client.google.dto

import java.net.URL
import java.time.Duration

data class PlaceDto(
    val addressComponents: List<AddressComponentDto>? = null,
    val adrAddress: String? = null,
    val businessStatus: BusinessStatus? = null,
    val curbsidePickup: Boolean? = null,
    val currentOpeningHours: PlaceOpeningHoursDto? = null,
    val delivery: Boolean? = null,
    val dineIn: Boolean? = null,
    val editorialSummary: PlaceEditorialSummaryDto? = null,
    val formattedAddress: String? = null,
    val formattedPhoneNumber: String? = null,
    val geometry: GeometryDto? = null,
    val icon: URL? = null,
    val iconBackgroundColor: String? = null,
    val iconMaskBase: URL? = null,
    val internationalPhoneNumber: String? = null,
    val name: String? = null,
    val openingHours: PlaceOpeningHoursDto? = null,
    val photos: List<PlacePhotoDto>? = null,
    val placeId: String? = null,
    val plusCode: PlusCodeDto? = null,
    val priceLv: PriceLevel? = null,
    val rating: Double? = null,
    val reservable: Boolean? = null,
    val reviews: List<PlaceReviewDto>? = null,
    val secondaryOpeningHours: PlaceOpeningHoursDto? = null,
    val beer: Boolean? = null,
    val breakfast: Boolean? = null,
    val brunch: Boolean? = null,
    val dinner: Boolean? = null,
    val lunch: Boolean? = null,
    val vegetarianFood: Boolean? = null,
    val wine: Boolean? = null,
    val takeout: Boolean? = null,
    val types: Set<PlaceType>? = null,
    val url: URL? = null,
    val userRatingsTotal: Int? = null,
    val utcOffset: Duration? = null,
    val vicinity: String? = null,
    val website: URL? = null,
    val wheelchairAccessibleEntrance: Boolean? = null
)
