package com.github.hemoptysisheart.parking.core.client.google

import android.icu.util.Currency
import android.net.Uri
import com.github.hemoptysisheart.parking.core.client.google.data.*
import com.github.hemoptysisheart.parking.core.client.google.response.*
import com.github.hemoptysisheart.parking.domain.GeoLocation
import com.github.hemoptysisheart.parking.domain.Location
import java.net.URL
import java.time.*
import java.util.*
import kotlin.math.roundToLong

@Suppress("MemberVisibilityCanBePrivate")
internal object DataConverter {
    fun toPlaceAutocompletePrediction(resp: PlaceAutocompletePredictionResp) = PlaceAutocompletePrediction(
        resp.description ?: throw IllegalArgumentException("description is null."),
        resp.matchedSubstrings?.map { toPlaceAutocompleteMatchedSubstring(it) }
            ?: throw IllegalArgumentException("matchedSubstrings is null."),
        toStructuredFormatting(
            resp.structuredFormatting ?: throw IllegalArgumentException("structuredFormatting is null.")
        ),
        resp.terms?.map { toPlaceAutocompleteTerm(it) } ?: throw IllegalArgumentException("terms is null."),
        resp.distanceMeters,
        resp.placeId,
        resp.types?.map { PlaceType[it] }
    )

    fun toPlaceAutocompleteMatchedSubstring(resp: PlaceAutocompleteMatchedSubstringResp) =
        PlaceAutocompleteMatchedSubstring(
            resp.length ?: throw IllegalArgumentException("length is null."),
            resp.offset ?: throw IllegalArgumentException("offset is null.")
        )

    fun toStructuredFormatting(resp: PlaceAutocompleteStructuredFormatResp) =
        PlaceAutocompleteStructuredFormat(
            mainText = resp.mainText ?: throw IllegalArgumentException("mainText is null."),
            mainTextMatchedSubstrings = resp.mainTextMatchedSubstrings?.map { toPlaceAutocompleteMatchedSubstring(it) }
                ?: throw IllegalArgumentException("mainTextMatchedSubstrings is null."),
            secondaryText = resp.secondaryText,
            secondaryTextMatchedSubstrings = resp.secondaryTextMatchedSubstrings?.map {
                toPlaceAutocompleteMatchedSubstring(
                    it
                )
            } ?: throw IllegalArgumentException("secondaryTextMatchedSubstrings is null.")
        )

    fun toPlaceAutocompleteTerm(resp: PlaceAutocompleteTermResp) = PlaceAutocompleteTerm(
        offset = resp.offset ?: throw IllegalArgumentException("offset is null."),
        value = resp.value ?: throw IllegalArgumentException("value is null.")
    )

    fun toPlace(resp: PlaceResp) = Place(
        resp.addressComponents?.map { toAddressComponent(it) },
        resp.adrAddress,
        resp.businessStatus?.let { BusinessStatus[it] },
        resp.curbsidePickup,
        resp.currentOpeningHours?.let { toPlaceOpeningHours(it) },
        resp.delivery,
        resp.dineIn,
        resp.editorialSummary?.let { toPlaceEditorialSummary(it) },
        resp.formattedAddress,
        resp.formattedPhoneNumber,
        resp.geometry?.let { toGeometry(it) },
        resp.icon?.let { URL(it) },
        resp.iconBackgroundColor,
        resp.iconMaskBaseUri?.let { URL(it) },
        resp.internationalPhoneNumber,
        resp.name,
        resp.openingHours?.let { toPlaceOpeningHours(it) },
        resp.photos?.map { toPlacePhoto(it) },
        resp.placeId,
        resp.plusCode?.let { toPlusCode(it) },
        resp.priceLv?.let { PriceLevel[it] },
        resp.rating,
        resp.reservable,
        resp.reviews?.map { toPlaceReview(it) },
        resp.secondaryOpeningHours?.let { toPlaceOpeningHours(it) },
        resp.servesBeer,
        resp.servesBreakfast,
        resp.servesBrunch,
        resp.servesDinner,
        resp.servesLunch,
        resp.servesVegetarianFood,
        resp.servesWine,
        resp.takeout,
        resp.types?.map { PlaceType[it] }?.toSet(),
        resp.url?.let { URL(it) },
        resp.userRatingsTotal,
        resp.utcOffset?.let { Duration.ofMinutes(it.toLong()) },
        resp.vicinity,
        resp.website?.let { URL(it) },
        resp.wheelchairAccessibleEntrance
    )

