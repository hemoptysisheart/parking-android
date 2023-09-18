package com.github.hemoptysisheart.parking.client.google.data

import com.github.hemoptysisheart.parking.client.google.data.FieldCategory.ATMOSPHERE
import com.github.hemoptysisheart.parking.client.google.data.FieldCategory.BASIC
import com.github.hemoptysisheart.parking.client.google.data.FieldCategory.CONTACT

enum class Field(
        val category: FieldCategory,
        val code: String,
        val android: Boolean,
        val ios: Boolean,
        val web: Boolean
) {
    ADDRESS_COMPONENTS(BASIC, "address_components", false, false, true),
    ADR_ADDRESS(BASIC, "adr_address", false, false, true),
    BUSINESS_STATUS(BASIC, "business_status", true, true, true),
    FORMATTED_ADDRESS(BASIC, "formatted_address", true, true, true),

    /**
     * Android는 `lat_lng`을 대신함.
     */
    GEOMETRY(BASIC, "geometry", true, false, true),

    /**
     * icon url.
     */
    ICON(BASIC, "icon", true, false, true),
    ICON_MASK_BASE_URI(BASIC, "icon_mask_base_uri", false, false, false),
    ICON_BACKGROUND_COLOR(BASIC, "icon_background_color", true, false, false),
    NAME(BASIC, "name", true, true, true),

    /**
     * Android는 `PHOTO_METADATAS`을 대신함.
     */
    PHOTO(BASIC, "photo", true, true, true),
    PLACE_ID(BASIC, "place_id", true, true, true),
    PLUS_CODE(BASIC, "plus_code", true, true, true),

    /**
     * Android는 `TYPES`를 대신함.
     */
    TYPE(BASIC, "type", true, true, true),
    URL(BASIC, "url", false, false, true),
    UTC_OFFSET(BASIC, "utc_offset", false, false, true),

    /**
     * Android는 `GEOMETRY` 속성으로 대신함.
     */
    VIEWPORT(BASIC, "viewport", false, true, false),
    VICINITY(BASIC, "vicinity", false, false, true),
    WHEELCHAIR_ACCESSIBLE_ENTRANCE(BASIC, "wheelchair_accessible_entrance", false, false, true),

    CURRENT_OPENING_HOURS(CONTACT, "current_opening_hours", true, false, true),
    FORMATTED_PHONE_NUMBER(CONTACT, "formatted_phone_number", false, false, true),
    INTERNATIONAL_PHONE_NUMBER(CONTACT, "international_phone_number", false, false, true),
    OPENING_HOURS(CONTACT, "opening_hours", true, true, true),
    SECONDARY_OPENING_HOURS(CONTACT, "secondary_opening_hours", true, false, true),
    WEBSITE(CONTACT, "website", true, true, true),

    CURBSIDE_PICKUP(ATMOSPHERE, "curbside_pickup", true, true, true),
    DELIVERY(ATMOSPHERE, "delivery", true, true, true),
    DINE_IN(ATMOSPHERE, "dine_in", true, true, true),
    EDITORIAL_SUMMARY(ATMOSPHERE, "editorial_summary", true, false, true),
    PRICE_LEVEL(ATMOSPHERE, "price_level", true, false, true),
    RATING(ATMOSPHERE, "rating", true, true, true),
    RESERVABLE(ATMOSPHERE, "reservable", true, true, true),
    REVIEWS(ATMOSPHERE, "reviews", false, false, true),
    SERVES_BEER(ATMOSPHERE, "serves_beer", true, true, true),
    SERVES_BREAKFAST(ATMOSPHERE, "serves_breakfast", true, true, true),
    SERVES_BRUNCH(ATMOSPHERE, "serves_brunch", true, true, true),
    SERVES_DINNER(ATMOSPHERE, "serves_dinner", true, true, true),
    SERVES_LUNCH(ATMOSPHERE, "serves_lunch", true, true, true),
    SERVES_VEGETARIAN_FOOD(ATMOSPHERE, "serves_vegetarian_food", true, true, true),
    SERVES_WINE(ATMOSPHERE, "serves_wine", true, true, true),
    TAKEOUT(ATMOSPHERE, "takeout", true, true, true),
    USER_RATINGS_TOTAL(ATMOSPHERE, "user_ratings_total", true, true, true);

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(category: FieldCategory) = values().filter { it.category == category }

        operator fun get(platform: Platform) = values().filter {
            when (platform) {
                Platform.ANDROID -> it.android
                Platform.IOS -> it.ios
                Platform.WEB -> it.web
            }
        }

        operator fun get(platform: Platform, category: FieldCategory) = values().filter {
            it.category == category && when (platform) {
                Platform.ANDROID -> it.android
                Platform.IOS -> it.ios
                Platform.WEB -> it.web
            }
        }
    }
}
