package com.github.hemoptysisheart.parking.core.client.google.data

enum class TransportationMode(
    val code: String
) {
    /**
     * `driving` (default) indicates standard driving directions or distance using the road network.
     */
    DRIVING("driving"),

    /**
     * `walking` requests walking directions or distance via pedestrian paths & sidewalks (where available).
     */
    WALKING("walking"),

    /**
     * `bicycling` requests bicycling directions or distance via bicycle paths & preferred streets (where available).
     */
    BICYCLING("bicycling"),

    /**
     * `transit` requests directions or distance via public transit routes (where available). If you set the mode to
     * transit, you can optionally specify either a `departure_time` or an `arrival_time`. If neither time is specified,
     * the `departure_time` defaults to now (that is, the departure time defaults to the current time). You can also
     * optionally include a `transit_mode` and/or a `transit_routing_preference`.
     */
    TRANSIT("transit");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(code: String) = CODE_MAP[code]!!

        operator fun get(ordinal: Int) = values()[ordinal]
    }
}