    fun toAddressComponent(resp: AddressComponentResp) = AddressComponent(
        longName = resp.longName ?: throw IllegalArgumentException("longName is null."),
        shortName = resp.shortName ?: throw IllegalArgumentException("shortName is null."),
        types = resp.types?.map { PlaceType[it] }?.toSet() ?: throw IllegalArgumentException("types is null.")
    )

    fun toPlaceOpeningHours(resp: PlaceOpeningHoursResp) = PlaceOpeningHours(
        open = resp.open,
        periods = resp.periods?.map { toPlaceOpeningHoursPeriod(it) },
        specialDays = resp.specialDays?.map { toPlaceSpecialDay(it) },
        type = resp.type?.let { PlaceOpeningHoursType.valueOf(it) },
        weekdays = resp.weekdayText
    )

    fun toPlaceOpeningHoursPeriod(resp: PlaceOpeningHoursPeriodResp) =
        PlaceOpeningHoursPeriod(open = toPlaceOpeningHoursPeriodDetail(
            resp.open ?: throw IllegalArgumentException("open is null.")
        ), close = resp.close?.let { toPlaceOpeningHoursPeriodDetail(it) })

    fun toPlaceOpeningHoursPeriodDetail(resp: PlaceOpeningHoursPeriodDetailResp) = PlaceOpeningHoursPeriodDetail(
        day = PlaceOpeningHoursPeriodDetail.codeToDayOfWeek(
            resp.day ?: throw IllegalArgumentException("day is null.")
        ),
        time = LocalTime.parse(
            resp.time ?: throw IllegalArgumentException("time is null."), PlaceOpeningHoursPeriodDetail.TIME_FORMATTER
        ),
        date = resp.date?.let { LocalDate.parse(it, PlaceOpeningHoursPeriodDetail.DATE_FORMATTER) },
        truncated = resp.truncated ?: false
    )

    fun toPlaceSpecialDay(resp: PlaceSpecialDayResp) = PlaceSpecialDay(
        date = resp.date?.let { LocalDate.parse(it, PlaceSpecialDay.DATE_FORMATTER) },
        exceptionalHours = resp.exceptionalHours ?: false
    )

    fun toPlaceEditorialSummary(resp: PlaceEditorialSummaryResp) = PlaceEditorialSummary(
        language = resp.language?.let { Locale.forLanguageTag(it) }, overview = resp.overview
    )

    fun toGeometry(resp: GeometryResp) = Geometry(
        location = toLatLng(resp.location ?: throw IllegalArgumentException("location is null.")),
        viewport = toBounds(resp.viewport ?: throw IllegalArgumentException("viewport is null."))
    )

    fun toLatLng(resp: LatLngLiteralResp) = LatLng(
        latitude = resp.lat ?: throw IllegalArgumentException("lat is null."),
        longitude = resp.lng ?: throw IllegalArgumentException("lng is null.")
    )

    fun toBounds(resp: BoundsResp) = Bounds(
        northEast = toLatLng(resp.northEast ?: throw IllegalArgumentException("northEast is null")),
        southWest = toLatLng(resp.southWest ?: throw IllegalArgumentException("southWest is null."))
    )

    fun toPlacePhoto(resp: PlacePhotoResp) = PlacePhoto(
        width = resp.width ?: throw IllegalArgumentException("width is null."),
        height = resp.height ?: throw IllegalArgumentException("height is null."),
        htmlAttributions = resp.htmlAttributions ?: throw IllegalArgumentException("htmlAttributions is null."),
        photoReference = resp.photoReference ?: throw IllegalArgumentException("photoReference is null.")
    )

    fun toPlusCode(resp: PlusCodeResp) = PlusCode(
        globalCode = resp.globalCode ?: throw IllegalArgumentException("globalCode is null."),
        compoundCode = resp.compoundCode ?: throw IllegalArgumentException("compoundCode is null.")
    )

