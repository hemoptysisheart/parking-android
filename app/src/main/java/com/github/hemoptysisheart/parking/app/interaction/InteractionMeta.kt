package com.github.hemoptysisheart.parking.app.interaction

import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.common.Object
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets.UTF_8

interface InteractionMeta {
    fun arg(uri: URI): String = URLEncoder.encode("$uri", UTF_8)

    fun arg(identifier: Identifier): String = URLEncoder.encode("${identifier.toURI()}", UTF_8)

    fun arg(obj: Object): String = URLEncoder.encode("${obj.id.toURI()}", UTF_8)
}
