package com.github.hemoptysisheart.parking.client.google

import com.github.hemoptysisheart.parking.client.google.response.DirectionsResponse
import com.github.hemoptysisheart.parking.client.google.response.PlacesAutocompleteResponse
import com.github.hemoptysisheart.parking.client.google.response.PlacesDetailsResponse
import com.github.hemoptysisheart.parking.client.google.response.PlacesNearbySearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiSpec {
    companion object {
        const val PARAM_ALTERNATIVES = "alternatives"
        const val PARAM_ARRIVAL_TIME = "arrival_time"
        const val PARAM_AVOID = "avoid"
        const val PARAM_COMPONENTS = "components"
        const val PARAM_DEPARTURE_TIME = "departure_time"
        const val PARAM_DESTINATION = "destination"
        const val PARAM_FIELDS = "fields"
        const val PARAM_INPUT = "input"
        const val PARAM_KEY = "key"
        const val PARAM_KEYWORD = "keyword"
        const val PARAM_LANGUAGE = "language"
        const val PARAM_LOCATION = "location"
        const val PARAM_LOCATION_BIAS = "locationbias"
        const val PARAM_LOCATION_RESTRICTION = "locationrestriction"
        const val PARAM_MAX_PRICE = "maxprice"
        const val PARAM_MIN_PRICE = "minprice"
        const val PARAM_MODE = "mode"
        const val PARAM_OFFSET = "offset"
        const val PARAM_OPEN = "opennow"
        const val PARAM_ORIGIN = "origin"
        const val PARAM_PLACE_ID = "place_id"
        const val PARAM_RADIUS = "radius"
        const val PARAM_RANK_BY = "rankby"
        const val PARAM_REGION = "region"
        const val PARAM_REVIEWS_NO_TRANSLATIONS = "reviews_no_translations"
        const val PARAM_REVIEWS_SORT = "reviews_sort"
        const val PARAM_SESSION_TOKEN = "sessiontoken"
        const val PARAM_STRICT_BOUNDS = "strictbounds"
        const val PARAM_TRAFFIC_MODEL = "traffic_model"
        const val PARAM_TRANSIT_ROUTING_PREFERENCE = "transit_routing_preference"
        const val PARAM_TYPE = "type"
        const val PARAM_TYPES = "types"
        const val PARAM_UNITS = "units"
        const val PARAM_WAYPOINTS = "waypoints"
    }

    /**
     * [Place Details](https://developers.google.com/maps/documentation/places/web-service/details)
     *
     * @param placeId A textual identifier that uniquely identifies a place, returned from a
     *              [Place Search](https://developers.google.com/maps/documentation/places/web-service/search). For
     *              more information about place IDs, see the
     *              [place ID overview](https://developers.google.com/maps/documentation/places/web-service/place-id).
     * @param fields Use the fields parameter to specify a comma-separated list of place data types to return. For
     *              example: `fields=formatted_address,name,geometry`. Use a forward slash when specifying compound
     *              values. For example: `opening_hours/open_now`. Fields are divided into three billing categories:
     *              Basic, Contact, and Atmosphere. Basic fields are billed at base rate, and incur no additional
     *              charges. Contact and Atmosphere fields are billed at a higher rate. See the
     *              [pricing sheet](https://developers.google.com/maps/documentation/places/web-service/usage-and-billing)
     *              for more information. Attributions, html_attributions, are always returned with every call,
     *              regardless of whether the field has been requested.
     * @param language The language in which to return results.
     * @param region The region code, specified as a
     *              [ccTLD ("top-level domain")](https://en.wikipedia.org/wiki/List_of_Internet_top-level_domains#Country_code_top-level_domains)
     *              two-character value. Most ccTLD codes are identical to ISO 3166-1 codes, with some notable
     *              exceptions. For example, the United Kingdom's ccTLD is "uk" (.co.uk) while its ISO 3166-1 code is
     *              "gb" (technically for the entity of "The United Kingdom of Great Britain and Northern Ireland").
     * @param reviewsNoTranslations Specify `reviews_no_translations=true` to disable translation of reviews; specify
     *                          `reviews_no_translations=false` to enable translation of reviews. Reviews are returned
     *                          in their original language. If omitted, or passed with no value, translation of reviews
     *                          is enabled. If the `language` parameter was specified in the request, use the specified
     *                          language as the preferred language for translation. If `language` is omitted, the API
     *                          attempts to use the `Accept-Language` header as the preferred language.
     * @param reviewsSort The sorting method to use when returning reviews. Can be set to `most_relevant` (default) or
     *                  `newest`.
     * @param sessionToken A random string which identifies an autocomplete
     *                  [session](https://developers.google.com/maps/documentation/places/web-service/details#session_tokens)
     *                  for billing purposes. The session begins when the user starts typing a query, and concludes
     *                  when they select a place and a call to Place Details is made. Each session can have multiple
     *                  queries, followed by one place selection. The API key(s) used for each request within a session
     *                  must belong to the same Google Cloud Console project. Once a session has concluded, the token
     *                  is no longer valid; your app must generate a fresh token for each session. If the `sessiontoken`
     *                  parameter is omitted, or if you reuse a session token, the session is charged as if no session
     *                  token was provided (each request is billed separately).
     */
    @GET("maps/api/place/details/json")
    suspend fun place(
        @Query(PARAM_KEY) key: String,
        @Query(PARAM_PLACE_ID) placeId: String,
        @Query(PARAM_FIELDS) fields: String? = null,
        @Query(PARAM_LANGUAGE) language: String? = null,
        @Query(PARAM_REGION) region: String? = null,
        @Query(PARAM_REVIEWS_NO_TRANSLATIONS) reviewsNoTranslations: Boolean? = null,
        @Query(PARAM_REVIEWS_SORT) reviewsSort: String? = null,
        @Query(PARAM_SESSION_TOKEN) sessionToken: String? = null
    ): PlacesDetailsResponse

    /**
     * [Place Autocomplete](https://developers.google.com/maps/documentation/places/web-service/autocomplete)
     *
     * Place Autocomplete 서비스는 HTTP 요청에 대한 응답으로 장소 예상 검색어를 반환하는 웹 서비스입니다. 이 요청은 텍스트 검색 문자열과 선택적
     * 지리적 경계를 지정합니다. 이 서비스는 비즈니스 유형의 주소, 관심 장소 등의 장소를 사용자 유형으로 반환하여 텍스트 기반 지역 검색에 자동 완성 기능을
     * 제공하는 데 사용할 수 있습니다.
     *
     * @param key Google Maps API key.
     * @param input The text string on which to search. The Place Autocomplete service will return candidate matches
     *              based on this string and order results based on their perceived relevance.
     * @param radius Defines the distance (in meters) within which to return place results. You may bias results to a
     *              specified circle by passing a location and a radius parameter. Doing so instructs the Places
     *              service to prefer showing results within that circle; results outside of the defined area may still
     *              be displayed.
     * @param components A grouping of places to which you would like to restrict your results. Currently, you can use
     *                  components to filter by up to 5 countries. Countries must be passed as a two character,
     *                  ISO 3166-1 Alpha-2 compatible country code. For example: `components=country:fr` would restrict
     *                  your results to places within France. Multiple countries must be passed as multiple `country:XX`
     *                  filters, with the pipe character | as a separator. For example:
     *                  `components=country:us|country:pr|country:vi|country:gu|country:mp` would restrict your results
     *                  to places within the United States and its unincorporated organized territories.
     * @param language The language in which to return results.
     * @param location The point around which to retrieve place information. This must be specified as
     *              `latitude,longitude`. The `radius` parameter must also be provided when specifying a location. If
     *              `radius` is not provided, the `location` parameter is ignored.
     * @param locationBias Prefer results in a specified area, by specifying either a radius plus lat/lng, or two
     *                  lat/lng pairs representing the points of a rectangle. If this parameter is not specified, the
     *                  API uses IP address biasing by default.
     * @param locationRestriction Restrict results to a specified area, by specifying either a radius plus lat/lng, or
     *                          two lat/lng pairs representing the points of a rectangle.
     * @param offset The position, in the input term, of the last character that the service uses to match predictions.
     *              For example, if the input is Google and the offset is 3, the service will match on Goo. The string
     *              determined by the offset is matched against the first word in the input term only. For example, if
     *              the input term is Google abc and the offset is 3, the service will attempt to match against Goo abc.
     *              If no offset is supplied, the service will use the whole term. The offset should generally be set
     *              to the position of the text caret.
     * @param origin The origin point from which to calculate straight-line distance to the destination (returned as
     *              `distance_meters`). If this value is omitted, straight-line distance will not be returned. Must be
     *              specified as `latitude,longitude`.
     * @param region The region code, specified as a [ccTLD ("top-level domain")](https://en.wikipedia.org/wiki/List_of_Internet_top-level_domains#Country_code_top-level_domains)
     *              two-character value. Most ccTLD codes are identical to ISO 3166-1 codes, with some notable
     *              exceptions. For example, the United Kingdom's ccTLD is "uk" (.co.uk) while its ISO 3166-1 code is
     *              "gb" (technically for the entity of "The United Kingdom of Great Britain and Northern Ireland").
     * @param sessionToken A random string which identifies an autocomplete session for billing purposes.
     *                  The session begins when the user starts typing a query, and concludes when they select a place
     *                  and a call to Place Details is made. Each session can have multiple queries, followed by one
     *                  place selection. The API key(s) used for each request within a session must belong to the same
     *                  Google Cloud Console project. Once a session has concluded, the token is no longer valid; your
     *                  app must generate a fresh token for each session. If the `sessiontoken` parameter is omitted,
     *                  or if you reuse a session token, the session is charged as if no session token was provided
     *                  (each request is billed separately).
     * @param strictBounds Returns only those places that are strictly within the region defined by location and radius.
     *                  This is a restriction, rather than a bias, meaning that results outside this region will not be
     *                  returned even if they match the user input.
     * @param types You can restrict results from a Place Autocomplete request to be of a certain type by passing the
     *              `types` parameter. This parameter specifies a type or a type collection, as listed in
     *              [Place Types](https://developers.google.com/maps/documentation/places/web-service/supported_types).
     *              If nothing is specified, all types are returned.
     */
    @GET("maps/api/place/autocomplete/json")
    suspend fun autocomplete(
        @Query(PARAM_KEY) key: String,
        @Query(PARAM_INPUT) input: String,
        @Query(PARAM_RADIUS) radius: Int,
        @Query(PARAM_COMPONENTS) components: String? = null,
        @Query(PARAM_LANGUAGE) language: String? = null,
        @Query(PARAM_LOCATION) location: String? = null,
        @Query(PARAM_LOCATION_BIAS) locationBias: String? = null,
        @Query(PARAM_LOCATION_RESTRICTION) locationRestriction: String? = null,
        @Query(PARAM_OFFSET) offset: Int? = null,
        @Query(PARAM_ORIGIN) origin: String? = null,
        @Query(PARAM_REGION) region: String? = null,
        @Query(PARAM_SESSION_TOKEN) sessionToken: String? = null,
        @Query(PARAM_STRICT_BOUNDS) strictBounds: Boolean? = null,
        @Query(PARAM_TYPES) types: String? = null
    ): PlacesAutocompleteResponse

    /**
     * - [필수 파라미터](https://developers.google.com/maps/documentation/places/web-service/search-nearby#required-parameters)
     * - [선택 파라미터](https://developers.google.com/maps/documentation/places/web-service/search-nearby#optional-parameters)
     *
     * @param keyword The text string on which to search, for example: "restaurant" or "123 Main Street". This must be
     *          a place name, address, or category of establishments. Any other types of input can generate errors and
     *          are not guaranteed to return valid results. The Google Places service will return candidate matches
     *          based on this string and order the results based on their perceived relevance.
     *          Explicitly including location information using this parameter may conflict with the location, radius,
     *          and rankby parameters, causing unexpected results.
     *          If this parameter is omitted, places with a business_status of CLOSED_TEMPORARILY or CLOSED_PERMANENTLY
     *          will not be returned.
     * @param location The point around which to retrieve place information. This must be specified as
     *          `latitude,longitude`.
     * @param language
     * @param minPrice Restricts results to only those places within the specified range. Valid values range between 0
     *          (most affordable) to 4 (most expensive), inclusive. The exact amount indicated by a specific value will
     *          vary from region to region.
     * @param maxPrice Restricts results to only those places within the specified range. Valid values range between 0
     *          (most affordable) to 4 (most expensive), inclusive. The exact amount indicated by a specific value will
     *          vary from region to region.
     * @param open Returns only those places that are open for business at the time the query is sent. Places that do
     *          not specify opening hours in the Google Places database will not be returned if you include this
     *          parameter in your query.
     * @param radius Defines the distance (in meters) within which to return place results. You may bias results to a
     *          specified circle by passing a `location` and a `radius` parameter. Doing so instructs the Places
     *          service to prefer showing results within that circle; results outside of the defined area may still
     *          be displayed.
     * @param rankBy Specifies the order in which results are listed.
     *          Possible values are: prominence (default), distance
     * @param type Restricts the results to places matching the specified type. Only one type may be specified. If more
     *          than one type is provided, all types following the first entry are ignored.
     * @param key API key.
     */
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

    /**
     * - [필수 파라미터](https://developers.google.com/maps/documentation/directions/get-directions#required-parameters)
     * - [선택 파라미터](https://developers.google.com/maps/documentation/directions/get-directions#optional-parameters)
     *
     * @param key API key.
     * @param origin The place ID, address, or textual latitude/longitude value from which you wish to
     *          calculate directions.
     * @param destination The place ID, address, or textual latitude/longitude value to which you wish to calculate
     *          directions. The options for the destination parameter are the same as for the origin parameter.
     * @param alternatives If set to true, specifies that the Directions service may provide more than one route
     *          alternative in the response. Note that providing route alternatives may increase the response time
     *          from the server. This is only available for requests without intermediate waypoints.
     *          For more information, see the guide to waypoints.
     * @param arrivalTime Specifies the desired time of arrival for transit directions, in seconds since midnight,
     *          January 1, 1970 UTC. You can specify either departure_time or arrival_time, but not both.
     *          Note that arrival_time must be specified as an integer.
     * @param avoid Indicates that the calculated route(s) should avoid the indicated features.
     * @param departureTime Specifies the desired time of departure. You can specify the time as an integer in seconds
     *          since midnight, January 1, 1970 UTC. If a departure_time later than 9999-12-31T23:59:59.999999999Z is
     *          specified, the API will fall back the departure_time to 9999-12-31T23:59:59.999999999Z. Alternatively,
     *          you can specify a value of now, which sets the departure time to the current time
     *          (correct to the nearest second).
     * @param language
     * @param mode For the calculation of distances and directions, you may specify the transportation mode to use.
     *          By default, DRIVING mode is used. By default, directions are calculated as driving directions.
     *          The following travel modes are supported: `driving` (default), `walking`, `bicycling`, `transit`.
     *          See `TransportationMode.code`.
     * @param region The region code, specified as a ccTLD ("top-level domain") two-character value. Most ccTLD codes
     *          are identical to ISO 3166-1 codes, with some notable exceptions. For example, the United Kingdom's
     *          ccTLD is "uk" (.co.uk) while its ISO 3166-1 code is "gb" (technically for the entity of "The United
     *          Kingdom of Great Britain and Northern Ireland").
     * @param trafficModel Specifies the assumptions to use when calculating time in traffic. This setting affects
     *          the value returned in the duration_in_traffic field in the response, which contains the predicted time
     *          in traffic based on historical averages. The traffic_model parameter may only be specified for driving
     *          directions where the request includes a departure_time.
     *          The available values for this parameter are: `best_guess` (default), `pessimistic`, `optimistic`.
     *          See `TrafficModel.code`.
     * @param transitRoutingPreference Specifies preferences for transit routes. Using this parameter, you can bias
     *          the options returned, rather than accepting the default best route chosen by the API. This parameter
     *          may only be specified for transit directions.
     *          The parameter supports the following arguments: `less_walking`, `fewer_transfers`
     *          See `TransitRoutingPreference.code`
     * @param units Specifies the unit system to use when displaying results. Directions results contain text within
     *          distance fields that may be displayed to the user to indicate the distance of a particular "step" of
     *          the route. By default, this text uses the unit system of the origin's country or region. For example,
     *          a route from "Chicago, IL" to "Toronto, ONT" will display results in miles, while the reverse route
     *          will display results in kilometers. You may override this unit system by setting one explicitly within
     *          the request's units parameter, passing one of the following values: `metric`, `imperial`
     *          See `DistanceUnit.code`
     * @param waypoints Specifies an array of intermediate locations to include along the route between the origin and
     *          destination points as pass through or stopover locations. Waypoints alter a route by directing it
     *          through the specified location(s). The API supports waypoints for these travel modes: driving, walking
     *          and bicycling; not transit. You can supply one or more locations separated by the pipe
     *          character (| or %7C), in the form of a place ID, an address, or latitude/longitude coordinates.
     *          By default, the Directions service calculates a route using the waypoints in the order they are given.
     *          The precedence for parsing the value of the waypoint is place ID, latitude/longitude coordinates,
     *          then address.
     */
    @GET("/maps/api/directions/json")
    suspend fun direction(
        @Query(PARAM_KEY) key: String,
        @Query(PARAM_ORIGIN) origin: String,
        @Query(PARAM_DESTINATION) destination: String,
        @Query(PARAM_ALTERNATIVES) alternatives: Boolean? = null,
        @Query(PARAM_ARRIVAL_TIME) arrivalTime: Long? = null,
        @Query(PARAM_AVOID) avoid: String? = null,
        @Query(PARAM_DEPARTURE_TIME) departureTime: Long? = null,
        @Query(PARAM_LANGUAGE) language: String? = null,
        @Query(PARAM_MODE) mode: String? = null,
        @Query(PARAM_REGION) region: String? = null,
        @Query(PARAM_TRAFFIC_MODEL) trafficModel: String? = null,
        @Query(PARAM_TRANSIT_ROUTING_PREFERENCE) transitRoutingPreference: String? = null,
        @Query(PARAM_UNITS) units: String? = null,
        @Query(PARAM_WAYPOINTS) waypoints: String? = null
    ): DirectionsResponse
}