    fun toPlaceReview(resp: PlaceReviewResp) =
        PlaceReview(authorName = resp.authorName ?: throw IllegalArgumentException("authorName is null"),
            rating = resp.rating ?: throw IllegalArgumentException("rating is null."),
            relativeTimeDescription = resp.relativeTimeDescription
                ?: throw IllegalArgumentException("relativeTimeDescription is null."),
            time = resp.time?.let { Instant.ofEpochSecond(it) } ?: throw IllegalArgumentException("time is null."),
            author = resp.authorUrl?.let { URL(it) },
            language = resp.language?.let { Locale.forLanguageTag(it) },
            originalLanguage = resp.originalLanguage?.let { Locale.forLanguageTag(it) },
            profilePhoto = resp.profilePhotoUrl?.let { URL(it) },
            text = resp.text,
            translated = resp.translated ?: false
        )

    fun toDirectionsRoute(resp: DirectionsRouteResp) = DirectionsRoute(bounds = resp.bounds?.let {
        Bounds(
            toLatLng(it.northEast ?: throw IllegalArgumentException("northEast is null.")),
            toLatLng(it.southWest ?: throw IllegalArgumentException("southWest is null."))
        )
    } ?: throw IllegalArgumentException("bounds is null."),
        copyrights = resp.copyrights ?: throw IllegalArgumentException("copyrights is null."),
        legs = resp.legs?.map { toDirectionsLeg(it) } ?: throw IllegalArgumentException("legs is null."),
        overviewPolyline = toDirectionsPolyline(
            resp.overviewPolyline ?: throw IllegalArgumentException("overviewPolyline is null.")
        ),
        summary = resp.summary ?: throw IllegalArgumentException("summary is null."),
        warnings = resp.warnings ?: throw IllegalArgumentException("warnings is null."),
        waypointOrder = resp.waypointOrder ?: throw IllegalArgumentException("waypointOrder is null."),
        fare = resp.fare?.let { toFare(it) })

    fun toDirectionsGeocodedWaypoint(resp: DirectionsGeocodedWaypointResp) =
        DirectionsGeocodedWaypoint(geocoderStatus = GeocoderStatus.valueOf(
            resp.geocoderStatus ?: throw IllegalArgumentException("geocoderStatus is null")
        ), partialMatch = resp.partialMatch, placeId = resp.placeId, types = resp.types?.map { PlaceType[it] })

    fun toDirectionsLeg(resp: DirectionsLegResp) = DirectionsLeg(
        endAddress = resp.endAddress ?: throw IllegalArgumentException("endAddress is null."),
        endLocation = toLatLng(resp.endLocation ?: throw IllegalArgumentException("endLocation is null.")),
        startAddress = resp.startAddress ?: throw IllegalArgumentException("startAddress is null."),
        startLocation = toLatLng(resp.startLocation ?: throw IllegalArgumentException("startLocation is null.")),
        steps = resp.steps?.map { toDirectionsStep(it) } ?: throw IllegalArgumentException("steps is null."),
        viaWaypoint = resp.viaWaypoint?.map { toDirectionsViaWaypoint(it) }
            ?: throw IllegalArgumentException("viaWaypoint is null."),
        arrivalTime = resp.arrivalTime?.let { toZonedDateTime(it) },
        departureTime = resp.departureTime?.let { toZonedDateTime(it) },
        distance = resp.distance?.let { toLabeledNumber(it) }
            ?: throw IllegalArgumentException("distance is null."),
        duration = resp.duration?.let { toLabeledNumber(it) }
            ?: throw IllegalArgumentException("duration is null."),
        durationInTraffic = resp.durationInTraffic?.let { toLabeledNumber(it) }
    )

    fun toFare(resp: FareResp) = Fare(
        Currency.getInstance(resp.currency),
        resp.text ?: throw IllegalArgumentException("text is null."),
        resp.value ?: throw IllegalArgumentException("value is null.")
    )

