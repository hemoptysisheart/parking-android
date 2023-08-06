package com.github.hemoptysisheart.parking.client.google

import com.github.hemoptysisheart.parking.client.google.data.AddressComponent
import com.github.hemoptysisheart.parking.client.google.data.Bounds
import com.github.hemoptysisheart.parking.client.google.data.BusinessStatus
import com.github.hemoptysisheart.parking.client.google.data.DirectionsGeocodedWaypoint
import com.github.hemoptysisheart.parking.client.google.data.DirectionsLeg
import com.github.hemoptysisheart.parking.client.google.data.DirectionsPolyline
import com.github.hemoptysisheart.parking.client.google.data.DirectionsRoute
import com.github.hemoptysisheart.parking.client.google.data.DirectionsStep
import com.github.hemoptysisheart.parking.client.google.data.DirectionsTransitAgency
import com.github.hemoptysisheart.parking.client.google.data.DirectionsTransitDetails
import com.github.hemoptysisheart.parking.client.google.data.DirectionsTransitLine
import com.github.hemoptysisheart.parking.client.google.data.DirectionsTransitStop
import com.github.hemoptysisheart.parking.client.google.data.DirectionsTransitVehicle
import com.github.hemoptysisheart.parking.client.google.data.DirectionsViaWaypoint
import com.github.hemoptysisheart.parking.client.google.data.Fare
import com.github.hemoptysisheart.parking.client.google.data.GeocoderStatus
import com.github.hemoptysisheart.parking.client.google.data.Geometry
import com.github.hemoptysisheart.parking.client.google.data.LabeledNumber
import com.github.hemoptysisheart.parking.client.google.data.LatLng
import com.github.hemoptysisheart.parking.client.google.data.Maneuver
import com.github.hemoptysisheart.parking.client.google.data.Place
import com.github.hemoptysisheart.parking.client.google.data.PlaceAutocompleteMatchedSubstring
import com.github.hemoptysisheart.parking.client.google.data.PlaceAutocompletePrediction
import com.github.hemoptysisheart.parking.client.google.data.PlaceAutocompleteStructuredFormat
import com.github.hemoptysisheart.parking.client.google.data.PlaceAutocompleteTerm
import com.github.hemoptysisheart.parking.client.google.data.PlaceEditorialSummary
import com.github.hemoptysisheart.parking.client.google.data.PlaceOpeningHours
import com.github.hemoptysisheart.parking.client.google.data.PlaceOpeningHoursPeriod
import com.github.hemoptysisheart.parking.client.google.data.PlaceOpeningHoursPeriodDetail
import com.github.hemoptysisheart.parking.client.google.data.PlaceOpeningHoursPeriodDetail.Companion.DATE_FORMATTER
import com.github.hemoptysisheart.parking.client.google.data.PlaceOpeningHoursPeriodDetail.Companion.TIME_FORMATTER
import com.github.hemoptysisheart.parking.client.google.data.PlaceOpeningHoursType
import com.github.hemoptysisheart.parking.client.google.data.PlacePhoto
import com.github.hemoptysisheart.parking.client.google.data.PlaceReview
import com.github.hemoptysisheart.parking.client.google.data.PlaceSpecialDay
import com.github.hemoptysisheart.parking.client.google.data.PlaceType
import com.github.hemoptysisheart.parking.client.google.data.PlusCode
import com.github.hemoptysisheart.parking.client.google.data.PriceLevel
import com.github.hemoptysisheart.parking.client.google.data.TravelMode
import com.github.hemoptysisheart.parking.client.google.data.VehicleType
import com.github.hemoptysisheart.parking.client.google.response.AddressComponentResp
import com.github.hemoptysisheart.parking.client.google.response.BoundsResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsGeocodedWaypointResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsLegResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsPolylineResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsRouteResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsStepResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsTransitAgencyResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsTransitDetailsResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsTransitLineResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsTransitStopResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsTransitVehicleResp
import com.github.hemoptysisheart.parking.client.google.response.DirectionsViaWaypointResp
import com.github.hemoptysisheart.parking.client.google.response.FareResp
import com.github.hemoptysisheart.parking.client.google.response.GeometryResp
import com.github.hemoptysisheart.parking.client.google.response.LatLngLiteralResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceAutocompleteMatchedSubstringResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceAutocompletePredictionResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceAutocompleteStructuredFormatResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceAutocompleteTermResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceEditorialSummaryResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceOpeningHoursPeriodDetailResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceOpeningHoursPeriodResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceOpeningHoursResp
import com.github.hemoptysisheart.parking.client.google.response.PlacePhotoResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceReviewResp
import com.github.hemoptysisheart.parking.client.google.response.PlaceSpecialDayResp
import com.github.hemoptysisheart.parking.client.google.response.PlusCodeResp
import com.github.hemoptysisheart.parking.client.google.response.TextValueObjectResp
import com.github.hemoptysisheart.parking.client.google.response.TimeZoneTextValueObjectResp
import java.net.URL
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Currency
import java.util.Locale
import kotlin.math.roundToLong

