@file:Suppress("ObjectPropertyName", "NonAsciiCharacters")

package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.domain.place.PlaceGooglePlace
import com.github.hemoptysisheart.parking.core.domain.search.RecommendItemPlaceImpl
import com.github.hemoptysisheart.parking.domain.place.Geolocation

val GEOLOCATION_시부야역 = Geolocation(35.658114, 139.700103)

val PLACE_로손편의점_니시신주쿠_7_10_19 = PlaceGooglePlace(
        key = "ChIJ95b-StaMGGARVvYEiFpckoc",
        name = "로손 편의점",
        address = "7 Chome-10-19 Nishishinjuku, Shinjuku City",
        geolocation = Geolocation(35.6943706, 139.698652)
)

val PLACE_로손편의점_오사키_1_11_2 = PlaceGooglePlace(
        key = "ChIJP5DPcPWKGGAR81CoK5yKGGo",
        name = "로손 편의점",
        address = "Shinagawa City, Osaki, 1 Chome−11−2 イースト１Ｆ",
        geolocation = Geolocation(35.6189257, 139.7316987)
)

val PLACE_로손오오테센터빌딩점_1_1_3 = PlaceGooglePlace(
        key = "ChIJOb0N3weMGGAR0ktew8sonWE",
        name = "로손 오오테센터빌딩점",
        address = "1 Chome-1-3 Ōtemachi, Chiyoda City",
        geolocation = Geolocation(35.6859664, 139.7627356)
)

val PLACE_로손편의점_스미요시_2_22 = PlaceGooglePlace(key = "ChIJTb9rxPBcGGARNCzcd7D5HM0",
        name = "로손편의점", address = "Yokohama, Naka Ward, Sumiyoshicho, 2 Chome−２２",
        geolocation = Geolocation(35.4456134, 139.6384636)
)

val RECOMMEND_ITEM_로손편의점_니시신주쿠_7_10_19 = RecommendItemPlaceImpl(PLACE_로손편의점_니시신주쿠_7_10_19)
val RECOMMEND_ITEM_로손편의점_오사키_1_11_2 = RecommendItemPlaceImpl(PLACE_로손편의점_오사키_1_11_2)
val RECOMMEND_ITEM_로손오오테센터빌딩점_1_1_3 = RecommendItemPlaceImpl(PLACE_로손오오테센터빌딩점_1_1_3)
val RECOMMEND_ITEM_로손편의점_스미요시_2_22 = RecommendItemPlaceImpl(PLACE_로손편의점_스미요시_2_22)
