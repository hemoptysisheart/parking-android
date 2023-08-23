@file:Suppress("ObjectPropertyName", "NonAsciiCharacters")

package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.domain.place.PlaceGooglePlace
import com.github.hemoptysisheart.parking.core.domain.search.RecommendItemPlaceImpl
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.parking.domain.place.PlaceType

val GEOLOCATION_시부야역 = Geolocation(35.658114, 139.700103)

val PLACE_로손편의점_니시신주쿠_7_10_19 = PlaceGooglePlace(
        key = "ChIJ95b-StaMGGARVvYEiFpckoc",
        type = PlaceType.DESTINATION,
        name = "로손 편의점",
        address = "7 Chome-10-19 Nishishinjuku, Shinjuku City",
        geolocation = Geolocation(35.6943706, 139.698652)
)

val PLACE_로손편의점_오사키_1_11_2 = PlaceGooglePlace(
        key = "ChIJP5DPcPWKGGAR81CoK5yKGGo",
        type = PlaceType.DESTINATION,
        name = "로손 편의점",
        address = "Shinagawa City, Osaki, 1 Chome−11−2 イースト１Ｆ",
        geolocation = Geolocation(35.6189257, 139.7316987)
)

val PLACE_로손오오테센터빌딩점_1_1_3 = PlaceGooglePlace(
        key = "ChIJOb0N3weMGGAR0ktew8sonWE",
        type = PlaceType.DESTINATION,
        name = "로손 오오테센터빌딩점",
        address = "1 Chome-1-3 Ōtemachi, Chiyoda City",
        geolocation = Geolocation(35.6859664, 139.7627356)
)

val PLACE_로손편의점_스미요시_2_22 = PlaceGooglePlace(
        key = "ChIJTb9rxPBcGGARNCzcd7D5HM0",
        type = PlaceType.DESTINATION,
        name = "로손편의점",
        address = "Yokohama, Naka Ward, Sumiyoshicho, 2 Chome−２２",
        geolocation = Geolocation(35.4456134, 139.6384636)
)

val PLACE_PALACE_BLDG_PARKING_LOT = PlaceGooglePlace(
        key = "ChIJtbhdVQuNGGARh0cSvgIFxVk",
        type = PlaceType.PARKING,
        name = "Palace Hotel Tokyo / Palace Bldg. Parking Lot",
        address = "大手町駅, 2-chōme-1−１ Ōtemachi, Chiyoda City",
        geolocation = Geolocation(35.6854699, 139.7619157)
)
val PLACE_OTEMACHI_FIRST_SQARE_PARKING_LOT = PlaceGooglePlace(
        key = "ChIJGzOVkQeMGGAR4cZ9TCBklSM",
        type = PlaceType.PARKING,
        name = "Otemachi First Sqare Parking Lot",
        address = "1-chōme-5-1 Ōtemachi, Chiyoda City",
        geolocation = Geolocation(35.6859173, 139.7643562)
)
val PLACE_丸の内ガーデンタワー_バイク駐車場 = PlaceGooglePlace(
        key = "ChIJ8RDPZ26LGGARglPmWLZuso8",
        type = PlaceType.PARKING,
        name = "丸の内ガーデンタワー バイク駐車場",
        address = "Nissay Marunouchi " +
                "Gardentower, 3階, 1-chōme-1-3 Marunouchi, Chiyoda City",
        geolocation = Geolocation(35.68454729999999, 139.7627144)
)
val PLACE_TIMES_NIHON_SEIMEI_MARUNOUCHI_GARDEN_TOWER = PlaceGooglePlace(
        key = "ChIJBZqsN_iLGGARTroNsCvOJHA",
        type = PlaceType.PARKING,
        name = "Times Nihon Seimei Marunouchi Garden Tower",
        address = "1 Chome-1 Marunouchi, Chiyoda City",
        geolocation = Geolocation(35.684428, 139.762656)
)
val PLACE_OTEMACHI_BUILDING_PARKING = PlaceGooglePlace(
        key = "ChIJx0JCmQeMGGAR31_V-v94bdU",
        type = PlaceType.PARKING,
        name = "Otemachi Building parking",
        address = "1-chōme-6-1 Ōtemachi, Chiyoda City",
        geolocation = Geolocation(35.686429, 139.764829)
)
val PLACE_OTEMACHIONE_BIKE_LOCKER = PlaceGooglePlace(
        key = "ChIJs-hcVn2NGGAR4a7vsaGylAg",
        type = PlaceType.PARKING,
        name = "OtemachiOne Bike Locker",
        address = "1-chōme-２ 国道20号 Ōtemachi, Chiyoda City",
        geolocation = Geolocation(35.6876366, 139.7623328)
)

val RECOMMEND_ITEM_로손편의점_니시신주쿠_7_10_19 = RecommendItemPlaceImpl(PLACE_로손편의점_니시신주쿠_7_10_19)

val RECOMMEND_ITEM_로손편의점_오사키_1_11_2 = RecommendItemPlaceImpl(PLACE_로손편의점_오사키_1_11_2)

val RECOMMEND_ITEM_로손오오테센터빌딩점_1_1_3 = RecommendItemPlaceImpl(PLACE_로손오오테센터빌딩점_1_1_3)

val RECOMMEND_ITEM_로손편의점_스미요시_2_22 = RecommendItemPlaceImpl(PLACE_로손편의점_스미요시_2_22)