internal fun PlaceAutocompletePredictionResp.toData() = PlaceAutocompletePrediction(
        description = description ?: throw IllegalArgumentException("description is null."),
        matchedSubstrings = matchedSubstrings?.map { it.toData() }
                ?: throw IllegalArgumentException("matchedSubstrings is null."),
        structuredFormatting = structuredFormatting?.toData()
                ?: throw IllegalArgumentException("structuredFormatting is null."),
        terms = terms?.map { it.toData() }
                ?: throw IllegalArgumentException("terms is null."),
        distanceMeters = distanceMeters,
        placeId = placeId,
        types = types?.map { PlaceType[it] }
)

internal fun PlaceAutocompleteMatchedSubstringResp.toData() = PlaceAutocompleteMatchedSubstring(
        length = length
                ?: throw IllegalArgumentException("length is null."),
        offset = offset
                ?: throw IllegalArgumentException("offset is null.")
)

internal fun PlaceAutocompleteStructuredFormatResp.toData() = PlaceAutocompleteStructuredFormat(
        mainText = mainText
                ?: throw IllegalArgumentException("mainText is null."),
        mainTextMatchedSubstrings = mainTextMatchedSubstrings?.map { it.toData() }
                ?: throw IllegalArgumentException("mainTextMatchedSubstrings is null."),
        secondaryText = secondaryText,
        secondaryTextMatchedSubstrings = secondaryTextMatchedSubstrings?.map { it.toData() }
)

internal fun PlaceAutocompleteTermResp.toData() = PlaceAutocompleteTerm(
        offset = offset ?: throw IllegalArgumentException("offset is null."),
        value = value ?: throw IllegalArgumentException("value is null.")
)

internal fun PlaceResp.toData() = Place(
        addressComponents = addressComponents?.map { it.toData() },
        adrAddress = adrAddress,
        businessStatus = businessStatus?.let { BusinessStatus[it] },
        curbsidePickup = curbsidePickup,
        currentOpeningHours = currentOpeningHours?.toData(),
        delivery = delivery,
        dineIn = dineIn,
        editorialSummary = editorialSummary?.toData(),
        formattedAddress = formattedAddress,
        formattedPhoneNumber = formattedPhoneNumber,
        geometry = geometry?.toData(),
        icon = icon?.let { URL(it) },
        iconBackgroundColor = iconBackgroundColor,
        iconMaskBase = iconMaskBaseUri?.let { URL(it) },
        internationalPhoneNumber = internationalPhoneNumber,
        name = name,
        openingHours = openingHours?.toData(),
        photos = photos?.map { it.toData() },
        placeId = placeId,
        plusCode = plusCode?.toData(),
        priceLv = priceLv?.let { PriceLevel[it] },
        rating = rating,
        reservable = reservable,
        reviews = reviews?.map { it.toData() },
        secondaryOpeningHours = secondaryOpeningHours?.toData(),
        beer = servesBeer,
        breakfast = servesBreakfast,
        brunch = servesBrunch,
        dinner = servesDinner,
        lunch = servesLunch,
        vegetarianFood = servesVegetarianFood,
        wine = servesWine,
        takeout = takeout,
        types = types?.map { PlaceType[it] }?.toSet(),
        url = url?.let { URL(it) },
        userRatingsTotal = userRatingsTotal,
        utcOffset = utcOffset?.let { Duration.ofMinutes(it.toLong()) },
        vicinity = vicinity,
        website = website?.let { URL(it) },
        wheelchairAccessibleEntrance = wheelchairAccessibleEntrance
)

