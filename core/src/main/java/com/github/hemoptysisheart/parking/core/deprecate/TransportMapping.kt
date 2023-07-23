package com.github.hemoptysisheart.parking.core.deprecate

import com.github.hemoptysisheart.parking.core.client.google.data.TransportationMode
import com.github.hemoptysisheart.parking.domain.deprecate.Transport

enum class TransportMapping(
    val mode: TransportationMode,
    val transport: Transport
) {
    WALKING(TransportationMode.WALKING, Transport.WALK),
    DRIVING(TransportationMode.DRIVING, Transport.DRIVE),
    BICYCLING(TransportationMode.BICYCLING, Transport.BICYCLE),
    TRANSIT(TransportationMode.TRANSIT, Transport.TRANSIT);

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        operator fun get(mode: TransportationMode) = values().first { mode == it.mode }.transport

        operator fun get(transport: Transport) = values().first { transport == it.transport }.mode
    }
}
