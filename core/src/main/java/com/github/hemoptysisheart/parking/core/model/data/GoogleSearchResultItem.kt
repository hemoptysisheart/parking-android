package com.github.hemoptysisheart.parking.core.model.data

import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceDto
import com.github.hemoptysisheart.parking.core.model.data.SearchResultItemType.GOOGLE_PLACE
import java.util.*

class GoogleSearchResultItem(
    id: UUID,
    val place: PlaceDto
) : SearchResultItem(id, GOOGLE_PLACE) {
    override val name =
        place.name ?: place.formattedAddress ?: place.vicinity ?: throw IllegalArgumentException("no name source")

    override val address: String =
        place.formattedAddress ?: place.vicinity ?: place.geometry?.location?.run { "$latitude, $longitude" }
        ?: throw IllegalArgumentException("no address source.")

    override fun toString() =
        "${GoogleSearchResultItem::class.simpleName}(id=$id, place=$place, name='$name', address='$address')"
}
