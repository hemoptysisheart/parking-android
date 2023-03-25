package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlaceDtos.PARKING_시부야역_주변_주차장
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlaceDtos.PLACE_AAA_ANNEX_GALLERY
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlaceDtos.PLACE_AAA_NIHON_株式会社
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlaceDtos.PLACE_AAA_TOHO_TRADING
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlaceDtos.PLACE_GOOBNE_CHICKEN_曙橋店
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPlaceDtos.PLACE_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.core.model.dto.LocationGmpPlace

@Suppress("ObjectPropertyName", "NonAsciiCharacters")
object PreviewLocation {
    val LOCATION_AAA_TOHO_TRADING = LocationGmpPlace(PLACE_AAA_TOHO_TRADING)

    val LOCATION_株式会社ＡＡＡ = LocationGmpPlace(PLACE_株式会社ＡＡＡ)

    val LOCATION_AAA_ANNEX_GALLERY = LocationGmpPlace(PLACE_AAA_ANNEX_GALLERY)

    val LOCATION_AAA_NIHON_株式会社 = LocationGmpPlace(PLACE_AAA_NIHON_株式会社)

    val LOCATION_GOOBNE_CHICKEN_曙橋店 = LocationGmpPlace(PLACE_GOOBNE_CHICKEN_曙橋店)

    val 시부야역_주변_주차장 = LocationGmpPlace(PARKING_시부야역_주변_주차장)
}
