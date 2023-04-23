package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PARKING_시부야역_주변_주차장
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PLACE_AAA_ANNEX_GALLERY
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PLACE_AAA_NIHON_株式会社
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PLACE_AAA_TOHO_TRADING
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PLACE_ECOLO_PARK_KABUKICHO_29
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PLACE_GOOBNE_CHICKEN_曙橋店
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PLACE_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlace.PLACE_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.core.model.data.LocationGmpPlace
import com.github.hemoptysisheart.parking.domain.GeoLocation

@Suppress("ObjectPropertyName", "NonAsciiCharacters")
object PreviewLocation {
    val LOCATION_AAA_TOHO_TRADING = LocationGmpPlace(PLACE_AAA_TOHO_TRADING)

    val LOCATION_株式会社ＡＡＡ = LocationGmpPlace(PLACE_株式会社ＡＡＡ)

    val LOCATION_AAA_ANNEX_GALLERY = LocationGmpPlace(PLACE_AAA_ANNEX_GALLERY)

    val LOCATION_AAA_NIHON_株式会社 = LocationGmpPlace(PLACE_AAA_NIHON_株式会社)

    val LOCATION_GOOBNE_CHICKEN_曙橋店 = LocationGmpPlace(PLACE_GOOBNE_CHICKEN_曙橋店)

    val LOCATION_시부야역_주변_주차장 = LocationGmpPlace(PARKING_시부야역_주변_주차장)

    val LOCATION_신주쿠역 = GeoLocation(35.68968315223954, 139.70031567000726)

    val LOCATION_ECOLO_PARK_KABUKICHO_29 = LocationGmpPlace(PLACE_ECOLO_PARK_KABUKICHO_29)

    val LOCATION_패밀리마트_카부키쵸키타점 = LocationGmpPlace(PLACE_패밀리마트_카부키쵸키타점)
}