internal fun AddressComponentResp.toData() = AddressComponent(
        longName = longName
                ?: throw IllegalArgumentException("longName is null."),
        shortName = shortName
                ?: throw IllegalArgumentException("shortName is null."),
        types = types?.map { PlaceType[it] }?.toSet()
                ?: throw IllegalArgumentException("types is null.")
)

internal fun PlaceOpeningHoursResp.toData() = PlaceOpeningHours(
        open = open,
        periods = periods?.map { it.toData() },
        specialDays = specialDays?.map { it.toData() },
        type = type?.let { PlaceOpeningHoursType.valueOf(it) },
        weekdays = weekdayText
)

internal fun PlaceOpeningHoursPeriodResp.toData() = PlaceOpeningHoursPeriod(
        open = open?.toData() ?: throw IllegalArgumentException("open is null."),
        close = close?.toData()
)

internal fun PlaceOpeningHoursPeriodDetailResp.toData() = PlaceOpeningHoursPeriodDetail(
        day = PlaceOpeningHoursPeriodDetail.codeToDayOfWeek(day ?: throw IllegalArgumentException("day is null.")),
        time = LocalTime.parse(time ?: throw IllegalArgumentException("time is null."), TIME_FORMATTER),
        date = date?.let { LocalDate.parse(it, DATE_FORMATTER) },
        truncated = truncated ?: false
)

internal fun PlaceSpecialDayResp.toData() = PlaceSpecialDay(
        date = date?.let { LocalDate.parse(it, PlaceSpecialDay.DATE_FORMATTER) },
        exceptionalHours = exceptionalHours ?: false
)

internal fun PlaceEditorialSummaryResp.toData() = PlaceEditorialSummary(
        language = language?.let { Locale.forLanguageTag(it) },
        overview = overview
)

internal fun GeometryResp.toData() = Geometry(
        location = location?.toData()
                ?: throw IllegalArgumentException("location is null."),
        viewport = viewport?.toData()
                ?: throw IllegalArgumentException("viewport is null.")
)

internal fun LatLngLiteralResp.toData() = LatLng(
        latitude = lat
                ?: throw IllegalArgumentException("lat is null."),
        longitude = lng
                ?: throw IllegalArgumentException("lng is null.")
)

internal fun BoundsResp.toData() = Bounds(
        northEast = northEast?.toData()
                ?: throw IllegalArgumentException("northEast is null"),
        southWest = southWest?.toData()
                ?: throw IllegalArgumentException("southWest is null.")
)

internal fun PlacePhotoResp.toData() = PlacePhoto(
        width = width
                ?: throw IllegalArgumentException("width is null."),
        height = height
                ?: throw IllegalArgumentException("height is null."),
        htmlAttributions = htmlAttributions
                ?: throw IllegalArgumentException("htmlAttributions is null."),
        photoReference = photoReference
                ?: throw IllegalArgumentException("photoReference is null.")
)

internal fun PlusCodeResp.toData() = PlusCode(
        globalCode = globalCode
                ?: throw IllegalArgumentException("globalCode is null."),
        compoundCode = compoundCode
                ?: throw IllegalArgumentException("compoundCode is null.")
)

