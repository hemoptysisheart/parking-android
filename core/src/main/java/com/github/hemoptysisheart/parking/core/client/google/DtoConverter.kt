package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.dto.*
import com.github.hemoptysisheart.parking.core.client.google.response.*
import java.net.URL
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

internal object DtoConverter {
    fun toPlaceDto(resp: PlaceResp) = PlaceDto(
        resp.addressComponents?.map { toAddressComponentDto(it) },
        resp.adrAddress,
        resp.businessStatus?.let { BusinessStatus[it] },
        resp.curbsidePickup,
        resp.currentOpeningHours?.let { toPlaceOpeningHoursDto(it) },
        resp.delivery,
        resp.dineIn,
        resp.editorialSummary?.let { toPlaceEditorialSummaryDto(it) },
        resp.formattedAddress,
        resp.formattedPhoneNumber,
        resp.geometry?.let { toGeometryDto(it) },
        resp.icon?.let { URL(it) },
        resp.iconBackgroundColor,
        resp.iconMaskBaseUri?.let { URL(it) },
        resp.internationalPhoneNumber,
        resp.name,
        resp.openingHours?.let { toPlaceOpeningHoursDto(it) },
        resp.photos?.map { toPlacePhotoDto(it) },
        resp.placeId,
        resp.plusCode?.let { toPlusCodeDto(it) },
        resp.priceLv?.let { PriceLevel[it] },
        resp.rating,
        resp.reservable,
        resp.reviews?.map { toPlaceReviewDto(it) },
        resp.secondaryOpeningHours?.let { toPlaceOpeningHoursDto(it) },
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

    fun toAddressComponentDto(resp: AddressComponentResp) = AddressComponentDto(
        longName = resp.longName ?: throw IllegalArgumentException("longName is null."),
        shortName = resp.shortName ?: throw IllegalArgumentException("shortName is null."),
        types = resp.types?.map { PlaceType[it] }?.toSet() ?: throw IllegalArgumentException("types is null.")
    )

    fun toPlaceOpeningHoursDto(resp: PlaceOpeningHoursResp) = PlaceOpeningHoursDto(
        open = resp.open,
        periods = resp.periods?.map { toPlaceOpeningHoursPeriodDto(it) },
        specialDays = resp.specialDays?.map { toPlaceSpecialDayDto(it) },
        type = resp.type?.let { PlaceOpeningHoursType.valueOf(it) },
        weekdays = resp.weekdayText
    )

    fun toPlaceOpeningHoursPeriodDto(resp: PlaceOpeningHoursPeriodResp) = PlaceOpeningHoursPeriodDto(
        open = toPlaceOpeningHoursPeriodDetailDto(resp.open ?: throw IllegalArgumentException("open is null.")),
        close = resp.close?.let { toPlaceOpeningHoursPeriodDetailDto(it) }
    )

    fun toPlaceOpeningHoursPeriodDetailDto(resp: PlaceOpeningHoursPeriodDetailResp) = PlaceOpeningHoursPeriodDetailDto(
        day = PlaceOpeningHoursPeriodDetailDto.codeToDayOfWeek(
            resp.day
                ?: throw IllegalArgumentException("day is null.")
        ),
        time = LocalTime.parse(
            resp.time
                ?: throw IllegalArgumentException("time is null."),
            PlaceOpeningHoursPeriodDetailDto.TIME_FORMATTER
        ),
        date = resp.date?.let { LocalDate.parse(it, PlaceOpeningHoursPeriodDetailDto.DATE_FORMATTER) },
        truncated = resp.truncated ?: false
    )

    fun toPlaceSpecialDayDto(resp: PlaceSpecialDayResp) = PlaceSpecialDayDto(
        date = resp.date?.let { LocalDate.parse(it, PlaceSpecialDayDto.DATE_FORMATTER) },
        exceptionalHours = resp.exceptionalHours ?: false
    )

    fun toPlaceEditorialSummaryDto(resp: PlaceEditorialSummaryResp) = PlaceEditorialSummaryDto(
        language = resp.language?.let { Locale.forLanguageTag(it) },
        overview = resp.overview
    )

    fun toGeometryDto(resp: GeometryResp) = GeometryDto(
        location = toLatLngDto(resp.location ?: throw IllegalArgumentException("location is null.")),
        viewport = toBoundsDto(resp.viewport ?: throw IllegalArgumentException("viewport is null."))
    )

    fun toLatLngDto(resp: LatLngLiteralResp) = LatLngDto(
        latitude = resp.lat ?: throw IllegalArgumentException("lat is null."),
        longitude = resp.lng ?: throw IllegalArgumentException("lng is null.")
    )

    fun toBoundsDto(resp: BoundsResp) = BoundsDto(
        northEast = toLatLngDto(resp.northEast ?: throw IllegalArgumentException("northEast is null")),
        southWest = toLatLngDto(resp.southWest ?: throw IllegalArgumentException("southWest is null."))
    )

    fun toPlacePhotoDto(resp: PlacePhotoResp) =
        PlacePhotoDto(
            width = resp.width ?: throw IllegalArgumentException("width is null."),
            height = resp.height ?: throw IllegalArgumentException("height is null."),
            htmlAttributions = resp.htmlAttributions ?: throw IllegalArgumentException("htmlAttributions is null."),
            photoReference = resp.photoReference ?: throw IllegalArgumentException("photoReference is null.")
        )

    fun toPlusCodeDto(resp: PlusCodeResp) = PlusCodeDto(
        globalCode = resp.globalCode ?: throw IllegalArgumentException("globalCode is null."),
        compoundCode = resp.compoundCode ?: throw IllegalArgumentException("compoundCode is null.")
    )

    private fun toPlaceReviewDto(resp: PlaceReviewResp) = PlaceReviewDto(
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
}

