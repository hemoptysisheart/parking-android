package com.github.hemoptysisheart.parking.core.domain.search

import com.github.hemoptysisheart.parking.core.domain.common.AbstractObject
import com.github.hemoptysisheart.parking.core.domain.common.Types.QUERY
import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.place.Geolocation
import com.github.hemoptysisheart.util.NonNegativeInt

class Query(
        override val query: String,
        override val center: Geolocation,
        override val distance: NonNegativeInt
) : AbstractObject(Identifier(QUERY, query)), com.github.hemoptysisheart.parking.domain.search.Query {
    override fun toSimpleString() = query

    override fun toString() = "Query(query='$query', center=${center.toSimpleString()}, distance=$distance)"
}
