package com.github.hemoptysisheart.parking.core.domain.common

import android.net.Uri
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.common.Identifier

private val LOGGER = AndroidLogger(Identifier::class)

fun String.toIdentifier(): Identifier {
    val uri = Uri.parse(this)
    val id = Identifier(
            type = Types.ofHost(uri.host ?: throw IllegalArgumentException("host is null.")),
            key = uri.path?.substring(1) ?: throw IllegalArgumentException("path is null.")
    )
    LOGGER.v("#toIdentifier : $this => $id")
    return id
}
