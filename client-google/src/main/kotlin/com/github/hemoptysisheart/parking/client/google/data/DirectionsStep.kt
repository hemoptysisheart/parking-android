package com.github.hemoptysisheart.parking.client.google.data

/**
 * [DirectionsStep](https://developers.google.com/maps/documentation/directions/get-directions?hl=ko#DirectionsStep)
 *
 * Each element in the steps array defines a single step of the calculated directions. A step is the most atomic unit
 * of a direction's route, containing a single step describing a specific, single instruction on the journey.
 * E.g. "Turn left at W. 4th St." The step not only describes the instruction but also contains distance and duration
 * information relating to how this step relates to the following step. For example, a step denoted as "Merge onto I-80
 * West" may contain a duration of "37 miles" and "40 minutes," indicating that the next step is 37 miles/40 minutes
 * from this step.
 *
 * When using the Directions API to search for transit directions, the steps array will include additional transit
 * details in the form of a transit_details array. If the directions include multiple modes of transportation, detailed
 * directions will be provided for walking or driving steps in an inner steps array. For example, a walking step will
 * include directions from the start and end locations: "Walk to Innes Ave & Fitch St". That step will include detailed
 * walking directions for that route in the inner steps array, such as: "Head north-west", "Turn left onto Arelious
 * Walker", and "Turn left onto Innes Ave".
 */
data class DirectionsStep(
    /**
     * Contains the typical time required to perform the step, until the next step. This field may be undefined if the
     * duration is unknown.
     *
     * See [TextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TextValueObject)
     * for more information.
     */
    val duration: LabeledNumber,
    /**
     * Contains the location of the last point of this step.
     *
     * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
     * for more information.
     */
    val endLocation: LatLng,
    /**
     * Contains formatted instructions for this step, presented as an HTML text string. This content is meant to be
     * read as-is. Do not programmatically parse this display-only content.
     */
    val html: String,
    /**
     * Contains a single points object that holds an encoded polyline representation of the step. This polyline is an
     * approximate (smoothed) path of the step.
     *
     * See [DirectionsPolyline](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsPolyline)
     * for more information.
     */
    val polyline: DirectionsPolyline,
    /**
     * Contains the location of the starting point of this step.
     *
     * See [LatLngLiteral](https://developers.google.com/maps/documentation/directions/get-directions#LatLngLiteral)
     * for more information.
     */
    val startLocation: LatLng,
    /**
     * Contains the type of travel mode used.
     *
     * See [TravelMode](https://developers.google.com/maps/documentation/directions/get-directions#TravelMode)
     * for more information.
     */
    val travelMode: TravelMode,
    /**
     * Contains the distance covered by this step until the next step. This field may be undefined if the distance is
     * unknown.
     *
     * See [TextValueObject](https://developers.google.com/maps/documentation/directions/get-directions#TextValueObject)
     * for more information.
     */
    val distance: LabeledNumber?,
    /**
     * Contains the action to take for the current step (turn left, merge, straight, etc.). Values are subject to
     * change, and new values may be introduced without prior notice.
     */
    val maneuver: Maneuver?,
    /**
     * Contains detailed directions for walking or driving steps in transit directions. Substeps are only available
     * when `travel_mode` is set to "transit". The inner steps array is of the same type as steps.
     */
    val steps: String?,
    /**
     * Details pertaining to this step if the travel mode is `TRANSIT`.
     *
     * See [DirectionsTransitDetails](https://developers.google.com/maps/documentation/directions/get-directions#DirectionsTransitDetails)
     * for more information.
     */
    val transitDetails: DirectionsTransitDetails?
)
