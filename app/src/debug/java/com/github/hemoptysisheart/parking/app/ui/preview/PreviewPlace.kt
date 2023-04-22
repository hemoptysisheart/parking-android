package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.client.google.data.*
import com.github.hemoptysisheart.parking.core.client.google.data.BusinessStatus.OPERATIONAL
import com.github.hemoptysisheart.parking.core.client.google.data.PlaceTypeResultOnly.*
import com.github.hemoptysisheart.parking.core.client.google.data.PlaceTypes.*
import java.net.URL

@Suppress("NonAsciiCharacters")
object PreviewPlace {
    val PLACE_AAA_TOHO_TRADING = Place(
        businessStatus = OPERATIONAL,
        geometry = Geometry(
            location = LatLng(35.4917783, 139.3650979),
            viewport = Bounds(
                northEast = LatLng(35.49312967989272, 139.3664428798928),
                southWest = LatLng(35.49043002010727, 139.3637432201073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png"),
        iconBackgroundColor = "#4B96F3",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/shopping_pinlet"),
        internationalPhoneNumber = null,
        name = "AAA TOHO TRADING CO.,LTD",
        openingHours = PlaceOpeningHours(open = true),
        photos = listOf(
            PlacePhoto(
                width = 1800,
                height = 4000,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/113173478751734568017\">A Google User</a>"),
                photoReference = "AfLeUgNVKYKUVpIdzmfDoBdBt4Gn9PdsZSwVRG7R-WLRzP6Cd1nYptRy3FkMaGE5X5I__SIUZt1RKIzrpmwzeawyZvTevErL8tMBxlNliiuBTmjSizHiO-_dqvlh3y6u90P7pTx9G38fe6hk8Kw2tA6a0yft2ZMiYCacnsox8avrqSr83c5i"
            )
        ),
        placeId = "ChIJMUH2eXYBGWARcGY5koRIRs8",
        plusCode = PlusCode(globalCode = "8Q7XF9R8+P2", compoundCode = "F9R8+P2 아쓰기시 가나가와현"),
        priceLv = null,
        rating = 3.0,
        types = setOf(CAR_DEALER, POINT_OF_INTEREST, STORE, ESTABLISHMENT),
        userRatingsTotal = 2,
        vicinity = "fragiranc, b101, 825-2 Sekiguchi, Atsugi"
    )

    val PLACE_株式会社ＡＡＡ = Place(
        businessStatus = OPERATIONAL,
        geometry = Geometry(
            location = LatLng(35.5319675, 139.5936011),
            viewport = Bounds(
                northEast = LatLng(35.53331732989273, 139.5949509298927),
                southWest = LatLng(35.53061767010729, 139.5922512701073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png"),
        iconBackgroundColor = "#7B9EB0",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet"),
        name = "株式会社ＡＡＡ",
        placeId = "ChIJN5OqHdFeGGARQy0CezOuOoo",
        plusCode = PlusCode(globalCode = "8Q7XGHJV+QC", compoundCode = "GHJV+QC 요코하마시 가나가와현"),
        rating = 0.0,
        types = setOf(POINT_OF_INTEREST, ESTABLISHMENT),
        userRatingsTotal = 0,
        vicinity = "3 Chome-12-4 Nakamachidai, Tsuzuki Ward, Yokohama"
    )

    val PLACE_AAA_ANNEX_GALLERY = Place(
        businessStatus = OPERATIONAL,
        geometry = Geometry(
            location = LatLng(35.4428389, 139.6454866),
            viewport = Bounds(
                northEast = LatLng(35.44418872989272, 139.6468364298927),
                southWest = LatLng(35.44148907010727, 139.6441367701073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png"),
        iconBackgroundColor = "#7B9EB0",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet"),
        internationalPhoneNumber = null,
        name = "AAA ANNEX GALLERY",
        openingHours = PlaceOpeningHours(open = false),
        photos = listOf(
            PlacePhoto(
                width = 1478,
                height = 1108,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/113473592042565107677\">A Google User</a>"),
                photoReference = "AfLeUgMetgbB-Sp1MvZyKkczwkMyt33Cegdnfp_z60qt_zxlvM0CgBlULCVYi_OTOs5geJxFD2JWG7n9-IyuxOPrTufWn6QuENN8Orr4z2xR5K63amHA9HyI7dYg5LPwkg4Fsj5IiRNABBb5EwI4toZacqO2X9QbIUIxFreoO_oh0BO5NTq-"
            )
        ),
        placeId = "ChIJ6c94s8RdGGARkdqslpHRHcE",
        plusCode = PlusCode(globalCode = "8Q7XCJVW+45", compoundCode = "CJVW+45 요코하마시 가나가와현"),
        rating = 4.1,
        types = setOf(ART_GALLERY, POINT_OF_INTEREST, ESTABLISHMENT),
        userRatingsTotal = 8,
        vicinity = "Yokohama, Naka Ward, Yamashitacho, 146-2 2F 3F"
    )

    val PLACE_AAA_NIHON_株式会社 = Place(
        businessStatus = OPERATIONAL,
        geometry = Geometry(
            location = LatLng(35.5125369, 139.3055891),
            viewport = Bounds(
                northEast = LatLng(35.51382987989273, 139.3069111798927),
                southWest = LatLng(35.51113022010728, 139.3042115201073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png"),
        iconBackgroundColor = "#4B96F3",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/shopping_pinlet"),
        name = "AAA NIHON 株式会社",
        openingHours = PlaceOpeningHours(
            open = true,
        ),
        photos = listOf(
            PlacePhoto(
                width = 1920,
                height = 1280,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/106822725631179913733\">A Google User</a>"),
                photoReference = "AfLeUgOIVmylVRf8xileTEa9Sk5zXGrWTMluAPRjkVDwuWnHeSxfARcnMwVuTwZlWi4XSpzO9o823Qo9nzvbEAmiVBrl-rGftE_y9ltnnPh0XoCQpuptVE6duuxTXQPJCwW5b0zhPWNpsSJFteEgW1p0kJ2Akn2KwRw_cFn4RdTAIh8BH-PU"
            )
        ),
        placeId = "ChIJk9c8mIH_GGARHRaoBiEM7kA",
        plusCode = PlusCode(globalCode = "8Q7XG874+26", compoundCode = "G874+26 아쓰기시 가나가와현"),
        rating = 4.0,
        types = setOf(CAR_DEALER, POINT_OF_INTEREST, STORE, ESTABLISHMENT),
        userRatingsTotal = 3,
        vicinity = "2023-2 Kamiogino, Atsugi"
    )

    val PLACE_GOOBNE_CHICKEN_曙橋店 = Place(
        businessStatus = OPERATIONAL,
        geometry = Geometry(
            location = LatLng(35.6957648, 139.7197928),
            viewport = Bounds(
                northEast = LatLng(35.69710397989272, 139.7211313798927),
                southWest = LatLng(35.69440432010728, 139.7184317201073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png"),
        iconBackgroundColor = "#FF9E67",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet"),
        name = "Goobne Chicken 曙橋店",
        openingHours = PlaceOpeningHours(open = false),
        photos = listOf(
            PlacePhoto(
                width = 3024,
                height = 4032,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/111865503606189267632\">순영</a>"),
                photoReference = "AfLeUgNtdK-0y-VlJRsSyNAJP42exYmXGoHiZfB-pvaKizTyaSx34OHmioMN67B6fYQomWYcBxp2VmMQcLRp3dpENDGC4SgaL80_-WMp8nrT5KCULl3pfejIAmrgxIC0v4WyQpxXKpkIsJToC3ODqMfSIxa9tAccao-eR25VBUEXb4Xhnn4p"
            )
        ),
        placeId = "ChIJHR3d64mNGGARMNiJ9_jF6rI",
        plusCode = PlusCode(globalCode = "8Q7XMPW9+8W", compoundCode = "MPW9+8W 신주쿠구 도쿄도"),
        rating = 4.4,
        types = setOf(RESTAURANT, FOOD, POINT_OF_INTEREST, ESTABLISHMENT),
        userRatingsTotal = 47,
        vicinity = "Shinjuku City, Kawadacho, 3−8 THE DENS 1階"
    )

    val PARKING_시부야역_주변_주차장 = Place(
        geometry = Geometry(
            location = LatLng(35.657978, 139.7006704),
            viewport = Bounds(
                northEast = LatLng(35.65939225915965, 139.7020545328841),
                southWest = LatLng(35.65669429857665, 139.6993565723011)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/parking-71.png"),
        iconBackgroundColor = "#7B9EB0",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/parking_pinlet"),
        name = "Parking lot",
        placeId = "ChIJOdUdkFeLGGARW-FfQi0C9uo",
        types = setOf(PREMISE, PARKING, POINT_OF_INTEREST, ESTABLISHMENT),
        vicinity = "1"
    )

    val PLACE_패밀리마트_카부키쵸키타점 = Place(
        businessStatus = OPERATIONAL,
        geometry = Geometry(
            location = LatLng(35.697963, 139.7027484),
            viewport = Bounds(
                northEast = LatLng(35.69934972989272, 139.7040417298927),
                southWest = LatLng(35.69665007010727, 139.7013420701073)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png"),
        iconBackgroundColor = "#4B96F3",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/convenience_pinlet"),
        name = "패밀리마트 카부키쵸키타점",
        openingHours = PlaceOpeningHours(open = true),
        photos = listOf(
            PlacePhoto(
                width = 4895,
                height = 3268,
                htmlAttributions = listOf("<a href=\"https://maps.google.com/maps/contrib/110807531686252733131\">Masahiko Motono</a>"),
                photoReference = "AUjq9jmIgt0vs5f-Fqw7BL2GeU5U92OHi3raao9-tJqb1oKxHYH4zbGpEkAMcfKOrqPodcPFZimWcl8Brd12cNwSzww9-vOuvAWfuzJIepcDqM2BXDpVWJevb7mvPmEOPfuampfgZWLEFgUtIHV7pKgGBi9E_P_DJEOdwPZe03Yq6tKDdPZV"
            )
        ),
        placeId = "ChIJN2hXkieNGGARWPSysdlRajE",
        plusCode = PlusCode(globalCode = "8Q7XMPX3+53", compoundCode = "MPX3+53 신주쿠구 도쿄도"),
        rating = 3.8,
        types = setOf(CONVENIENCE_STORE, POINT_OF_INTEREST, FOOD, STORE, ESTABLISHMENT),
        userRatingsTotal = 20,
        vicinity = "2 Chome-32-7 Kabukicho, Shinjuku City"
    )

    val PLACE_ECOLO_PARK_KABUKICHO_29 = Place(
        businessStatus = OPERATIONAL,
        geometry = Geometry(
            location = LatLng(35.6978697, 139.7031539),
            viewport = Bounds(
                northEast = LatLng(35.6992126302915, 139.7045446302915),
                southWest = LatLng(35.6965146697085, 139.7018466697085)
            )
        ),
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/parking-71.png"),
        iconBackgroundColor = "#7B9EB0",
        iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/parking_pinlet"),
        name = "Ecolo Park Kabukicho #29",
        placeId = "ChIJX13CrEaNGGARP7TB4u26SMk",
        plusCode = PlusCode(globalCode = "8Q7XMPX3+47", compoundCode = "MPX3+47 일본 도쿄도 신주쿠구"),
        types = setOf(PARKING, POINT_OF_INTEREST, ESTABLISHMENT),
        vicinity = "2-chōme-32-13 Kabukichō, Shinjuku City"
    )
}
