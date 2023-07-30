package com.github.hemoptysisheart.parking.core.android

import com.github.hemoptysisheart.parking.core.R
import com.github.hemoptysisheart.parking.domain.common.Object
import com.github.hemoptysisheart.parking.domain.search.Query

/**
 * [Object.id]
 */
val DOMAIN_OBJECT_ID = DomainPropertyResource(Object::id, R.string.domain_property_id)

/**
 * [Query]
 */
val DOMAIN_QUERY = DomainObjectResource(Query::class, R.string.domain_type_query)

/**
 * [Query.query]
 */
val DOMAIN_QUERY_QUERY = DomainPropertyResource(Query::query, R.string.domain_property_query_query)