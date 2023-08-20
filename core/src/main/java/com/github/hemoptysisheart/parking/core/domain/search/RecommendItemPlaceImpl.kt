package com.github.hemoptysisheart.parking.core.domain.search

import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.search.RecommendItemPlace

class RecommendItemPlaceImpl(
        override val place: Place
) : RecommendItemPlace {
    override val name: String = place.name

    override val description = place.address

    override fun toString() = "RecommendItemPlaceImpl(place=$place, name='$name', description='$description')"
}