    /**
     * See [`PolylineEncoding`](https://github.com/googlemaps/google-maps-services-java/blob/main/src/main/java/com/google/maps/internal/PolylineEncoding.java).
     */
    fun decodePolyline(encodedPolyline: String): List<LatLng> {
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
    fun encodePolyline(polyline: List<Location>): String {
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

    private fun encode(value: Long, result: java.lang.StringBuilder) {
        var v = value
        v = if (v < 0) (v shl 1).inv() else v shl 1
        while (v >= 0x20) {
            result.append(Character.toChars(((0x20L or (v and 0x1fL)) + 63).toInt()))
            v = v shr 5
        }
        result.append(Character.toChars((v + 63).toInt()))
    }

    fun toDirectionsPolyline(resp: DirectionsPolylineResp) = DirectionsPolyline(
        decodePolyline(
            resp.points
                ?: throw IllegalArgumentException("points is null.")
        )
    )

    fun toDirectionsStep(resp: DirectionsStepResp) = DirectionsStep(
        duration = toLabeledNumber(resp.duration ?: throw IllegalArgumentException("duration is null.")),
        endLocation = toLatLng(resp.endLocation ?: throw IllegalArgumentException("endLocation is null.")),
        html = resp.html ?: throw IllegalArgumentException("html is null."),
        polyline = toDirectionsPolyline(resp.polyline ?: throw IllegalArgumentException("polyline is null.")),
        startLocation = toLatLng(resp.startLocation ?: throw IllegalArgumentException("startLocation is null.")),
        travelMode = TravelMode.valueOf(resp.travelMode ?: throw IllegalArgumentException("travelMode is null.")),
        distance = resp.distance?.run { toLabeledNumber(this) },
        maneuver = resp.maneuver?.run { Maneuver[this] },
        steps = resp.steps,
        transitDetails = resp.transitDetails?.run { toDirectionsTransitDetails(this) }
    )

    fun toDirectionsTransitDetails(resp: DirectionsTransitDetailsResp) = DirectionsTransitDetails(
        arrivalStop = resp.arrivalStop?.run { toDirectionsTransitStop(this) },
        arrivalTime = resp.arrivalTime?.run { toZonedDateTime(this) },
        departureStop = resp.departureStop?.run { toDirectionsTransitStop(this) },
        departureTime = resp.departureTime?.run { toZonedDateTime(this) },
        headsign = resp.headsign,
        headway = resp.headway,
        line = resp.line?.run { toDirectionsTransitLine(this) },
        numStops = resp.numStops,
        tripShortName = resp.tripShortName
    )

    fun toDirectionsTransitLine(resp: DirectionsTransitLineResp) = DirectionsTransitLine(
        agencies = resp.agencies?.map { toDirectionsTransitAgency(it) }
            ?: throw IllegalArgumentException("agencies is null."),
        name = resp.name ?: throw IllegalArgumentException("name is null."),
        color = resp.color,
        icon = resp.icon?.run { Uri.parse(this) },
        shortName = resp.shortName,
        textColor = resp.textColor,
        url = resp.url?.run { Uri.parse(this) },
        vehicle = resp.vehicle?.run { toDirectionsTransitVehicle(this) }
    )

    fun toDirectionsTransitVehicle(resp: DirectionsTransitVehicleResp) = DirectionsTransitVehicle(
        name = resp.name ?: throw IllegalArgumentException("name is null."),
        type = resp.type?.run { VehicleType.valueOf(this) } ?: throw IllegalArgumentException("type is null."),
        icon = resp.icon?.run { Uri.parse(this) },
        localIcon = resp.localIcon?.run { Uri.parse(this) }
    )

    fun toDirectionsTransitAgency(resp: DirectionsTransitAgencyResp) =
        DirectionsTransitAgency(resp.name, resp.phone, resp.url?.run { Uri.parse(this) })

    fun toDirectionsTransitStop(resp: DirectionsTransitStopResp) = DirectionsTransitStop(
        resp.location?.run {
            GeoLocation(
                lat ?: throw IllegalArgumentException("lat is null."),
                lng ?: throw IllegalArgumentException("lng is null.")
            )
        } ?: throw IllegalArgumentException("location is null."),
        resp.name ?: throw IllegalArgumentException("name is null.")
    )

    fun toDirectionsViaWaypoint(resp: DirectionsViaWaypointResp) = DirectionsViaWaypoint(
        location = resp.location?.run {
            GeoLocation(
                lat ?: throw IllegalArgumentException("lat is null."),
                lng ?: throw IllegalArgumentException("lng is null.")
            )
        },
        stepIndex = resp.stepIndex,
        stepInterpolation = resp.stepInterpolation
    )

    fun toZonedDateTime(resp: TimeZoneTextValueObjectResp): ZonedDateTime = ZonedDateTime.ofInstant(
        Instant.ofEpochSecond(resp.value?.toLong() ?: throw IllegalArgumentException("value is null.")),
        ZoneId.of(resp.timeZone)
    )

    fun toLabeledNumber(resp: TextValueObjectResp) = LabeledNumber(
        resp.text ?: throw IllegalArgumentException("text is null."),
        resp.value ?: throw IllegalArgumentException("value is null.")
    )
}
