package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.response.DirectionsResponse
import com.github.hemoptysisheart.parking.core.client.google.response.PlacesNearbySearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlacesApi {
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

        const val PARAM_DESTINATION = "destination"
        const val PARAM_ORIGIN = "origin"
        const val PARAM_ALTERNATIVES = "alternatives"
        const val PARAM_ARRIVAL_TIME = "arrival_time"
        const val PARAM_AVOID = "avoid"
        const val PARAM_DEPARTURE_TIME = "departure_time"
        const val PARAM_MODE = "mode"
        const val PARAM_REGION = "region"
        const val PARAM_TRAFFIC_MODEL = "traffic_model"
        const val PARAM_TRANSIT_ROUTING_PREFERENCE = "transit_routing_preference"
        const val PARAM_UNITS = "units"
        const val PARAM_WAYPOINTS = "waypoints"
    }

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