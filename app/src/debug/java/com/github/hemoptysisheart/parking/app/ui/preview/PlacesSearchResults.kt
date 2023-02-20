package com.github.hemoptysisheart.parking.app.ui.preview

import com.google.maps.model.*
import java.net.URL

@Suppress("NonAsciiCharacters")
object PlacesSearchResults {
    val AAA_TOHO_TRADING = PlacesSearchResult().apply {
        businessStatus = "OPERATIONAL"
        geometry = Geometry().apply {
            location = LatLng(35.4917783, 139.3650979)
            viewport = Bounds().apply {
                northeast = LatLng(35.49312967989272, 139.3664428798928)
                southwest = LatLng(35.49043002010727, 139.3637432201073)
            }
        }
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png")
        name = "AAA TOHO TRADING CO.,LTD"
        openingHours = OpeningHours().apply {
            openNow = true
        }
        photos = arrayOf(
            Photo().apply {
                width = 1800
                height = 4000
                htmlAttributions =
                    arrayOf("<a href=\"https://maps.google.com/maps/contrib/113173478751734568017\">A Google User</a>")
                photoReference =
                    "AfLeUgNVKYKUVpIdzmfDoBdBt4Gn9PdsZSwVRG7R-WLRzP6Cd1nYptRy3FkMaGE5X5I__SIUZt1RKIzrpmwzeawyZvTevErL8tMBxlNliiuBTmjSizHiO-_dqvlh3y6u90P7pTx9G38fe6hk8Kw2tA6a0yft2ZMiYCacnsox8avrqSr83c5i"
            }
        )
        placeId = "ChIJMUH2eXYBGWARcGY5koRIRs8"
        rating = 3.0F
        types = arrayOf("car_dealer", "point_of_interest", "store", "establishment")
        userRatingsTotal = 2
        vicinity = "fragiranc, b101, 825-2 Sekiguchi, Atsugi"
    }

    val 株式会社ＡＡＡ = PlacesSearchResult().apply {
        businessStatus = "OPERATIONAL"
        geometry = Geometry().apply {
            location = LatLng(35.5319675, 139.5936011)
            viewport = Bounds().apply {
                northeast = LatLng(35.53331732989273, 139.5949509298927)
                southwest = LatLng(35.53061767010729, 139.5922512701073)
            }
        }
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png")
        name = "株式会社ＡＡＡ"
        placeId = "ChIJN5OqHdFeGGARQy0CezOuOoo"
        rating = 0.0F
        types = arrayOf("point_of_interest", "establishment")
        userRatingsTotal = 0
        vicinity = "3 Chome-12-4 Nakamachidai, Tsuzuki Ward, Yokohama"
    }

    val AAA_ANNEX_GALLERY = PlacesSearchResult().apply {
        businessStatus = "OPERATIONAL"
        geometry = Geometry().apply {
            location = LatLng(35.4428389, 139.6454866)
            viewport = Bounds().apply {
                northeast = LatLng(35.44418872989272, 139.6468364298927)
                southwest = LatLng(35.44148907010727, 139.6441367701073)
            }
        }
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png")
        name = "AAA ANNEX GALLERY"
        openingHours = OpeningHours().apply { openNow = false }
        photos = arrayOf(
            Photo().apply {
                width = 1478
                height = 1108
                htmlAttributions =
                    arrayOf("<a href=\"https://maps.google.com/maps/contrib/113473592042565107677\">A Google User</a>")
                photoReference =
                    "AfLeUgMetgbB-Sp1MvZyKkczwkMyt33Cegdnfp_z60qt_zxlvM0CgBlULCVYi_OTOs5geJxFD2JWG7n9-IyuxOPrTufWn6QuENN8Orr4z2xR5K63amHA9HyI7dYg5LPwkg4Fsj5IiRNABBb5EwI4toZacqO2X9QbIUIxFreoO_oh0BO5NTq-"
            }
        )
        placeId = "ChIJ6c94s8RdGGARkdqslpHRHcE"
        rating = 4.1F
        types = arrayOf("art_gallery", "point_of_interest", "establishment")
        userRatingsTotal = 8
        vicinity = "Yokohama, Naka Ward, Yamashitacho, 146-2 2F 3F"
    }

    val AAA_NIHON_株式会社 = PlacesSearchResult().apply {
        businessStatus = "OPERATIONAL"
        geometry = Geometry().apply {
            location = LatLng(35.5125369, 139.3055891)
            viewport = Bounds().apply {
                northeast = LatLng(35.51382987989273, 139.3069111798927)
                southwest = LatLng(35.51113022010728, 139.3042115201073)
            }
        }
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png")
        name = "AAA NIHON 株式会社"
        openingHours = OpeningHours().apply { openNow = true }
        photos = arrayOf(
            Photo().apply {
                width = 1920
                height = 1280
                htmlAttributions =
                    arrayOf("<a href=\"https://maps.google.com/maps/contrib/106822725631179913733\">A Google User</a>")
                photoReference =
                    "AfLeUgOIVmylVRf8xileTEa9Sk5zXGrWTMluAPRjkVDwuWnHeSxfARcnMwVuTwZlWi4XSpzO9o823Qo9nzvbEAmiVBrl-rGftE_y9ltnnPh0XoCQpuptVE6duuxTXQPJCwW5b0zhPWNpsSJFteEgW1p0kJ2Akn2KwRw_cFn4RdTAIh8BH-PU"
            }
        )
        placeId = "ChIJk9c8mIH_GGARHRaoBiEM7kA"
        rating = 4.0F
        types = arrayOf("car_dealer", "point_of_interest", "store", "establishment")
        userRatingsTotal = 3
        vicinity = "2023-2 Kamiogino, Atsugi"
    }

    val GOOBNE_CHICKEN_曙橋店 = PlacesSearchResult().apply {
        businessStatus = "OPERATIONAL"
        geometry = Geometry().apply {
            location = LatLng(35.6957648, 139.7197928)
            viewport = Bounds().apply {
                northeast = LatLng(35.69710397989272, 139.7211313798927)
                southwest = LatLng(35.69440432010728, 139.7184317201073)
            }
        }
        icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png")
        name = "Goobne Chicken 曙橋店"
        openingHours = OpeningHours().apply { openNow = false }
        photos = arrayOf(
            Photo().apply {
                width = 3024
                height = 4032
                htmlAttributions =
                    arrayOf("<a href=\"https://maps.google.com/maps/contrib/111865503606189267632\">순영</a>")
                photoReference =
                    "AfLeUgNtdK-0y-VlJRsSyNAJP42exYmXGoHiZfB-pvaKizTyaSx34OHmioMN67B6fYQomWYcBxp2VmMQcLRp3dpENDGC4SgaL80_-WMp8nrT5KCULl3pfejIAmrgxIC0v4WyQpxXKpkIsJToC3ODqMfSIxa9tAccao-eR25VBUEXb4Xhnn4p"
            }
        )
        placeId = "ChIJHR3d64mNGGARMNiJ9_jF6rI"
        rating = 4.4F
        types = arrayOf("restaurant", "food", "point_of_interest", "establishment")
        userRatingsTotal = 47
        vicinity = "Shinjuku City, Kawadacho, 3−8 THE DENS 1階"
    }
}
