package com.github.hemoptysisheart.parking.core.client.google.data

import java.net.URL
import java.time.Duration

data class Place(
    /**
     * An array containing the separate components applicable to this address.
     */
    val addressComponents: List<AddressComponent>? = null,
    /**
     * A representation of the place's address in the [adr microformat](http://microformats.org/wiki/adr).
     */
    val adrAddress: String? = null,
    /**
     * Indicates the operational status of the place, if it is a business. If no data exists, business_status is not
     * returned.
     *
     * The allowed values include: `OPERATIONAL`, `CLOSED_TEMPORARILY`, and `CLOSED_PERMANENTLY`
     */
    val businessStatus: BusinessStatus? = null,
    /**
     * Specifies if the business supports curbside pickup.
     */
    val curbsidePickup: Boolean? = null,
    /**
     * Contains the hours of operation for the next seven days (including today). The time period starts at midnight on
     * the date of the request and ends at 11:59 pm six days later. This field includes the special_days subfield of
     * all hours, set for dates that have exceptional hours.
     */
    val currentOpeningHours: PlaceOpeningHours? = null,
    /**
     * Specifies if the business supports delivery.
     */
    val delivery: Boolean? = null,
    /**
     * Specifies if the business supports indoor or outdoor seating options.
     */
    val dineIn: Boolean? = null,
    /**
     * Contains a summary of the place. A summary is comprised of a textual overview, and also includes the language
     * code for these if applicable. Summary text must be presented as-is and can not be modified or altered.
     */
    val editorialSummary: PlaceEditorialSummary? = null,
    /**
     * A string containing the human-readable address of this place.
     *
     * Often this address is equivalent to the postal address. Note that some countries, such as the United Kingdom, do
     * not allow distribution of true postal addresses due to licensing restrictions.
     *
     * The formatted address is logically composed of one or more address components. For example, the address "111 8th
     * \Avenue, New York, NY" consists of the following components: "111" (the street number), "8th Avenue" (the route),
     * "New York" (the city) and "NY" (the US state).
     *
     * Do not parse the formatted address programmatically. Instead you should use the individual address components,
     * which the API response includes in addition to the formatted address field.
     */
    val formattedAddress: String? = null,
    /**
     * Contains the place's phone number in its [local format](http://en.wikipedia.org/wiki/Local_conventions_for_writing_telephone_numbers).
     */
    val formattedPhoneNumber: String? = null,
    /**
     * Contains the location and viewport for the location.
     */
    val geometry: Geometry? = null,
    /**
     * Contains the URL of a suggested icon which may be displayed to the user when indicating this result on a map.
     */
    val icon: URL? = null,
    /**
     * Contains the default HEX color code for the place's category.
     */
    val iconBackgroundColor: String? = null,
    /**
     * Contains the URL of a recommended icon, minus the .svg or .png file type extension.
     */
    val iconMaskBase: URL? = null,
    /**
     * Contains the place's phone number in international format. International format includes the country code, and
     * is prefixed with the plus, +, sign. For example, the international_phone_number for Google's Sydney, Australia
     * office is `+61 2 9374 4000`.
     */
    val internationalPhoneNumber: String? = null,
    /**
     * Contains the human-readable name for the returned result. For `establishment` results, this is usually the
     * canonicalized business name.
     */
    val name: String? = null,
    /**
     * Contains the regular hours of operation.
     */
    val openingHours: PlaceOpeningHours? = null,
    /**
     * An array of photo objects, each containing a reference to an image. A request may return up to ten photos. More
     * information about place photos and how you can use the images in your application can be found in the
     * [Place Photos](https://developers.google.com/maps/documentation/places/web-service/photos) documentation.
     */
    val photos: List<PlacePhoto>? = null,
    /**
     * A textual identifier that uniquely identifies a place. To retrieve information about the place, pass this
     * identifier in the place_id field of a Places API request. For more information about place IDs, see the
     * [place ID overview](https://developers.google.com/maps/documentation/places/web-service/place-id).
     */
    val placeId: String? = null,
    /**
     * An encoded location reference, derived from latitude and longitude coordinates, that represents an area:
     * 1/8000th of a degree by 1/8000th of a degree (about 14m x 14m at the equator) or smaller. Plus codes can be used
     * as a replacement for street addresses in places where they do not exist (where buildings are not numbered or
     * streets are not named). See [Open Location Code](https://en.wikipedia.org/wiki/Open_Location_Code) and
     * [plus codes](https://plus.codes).
     */
    val plusCode: PlusCode? = null,
    /**
     * The price level of the place, on a scale of 0 to 4. The exact amount indicated by a specific value will vary
     * from region to region. Price levels are interpreted as follows:
     * - `0` : Free
     * - `1` : Inexpensive
     * - `2` : Moderate
     * - `3` : Expensive
     * - `4` : Very Expensive
     */
    val priceLv: PriceLevel? = null,
    /**
     * Contains the place's rating, from 1.0 to 5.0, based on aggregated user reviews.
     */
    val rating: Double? = null,
    /**
     * Specifies if the place supports reservations.
     */
    val reservable: Boolean? = null,
    /**
     * A JSON array of up to five reviews. By default, the reviews are sorted in order of relevance. Use the
     * `reviews_sort` request parameter to control sorting.
     *
     * - For `most_relevant` (default), reviews are sorted by relevance; the service will bias the results to return
     * reviews originally written in the preferred language.
     * - For `newest`, reviews are sorted in chronological order; the preferred language does not affect the sort order.
     *
     * Google recommends indicating to users whether results are ordered by most_relevant or newest.
     */
    val reviews: List<PlaceReview>? = null,
    /**
     * Contains an array of entries for the next seven days including information about secondary hours of a business.
     * Secondary hours are different from a business's main hours. For example, a restaurant can specify drive through
     * hours or delivery hours as its secondary hours. This field populates the `type` subfield, which draws from a
     * predefined list of opening hours types (such as `DRIVE_THROUGH`, `PICKUP`, or `TAKEOUT`) based on the types of
     * the place. This field includes the special_days subfield of all hours, set for dates that have exceptional hours.
     */
    val secondaryOpeningHours: PlaceOpeningHours? = null,
    /**
     * Specifies if the place serves beer.
     */
    val beer: Boolean? = null,
    /**
     * Specifies if the place serves breakfast.
     */
    val breakfast: Boolean? = null,
    /**
     * Specifies if the place serves brunch.
     */
    val brunch: Boolean? = null,
    /**
     * Specifies if the place serves dinner.
     */
    val dinner: Boolean? = null,
    /**
     * Specifies if the place serves lunch.
     */
    val lunch: Boolean? = null,
    /**
     * Specifies if the place serves vegetarian food.
     */
    val vegetarianFood: Boolean? = null,
    /**
     * Specifies if the place serves wine.
     */
    val wine: Boolean? = null,
    /**
     * Specifies if the business supports takeout.
     */
    val takeout: Boolean? = null,
    /**
     * Contains an array of feature types describing the given result. See the list of
     * [supported types](https://developers.google.com/maps/documentation/places/web-service/supported_types#table2).
     */
    val types: Set<PlaceType>? = null,
    /**
     * Contains the URL of the official Google page for this place. This will be the Google-owned page that contains
     * the best available information about the place. Applications must link to or embed this page on any screen that
     * shows detailed results about the place to the user.
     */
    val url: URL? = null,
    /**
     * The total number of reviews, with or without text, for this place.
     */
    val userRatingsTotal: Int? = null,
    /**
     * Contains the number of minutes this place’s current timezone is offset from UTC. For example, for places in
     * Sydney, Australia during daylight saving time this would be 660 (+11 hours from UTC), and for places in
     * California outside of daylight saving time this would be -480 (-8 hours from UTC).
     */
    val utcOffset: Duration? = null,
    /**
     * For establishment (`types:["establishment", ...]`) results only, the vicinity field contains a simplified
     * address for the place, including the street name, street number, and locality, but not the province/state,
     * postal code, or country.
     *
     * For all other results, the vicinity field contains the name of the narrowest political
     * (`types:["political", ...]`) feature that is present in the address of the result.
     *
     * This content is meant to be read as-is. Do not programmatically parse the formatted address.
     */
    val vicinity: String? = null,
    /**
     * The authoritative website for this place, such as a business' homepage.
     */
    val website: URL? = null,
    /**
     * Specifies if the place has an entrance that is wheelchair-accessible.
     */
    val wheelchairAccessibleEntrance: Boolean? = null
)
