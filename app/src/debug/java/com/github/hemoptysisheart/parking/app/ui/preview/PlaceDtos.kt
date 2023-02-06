package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.client.google.dto.*
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceTypeResultOnly.ESTABLISHMENT
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceTypeResultOnly.POINT_OF_INTEREST
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceTypes.*
import java.net.URL

@Suppress("NonAsciiCharacters")
object PlaceDtos {
    val PLACE_AAA_TOHO_TRADING = PlaceDto(
        businessStatus = BusinessStatus.OPERATIONAL,
        geometry = GeometryDto(
            location = LatLngDto(35.4917783, 139.3650979),
            viewport = BoundsDto(
                northEast = LatLngDto(35.49312967989272, 139.3664428798928),
                southWest = LatLngDto(35.49043002010727, 139.3637432201073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png"),
        iconBackgroundColor = "#4B96F3",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/shopping_pinlet"),
        internationalPhoneNumber = null,
        name = "AAA TOHO TRADING CO.,LTD",
        openingHours = PlaceOpeningHoursDto(open = true),
        photos = listOf(
            PlacePhotoDto(
                width = 1800,
                height = 4000,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/113173478751734568017\">A Google User</a>"),
                photoReference = "AfLeUgNVKYKUVpIdzmfDoBdBt4Gn9PdsZSwVRG7R-WLRzP6Cd1nYptRy3FkMaGE5X5I__SIUZt1RKIzrpmwzeawyZvTevErL8tMBxlNliiuBTmjSizHiO-_dqvlh3y6u90P7pTx9G38fe6hk8Kw2tA6a0yft2ZMiYCacnsox8avrqSr83c5i"
            )
        ),
        placeId = "ChIJMUH2eXYBGWARcGY5koRIRs8",
        plusCode = PlusCodeDto(globalCode = "8Q7XF9R8+P2", compoundCode = "F9R8+P2 아쓰기시 가나가와현"),
        priceLv = null,
        rating = 3.0,
        types = setOf(CAR_DEALER, POINT_OF_INTEREST, STORE, ESTABLISHMENT),
        userRatingsTotal = 2,
        vicinity = "fragiranc, b101, 825-2 Sekiguchi, Atsugi"
    )

    val PLACE_株式会社ＡＡＡ = PlaceDto(
        businessStatus = BusinessStatus.OPERATIONAL,
        geometry = GeometryDto(
            location = LatLngDto(35.5319675, 139.5936011),
            viewport = BoundsDto(
                northEast = LatLngDto(35.53331732989273, 139.5949509298927),
                southWest = LatLngDto(35.53061767010729, 139.5922512701073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png"),
        iconBackgroundColor = "#7B9EB0",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet"),
        name = "株式会社ＡＡＡ",
        placeId = "ChIJN5OqHdFeGGARQy0CezOuOoo",
        plusCode = PlusCodeDto(globalCode = "8Q7XGHJV+QC", compoundCode = "GHJV+QC 요코하마시 가나가와현"),
        rating = 0.0,
        types = setOf(POINT_OF_INTEREST, ESTABLISHMENT),
        userRatingsTotal = 0,
        vicinity = "3 Chome-12-4 Nakamachidai, Tsuzuki Ward, Yokohama"
    )

    val PLACE_AAA_ANNEX_GALLERY = PlaceDto(
        businessStatus = BusinessStatus.OPERATIONAL,
        geometry = GeometryDto(
            location = LatLngDto(35.4428389, 139.6454866),
            viewport = BoundsDto(
                northEast = LatLngDto(35.44418872989272, 139.6468364298927),
                southWest = LatLngDto(35.44148907010727, 139.6441367701073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png"),
        iconBackgroundColor = "#7B9EB0",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet"),
        internationalPhoneNumber = null,
        name = "AAA ANNEX GALLERY",
        openingHours = PlaceOpeningHoursDto(open = false),
        photos = listOf(
            PlacePhotoDto(
                width = 1478,
                height = 1108,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/113473592042565107677\">A Google User</a>"),
                photoReference = "AfLeUgMetgbB-Sp1MvZyKkczwkMyt33Cegdnfp_z60qt_zxlvM0CgBlULCVYi_OTOs5geJxFD2JWG7n9-IyuxOPrTufWn6QuENN8Orr4z2xR5K63amHA9HyI7dYg5LPwkg4Fsj5IiRNABBb5EwI4toZacqO2X9QbIUIxFreoO_oh0BO5NTq-"
            )
        ),
        placeId = "ChIJ6c94s8RdGGARkdqslpHRHcE",
        plusCode = PlusCodeDto(globalCode = "8Q7XCJVW+45", compoundCode = "CJVW+45 요코하마시 가나가와현"),
        rating = 4.1,
        types = setOf(ART_GALLERY, POINT_OF_INTEREST, ESTABLISHMENT),
        userRatingsTotal = 8,
        vicinity = "Yokohama, Naka Ward, Yamashitacho, 146-2 2F 3F"
    )

    val PLACE_AAA_NIHON_株式会社 = PlaceDto(
        businessStatus = BusinessStatus.OPERATIONAL,
        geometry = GeometryDto(
            location = LatLngDto(35.5125369, 139.3055891),
            viewport = BoundsDto(
                northEast = LatLngDto(35.51382987989273, 139.3069111798927),
                southWest = LatLngDto(35.51113022010728, 139.3042115201073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png"),
        iconBackgroundColor = "#4B96F3",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/shopping_pinlet"),
        name = "AAA NIHON 株式会社",
        openingHours = PlaceOpeningHoursDto(
            open = true,
        ),
        photos = listOf(
            PlacePhotoDto(
                width = 1920,
                height = 1280,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/106822725631179913733\">A Google User</a>"),
                photoReference = "AfLeUgOIVmylVRf8xileTEa9Sk5zXGrWTMluAPRjkVDwuWnHeSxfARcnMwVuTwZlWi4XSpzO9o823Qo9nzvbEAmiVBrl-rGftE_y9ltnnPh0XoCQpuptVE6duuxTXQPJCwW5b0zhPWNpsSJFteEgW1p0kJ2Akn2KwRw_cFn4RdTAIh8BH-PU"
            )
        ),
        placeId = "ChIJk9c8mIH_GGARHRaoBiEM7kA",
        plusCode = PlusCodeDto(globalCode = "8Q7XG874+26", compoundCode = "G874+26 아쓰기시 가나가와현"),
        rating = 4.0,
        types = setOf(CAR_DEALER, POINT_OF_INTEREST, STORE, ESTABLISHMENT),
        userRatingsTotal = 3,
        vicinity = "2023-2 Kamiogino, Atsugi"
    )
}