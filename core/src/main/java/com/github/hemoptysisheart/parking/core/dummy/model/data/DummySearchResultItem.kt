package com.github.hemoptysisheart.parking.core.dummy.model.data

import com.github.hemoptysisheart.parking.core.client.google.dto.*
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceTypeResultOnly.ESTABLISHMENT
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceTypeResultOnly.POINT_OF_INTEREST
import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceTypes.PARKING
import com.github.hemoptysisheart.parking.core.model.data.GoogleSearchResultItem
import java.net.URL
import java.util.*

object DummySearchResultItem {
    val GMP_0 = GoogleSearchResultItem(
        id = UUID.randomUUID(),
        place = PlaceDto(
            businessStatus = BusinessStatus.OPERATIONAL,
            geometry = GeometryDto(
                location = LatLngDto(35.6901572, 139.7058963),
                viewport = BoundsDto(
                    northEast = LatLngDto(35.69136102989273, 139.7070979298927),
                    southWest = LatLngDto(35.68866137010728, 139.7043982701073)
                )
            ),
            icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/parking-71.png"),
            iconBackgroundColor = "#7B9EB0",
            iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/parking_pinlet"),
            name = "akippa | Shinjuku 3-chome East Bldg. Parking Lot",
            placeId = "ChIJGcbtPK2NGGARVqpGYS9BN_s",
            plusCode = PlusCodeDto(globalCode = "8Q7XMPR4+39", compoundCode = "MPR4+39 신주쿠구 도쿄도"),
            rating = 0.0,
            types = setOf(PARKING, POINT_OF_INTEREST, ESTABLISHMENT),
            vicinity = "3 Chome-1-26 Shinjuku, Shinjuku City",
        )
    )

    val GMP_1 = GoogleSearchResultItem(
        id = UUID.randomUUID(),
        place = PlaceDto(
            businessStatus = BusinessStatus.OPERATIONAL,
            geometry = GeometryDto(
                location = LatLngDto(35.689011, 139.702636),
                viewport = BoundsDto(
                    northEast = LatLngDto(35.69037272989273, 139.7040443298927),
                    southWest = LatLngDto(35.68767307010729, 139.7013446701073)
                )
            ),
            icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/parking-71.png"),
            iconBackgroundColor = "#7B9EB0",
            iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/parking_pinlet"),
            name = "Times Shinjuku 4-Chōme #2",
            openingHours = PlaceOpeningHoursDto(
                open = true,
            ),
            placeId = "ChIJ0ylkv9qMGGARfi2Zw0cHCTE",
            plusCode = PlusCodeDto(globalCode = "8Q7XMPQ3+J3", compoundCode = "MPQ3+J3 신주쿠구 도쿄도"),
            rating = 2.9,
            types = setOf(PARKING, POINT_OF_INTEREST, ESTABLISHMENT),
            userRatingsTotal = 9,
            vicinity = "4 Chome-1 Shinjuku, Shinjuku City",
        )
    )

    val GMP_2 = GoogleSearchResultItem(
        id = UUID.randomUUID(),
        place = PlaceDto(
            businessStatus = BusinessStatus.OPERATIONAL,
            geometry = GeometryDto(
                location = LatLngDto(35.691259, 139.7062589),
                viewport = BoundsDto(
                    northEast = LatLngDto(35.69260002989272, 139.7076337798927),
                    southWest = LatLngDto(35.68990037010727, 139.7049341201073)
                )
            ),
            icon = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/parking-71.png"),
            iconBackgroundColor = "#7B9EB0",
            iconMaskBase = URL("https://maps.gstatic.com/mapfiles/place_api/icons/v2/parking_pinlet"),
            internationalPhoneNumber = null,
            name = "NPC 24 H Shinjuku 3-chome Parking Lot",
            openingHours = PlaceOpeningHoursDto(
                open = true,
            ),
            placeId = "ChIJqyvofNuMGGARP0inn5vHwzQ",
            plusCode = PlusCodeDto(globalCode = "8Q7XMPR4+GG", compoundCode = "MPR4+GG 신주쿠구 도쿄도"),
            rating = 4.2,
            types = setOf(PARKING, POINT_OF_INTEREST, ESTABLISHMENT),
            userRatingsTotal = 6,
            vicinity = "3 Chome-10-3 Shinjuku, Shinjuku City",
        )
    )
}