internal fun PlaceReviewResp.toData() = PlaceReview(
        authorName = authorName
                ?: throw IllegalArgumentException("authorName is null"),
        rating = rating
                ?: throw IllegalArgumentException("rating is null."),
        relativeTimeDescription = relativeTimeDescription
                ?: throw IllegalArgumentException("relativeTimeDescription is null."),
        time = time?.let { Instant.ofEpochSecond(it) } ?: throw IllegalArgumentException("time is null."),
        author = authorUrl?.let { URL(it) },
        language = language?.let { Locale.forLanguageTag(it) },
        originalLanguage = originalLanguage?.let { Locale.forLanguageTag(it) },
        profilePhoto = profilePhotoUrl?.let { URL(it) },
        text = text,
        translated = translated
                ?: false
)

internal fun DirectionsRouteResp.toData() = DirectionsRoute(
        bounds = bounds?.toData()
                ?: throw IllegalArgumentException("bounds is null."),
        copyrights = copyrights
                ?: throw IllegalArgumentException("copyrights is null."),
        legs = legs?.map { it.toData() }
                ?: throw IllegalArgumentException("legs is null."),
        overviewPolyline = overviewPolyline?.toData()
                ?: throw IllegalArgumentException("overviewPolyline is null."),
        summary = summary
                ?: throw IllegalArgumentException("summary is null."),
        warnings = warnings
                ?: throw IllegalArgumentException("warnings is null."),
        waypointOrder = waypointOrder
                ?: throw IllegalArgumentException("waypointOrder is null."),
        fare = fare?.toData())

internal fun DirectionsGeocodedWaypointResp.toData() = DirectionsGeocodedWaypoint(
        geocoderStatus = GeocoderStatus[geocoderStatus
                ?: throw IllegalArgumentException("geocoderStatus is null")],
        partialMatch = partialMatch,
        placeId = placeId,
        types = types?.map { PlaceType[it] })

internal fun DirectionsLegResp.toData() = DirectionsLeg(
        endAddress = endAddress
                ?: throw IllegalArgumentException("endAddress is null."),
        endLocation = endLocation?.toData()
                ?: throw IllegalArgumentException("endLocation is null."),
        startAddress = startAddress
                ?: throw IllegalArgumentException("startAddress is null."),
        startLocation = startLocation?.toData()
                ?: throw IllegalArgumentException("startLocation is null."),
        steps = steps?.map { it.toData() }
                ?: throw IllegalArgumentException("steps is null."),
        viaWaypoint = viaWaypoint?.map { it.toData() }
                ?: throw IllegalArgumentException("viaWaypoint is null."),
        arrivalTime = arrivalTime?.toData(),
        departureTime = departureTime?.toData(),
        distance = distance?.toData()
                ?: throw IllegalArgumentException("distance is null."),
        duration = duration?.toData()
                ?: throw IllegalArgumentException("duration is null."),
        durationInTraffic = durationInTraffic?.toData()
)

internal fun FareResp.toData() = Fare(
        Currency.getInstance(currency),
        text ?: throw IllegalArgumentException("text is null."),
        value ?: throw IllegalArgumentException("value is null.")
)

/**
 * See [`PolylineEncoding`](https://github.com/googlemaps/google-maps-services-java/blob/main/src/main/java/com/google/maps/internal/PolylineEncoding.java).
 */
internal fun decodePolyline(encodedPolyline: String): List<LatLng> {
    val len = encodedPolyline.length
    val path = mutableListOf<LatLng>()

    var index = 0
    var lat = 0.0
    var lng = 0.0

    while (index < len) {
        var result = 1
        var shift = 0
        var b: Int
        do {
            b = encodedPolyline[index++].code - 63 - 1
            result += b shl shift
            shift += 5
        } while (b >= 0x1f)
        lat += if (result and 1 != 0) (result shr 1).inv() else result shr 1
        result = 1
        shift = 0
        do {
            b = encodedPolyline[index++].code - 63 - 1
            result += b shl shift
            shift += 5
        } while (b >= 0x1f)
        lng += if (result and 1 != 0) (result shr 1).inv() else result shr 1
        path.add(LatLng(lat * 1e-5, lng * 1e-5))
    }

    return path
}

/**
 * See [`PolylineEncoding`](https://github.com/googlemaps/google-maps-services-java/blob/main/src/main/java/com/google/maps/internal/PolylineEncoding.java).
 */
