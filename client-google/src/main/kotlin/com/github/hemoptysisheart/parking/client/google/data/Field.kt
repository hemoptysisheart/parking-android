package com.github.hemoptysisheart.parking.client.google.data

import com.github.hemoptysisheart.parking.client.google.data.FieldCategory.*

enum class Field(
    val category: FieldCategory,
    val code: String
) {
    ADDRESS_COMPONENTS(BASIC, "address_components"),
    ADR_ADDRESS(BASIC, "adr_address"),
    BUSINESS_STATUS(BASIC, "business_status"),
    FORMATTED_ADDRESS(BASIC, "formatted_address"),
    GEOMETRY(BASIC, "geometry"),
    ICON(BASIC, "icon"),
    ICON_MASK_BASE_URI(BASIC, "icon_mask_base_uri"),
    ICON_BACKGROUND_COLOR(BASIC, "icon_background_color"),
    NAME(BASIC, "name"),
    PHOTO(BASIC, "photo"),
    PLACE_ID(BASIC, "place_id"),
    PLUS_CODE(BASIC, "plus_code"),
    TYPE(BASIC, "type"),
    URL(BASIC, "url"),
    UTC_OFFSET(BASIC, "utc_offset"),
    VICINITY(BASIC, "vicinity"),
    WHEELCHAIR_ACCESSIBLE_ENTRANCE(BASIC, "wheelchair_accessible_entrance"),

    CURRENT_OPENING_HOURS(CONTACT, "current_opening_hours"),
    FORMATTED_PHONE_NUMBER(CONTACT, "formatted_phone_number"),
    INTERNATIONAL_PHONE_NUMBER(CONTACT, "international_phone_number"),
    OPENING_HOURS(CONTACT, "opening_hours"),
    SECONDARY_OPENING_HOURS(CONTACT, "secondary_opening_hours"),
    WEBSITE(CONTACT, "website"),

    CURBSIDE_PICKUP(ATMOSPHERE, "curbside_pickup"),
    DELIVERY(ATMOSPHERE, "delivery"),
    DINE_IN(ATMOSPHERE, "dine_in"),
    EDITORIAL_SUMMARY(ATMOSPHERE, "editorial_summary"),
    PRICE_LEVEL(ATMOSPHERE, "price_level"),
    RATING(ATMOSPHERE, "rating"),
    RESERVABLE(ATMOSPHERE, "reservable"),
    REVIEWS(ATMOSPHERE, "reviews"),
    SERVES_BEER(ATMOSPHERE, "serves_beer"),
    SERVES_BREAKFAST(ATMOSPHERE, "serves_breakfast"),
    SERVES_BRUNCH(ATMOSPHERE, "serves_brunch"),
    SERVES_DINNER(ATMOSPHERE, "serves_dinner"),
    SERVES_LUNCH(ATMOSPHERE, "serves_lunch"),
    SERVES_VEGETARIAN_FOOD(ATMOSPHERE, "serves_vegetarian_food"),
    SERVES_WINE(ATMOSPHERE, "serves_wine"),
    TAKEOUT(ATMOSPHERE, "takeout"),
    USER_RATINGS_TOTAL(ATMOSPHERE, "user_ratings_total");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        val CATEGORY_GROUP = values().groupBy { it.category }

        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(code: String) = CODE_MAP[code]!!
    }
}
