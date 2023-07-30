package com.github.hemoptysisheart.parking.core.domain.search

import com.github.hemoptysisheart.parking.core.domain.common.AbstractObject
import com.github.hemoptysisheart.parking.core.domain.common.Types.QUERY
import com.github.hemoptysisheart.parking.domain.common.Identifier

class Query(
    override val query: String
) : AbstractObject(Identifier(QUERY, query)),
    com.github.hemoptysisheart.parking.domain.search.Query {
    override fun toSimpleString() = query

    override fun toString() = "Query(query='$query')"
}