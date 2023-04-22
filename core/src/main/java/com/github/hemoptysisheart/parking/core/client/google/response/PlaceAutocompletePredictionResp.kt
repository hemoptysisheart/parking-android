package com.github.hemoptysisheart.parking.core.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlaceAutocompletePrediction](https://developers.google.com/maps/documentation/places/web-service/autocomplete#PlaceAutocompletePrediction)
 */
data class PlaceAutocompletePredictionResp(
    /**
     * Contains the human-readable name for the returned result. For establishment results, this is usually the business
     * name. This content is meant to be read as-is. Do not programmatically parse the formatted address.
     */
    @SerializedName("description")
    var description: String? = null,
    /**
     * A list of substrings that describe the location of the entered term in the prediction result text, so that the
     * term can be highlighted if desired.
     */
    @SerializedName("matched_substrings")
    var matchedSubstrings: List<PlaceAutocompleteMatchedSubstringResp>? = null,
    /**
     * Provides pre-formatted text that can be shown in your autocomplete results. This content is meant to be read
     * as-is. Do not programmatically parse the formatted address.
     */
    @SerializedName("structured_formatting")
    var structuredFormatting: PlaceAutocompleteStructuredFormatResp? = null,
    /**
     * Contains an array of terms identifying each section of the returned description (a section of the description is
     * generally terminated with a comma). Each entry in the array has a value field, containing the text of the term,
     * and an offset field, defining the start position of this term in the description, measured in Unicode characters.
     */
    @SerializedName("terms")
    var terms: List<PlaceAutocompleteTermResp>? = null,
    /**
     * The straight-line distance in meters from the origin. This field is only returned for requests made with an
     * `origin`.
     */
    @SerializedName("distance_meters")
    var distanceMeters: Int? = null,
    /**
     * A textual identifier that uniquely identifies a place. To retrieve information about the place, pass this
     * identifier in the placeId field of a Places API request. For more information about place IDs, see the
     * [Place IDs](https://developers.google.com/maps/documentation/places/web-service/place-id) overview.
     */
    @SerializedName("place_id")
    var placeId: String? = null,
    /**
     * Contains an array of types that apply to this place. For example: `[ "political", "locality" ]` or
     * `[ "establishment", "geocode", "beauty_salon" ]`. The array can contain multiple values. Learn more about Place
     * types.
     */
    @SerializedName("types")
    var types: List<String>? = null
)
