package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

data class PlaceResp(
    @SerializedName("address_components")
    var addressComponents: List<AddressComponentResp>? = null,
    @SerializedName("adr_address")
    var adrAddress: String? = null,
    @SerializedName("business_status")
    var businessStatus: String? = null,
    @SerializedName("curbside_pickup")
    var curbsidePickup: Boolean? = null,
    @SerializedName("current_opening_hours")
    var currentOpeningHours: PlaceOpeningHoursResp? = null,
    @SerializedName("delivery")
    var delivery: Boolean? = null,
    @SerializedName("dine_in")
    var dineIn: Boolean? = null,
    @SerializedName("editorial_summary")
    var editorialSummary: PlaceEditorialSummaryResp? = null,
    @SerializedName("formatted_address")
    var formattedAddress: String? = null,
    @SerializedName("formatted_phone_number")
    var formattedPhoneNumber: String? = null,
    @SerializedName("geometry")
    var geometry: GeometryResp? = null,
    @SerializedName("icon")
    var icon: String? = null,
    @SerializedName("icon_background_color")
    var iconBackgroundColor: String? = null,
    @SerializedName("icon_mask_base_uri")
    var iconMaskBaseUri: String? = null,
    @SerializedName("international_phone_number")
    var internationalPhoneNumber: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("opening_hours")
    var openingHours: PlaceOpeningHoursResp? = null,
    @SerializedName("photos")
    var photos: List<PlacePhotoResp>? = null,
    @SerializedName("place_id")
    var placeId: String? = null,
    @SerializedName("plus_code")
    var plusCode: PlusCodeResp? = null,
    @SerializedName("price_level")
    var priceLv: Int? = null,
    @SerializedName("rating")
    var rating: Double? = null,
    @SerializedName("reservable")
    var reservable: Boolean? = null,
    @SerializedName("reviews")
    var reviews: List<PlaceReviewResp>? = null,
    @SerializedName("secondary_opening_hours")
    var secondaryOpeningHours: PlaceOpeningHoursResp? = null,
    @SerializedName("serves_beer")
    var servesBeer: Boolean? = null,
    @SerializedName("serves_breakfast")
    var servesBreakfast: Boolean? = null,
    @SerializedName("serves_brunch")
    var servesBrunch: Boolean? = null,
    @SerializedName("serves_dinner")
    var servesDinner: Boolean? = null,
    @SerializedName("serves_lunch")
    var servesLunch: Boolean? = null,
    @SerializedName("serves_vegetarian_food")
    var servesVegetarianFood: Boolean? = null,
    @SerializedName("serves_wine")
    var servesWine: Boolean? = null,
    @SerializedName("takeout")
    var takeout: Boolean? = null,
    @SerializedName("types")
    var types: List<String>? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("user_ratings_total")
    var userRatingsTotal: Int? = null,
    @SerializedName("utc_offset")
    var utcOffset: Int? = null,
    @SerializedName("vicinity")
    var vicinity: String? = null,
    @SerializedName("website")
    var website: String? = null,
    @SerializedName("wheelchair_accessible_entrance")
    var wheelchairAccessibleEntrance: Boolean? = null
)