internal fun encodePolyline(polyline: List<LatLng>): String {
    var lastLat: Long = 0
    var lastLng: Long = 0

    val result = StringBuilder()

    for (point in polyline) {
        val lat = (point.latitude * 1e5).roundToLong()
        val lng = (point.longitude * 1e5).roundToLong()
        val dLat = lat - lastLat
        val dLng = lng - lastLng

        encode(dLat, result)
        encode(dLng, result)

        lastLat = lat
        lastLng = lng
    }
    return result.toString()
}

private fun encode(value: Long, result: StringBuilder) {
    var v = value
    v = if (v < 0) (v shl 1).inv() else v shl 1
    while (v >= 0x20) {
        result.append(Character.toChars(((0x20L or (v and 0x1fL)) + 63).toInt()))
        v = v shr 5
    }
    result.append(Character.toChars((v + 63).toInt()))
}

internal fun DirectionsPolylineResp.toData() = DirectionsPolyline(
        decodePolyline(points ?: throw IllegalArgumentException("points is null."))
)

internal fun DirectionsStepResp.toData() = DirectionsStep(
        duration = duration?.toData()
                ?: throw IllegalArgumentException("duration is null."),
        endLocation = endLocation?.toData()
                ?: throw IllegalArgumentException("endLocation is null."),
        html = html ?: throw IllegalArgumentException("html is null."),
        polyline = polyline?.toData()
                ?: throw IllegalArgumentException("polyline is null."),
        startLocation = startLocation?.toData()
                ?: throw IllegalArgumentException("startLocation is null."),
        travelMode = TravelMode[travelMode ?: throw IllegalArgumentException("travelMode is null.")],
        distance = distance?.toData(),
        maneuver = maneuver?.run { Maneuver[this] },
        steps = steps,
        transitDetails = transitDetails?.toData()
)

internal fun DirectionsTransitDetailsResp.toData() = DirectionsTransitDetails(
        arrivalStop = arrivalStop?.toData(),
        arrivalTime = arrivalTime?.toData(),
        departureStop = departureStop?.toData(),
        departureTime = departureTime?.toData(),
        headsign = headsign,
        headway = headway,
        line = line?.toData(),
        numStops = numStops,
        tripShortName = tripShortName
)

internal fun DirectionsTransitLineResp.toData() = DirectionsTransitLine(
        agencies = agencies?.map { it.toData() }
                ?: throw IllegalArgumentException("agencies is null."),
        name = name
                ?: throw IllegalArgumentException("name is null."),
        color = color,
        icon = icon?.run { URL(this) },
        shortName = shortName,
        textColor = textColor,
        url = url?.run { URL(this) },
        vehicle = vehicle?.toData()
)

internal fun DirectionsTransitVehicleResp.toData() = DirectionsTransitVehicle(
        name = name
                ?: throw IllegalArgumentException("name is null."),
        type = VehicleType[type ?: throw IllegalArgumentException("type is null.")],
        icon = icon?.run { URL(this) },
        localIcon = localIcon?.run { URL(this) }
)

internal fun DirectionsTransitAgencyResp.toData() = DirectionsTransitAgency(
        name = name,
        phone = phone,
        url = url?.run { URL(this) })

internal fun DirectionsTransitStopResp.toData() = DirectionsTransitStop(
        location = location?.toData()
                ?: throw IllegalArgumentException("location is null."),
        name = name ?: throw IllegalArgumentException("name is null.")
)

internal fun DirectionsViaWaypointResp.toData() = DirectionsViaWaypoint(
        location = location?.toData(),
        stepIndex = stepIndex,
        stepInterpolation = stepInterpolation
)

internal fun TimeZoneTextValueObjectResp.toData(): ZonedDateTime = ZonedDateTime.ofInstant(
        Instant.ofEpochSecond(value?.toLong() ?: throw IllegalArgumentException("value is null.")),
        ZoneId.of(timeZone)
)

internal fun TextValueObjectResp.toData() = LabeledNumber(
        label = text ?: throw IllegalArgumentException("text is null."),
        number = value ?: throw IllegalArgumentException("value is null.")
)
