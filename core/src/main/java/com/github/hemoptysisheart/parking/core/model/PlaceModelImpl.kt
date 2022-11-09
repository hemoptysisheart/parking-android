package com.github.hemoptysisheart.parking.core.model

import com.github.f4b6a3.ulid.UlidCreator
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Place
import com.github.hemoptysisheart.parking.domain.PlaceLevel
import java.math.BigDecimal
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

class PlaceModelImpl : PlaceModel {
    companion object {
        private val TAG = PlaceModelImpl::class.simpleName
    }

    override val places = listOf(
        object : Place {
            override val id: UUID = UlidCreator.getMonotonicUlid().toUuid()
            override val level: PlaceLevel = PlaceLevel.values().random()
            override val location: Location = object : Location {
                override val latitude: BigDecimal = BigDecimal("10.0")
                override val longitude: BigDecimal = BigDecimal("100.0")
            }
            override var name: String = "place #1"
            override var description: String = "dummy place #$id"
            override val createdAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
            override val updatedAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
        },
        object : Place {
            override val id: UUID = UlidCreator.getMonotonicUlid().toUuid()
            override val level: PlaceLevel = PlaceLevel.values().random()
            override val location: Location = object : Location {
                override val latitude: BigDecimal = BigDecimal("18.0")
                override val longitude: BigDecimal = BigDecimal("180.0")
            }
            override var name: String = "place #2"
            override var description: String = "dummy place #$id"
            override val createdAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
            override val updatedAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
        }
    )

    override fun read(id: UUID): Place? = places.firstOrNull { it.id == id }

    override fun toString() = "$TAG(places=$places)"
}