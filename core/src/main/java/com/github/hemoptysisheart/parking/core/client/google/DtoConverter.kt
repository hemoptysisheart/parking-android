package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.dto.*
import com.github.hemoptysisheart.parking.core.client.google.response.*
import java.net.URL
import java.time.*
import java.util.*

@Suppress("MemberVisibilityCanBePrivate")
internal object DtoConverter {
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

    fun toPlaceOpeningHoursPeriod(resp: PlaceOpeningHoursPeriodResp) = PlaceOpeningHoursPeriod(
        open = toPlaceOpeningHoursPeriodDetail(resp.open ?: throw IllegalArgumentException("open is null.")),
        close = resp.close?.let { toPlaceOpeningHoursPeriodDetail(it) }
    )

    fun toPlaceOpeningHoursPeriodDetail(resp: PlaceOpeningHoursPeriodDetailResp) = PlaceOpeningHoursPeriodDetail(
        day = PlaceOpeningHoursPeriodDetail.codeToDayOfWeek(
            resp.day
                ?: throw IllegalArgumentException("day is null.")
        ),
        time = LocalTime.parse(
            resp.time
                ?: throw IllegalArgumentException("time is null."),
            PlaceOpeningHoursPeriodDetail.TIME_FORMATTER
        ),
        date = resp.date?.let { LocalDate.parse(it, PlaceOpeningHoursPeriodDetail.DATE_FORMATTER) },
        truncated = resp.truncated ?: false
    )

    fun toPlaceSpecialDay(resp: PlaceSpecialDayResp) = PlaceSpecialDay(
        date = resp.date?.let { LocalDate.parse(it, PlaceSpecialDay.DATE_FORMATTER) },
        exceptionalHours = resp.exceptionalHours ?: false
    )

    fun toPlaceEditorialSummary(resp: PlaceEditorialSummaryResp) = PlaceEditorialSummary(
        language = resp.language?.let { Locale.forLanguageTag(it) },
        overview = resp.overview
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

    fun toPlacePhoto(resp: PlacePhotoResp) =
        PlacePhoto(
            width = resp.width ?: throw IllegalArgumentException("width is null."),
            height = resp.height ?: throw IllegalArgumentException("height is null."),
            htmlAttributions = resp.htmlAttributions ?: throw IllegalArgumentException("htmlAttributions is null."),
            photoReference = resp.photoReference ?: throw IllegalArgumentException("photoReference is null.")
        )

    fun toPlusCode(resp: PlusCodeResp) = PlusCode(
        globalCode = resp.globalCode ?: throw IllegalArgumentException("globalCode is null."),
        compoundCode = resp.compoundCode ?: throw IllegalArgumentException("compoundCode is null.")
    )

    fun toPlaceReview(resp: PlaceReviewResp) = PlaceReview(
        authorName = resp.authorName ?: throw IllegalArgumentException("authorName is null"),
        rating = resp.rating ?: throw IllegalArgumentException("rating is null."),
        relativeTimeDescription = resp.relativeTimeDescription
            ?: throw IllegalArgumentException("relativeTimeDescription is null."),
        time = resp.time?.let { Instant.ofEpochSecond(it) }
            ?: throw IllegalArgumentException("time is null."),
        author = resp.authorUrl?.let { URL(it) },
        language = resp.language?.let { Locale.forLanguageTag(it) },
        originalLanguage = resp.originalLanguage?.let { Locale.forLanguageTag(it) },
        profilePhoto = resp.profilePhotoUrl?.let { URL(it) },
        text = resp.text,
        translated = resp.translated ?: false
    )

    fun toDirectionsRoute(resp: DirectionsRouteResp) = DirectionsRoute(
        bounds = resp.bounds?.let {
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
        fare = resp.fare?.let { toFare(it) }
    )

    fun toDirectionsGeocodedWaypoint(resp: DirectionsGeocodedWaypointResp) = DirectionsGeocodedWaypoint(
        geocoderStatus = GeocoderStatus.valueOf(
            resp.geocoderStatus ?: throw IllegalArgumentException("geocoderStatus is null")
        ),
        partialMatch = resp.partialMatch,
        placeId = resp.placeId,
        types = resp.types?.map { PlaceType[it] }
    )

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
        distance = resp.distance?.let { toLabeledNumber(it) } ?: throw IllegalArgumentException("distance is null."),
        duration = resp.duration?.let { toLabeledNumber(it) } ?: throw IllegalArgumentException("duration is null."),
        durationInTraffic = resp.durationInTraffic?.let { toLabeledNumber(it) }
            ?: throw IllegalArgumentException("durationInTraffic is null.")
    )

    fun toFare(resp: FareResp) = Fare()

    fun toDirectionsPolyline(resp: DirectionsPolylineResp) = DirectionsPolyline()

    fun toDirectionsStep(resp: DirectionsStepResp) = DirectionsStep()

    fun toDirectionsViaWaypoint(resp: DirectionsViaWaypointResp) = DirectionsViaWaypoint()

    fun toZonedDateTime(resp: TimeZoneTextValueObjectResp): ZonedDateTime = ZonedDateTime.ofInstant(
        Instant.ofEpochSecond(resp.value?.toLong() ?: throw IllegalArgumentException("value is null.")),
        ZoneId.of(resp.timeZone)
    )

    fun toLabeledNumber(resp: TextValueObjectResp) = LabeledNumber(resp.text, resp.value)
}

