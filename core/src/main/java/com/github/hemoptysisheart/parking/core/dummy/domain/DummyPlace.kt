package com.github.hemoptysisheart.parking.core.dummy.domain

import com.github.f4b6a3.ulid.UlidCreator
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Place
import com.github.hemoptysisheart.parking.domain.PlaceLevel
import com.github.hemoptysisheart.parking.domain.SimpleLocation
import java.math.BigDecimal
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

/**
 * 미리보기(`@Preview`)에 사용할 [Place]와 하위 타입의 인스턴스.
 */
object DummyPlace {
    val PLACE1 = object : Place {
        override val id: UUID = UlidCreator.getMonotonicUlid().toUuid()
        override val level: PlaceLevel = PlaceLevel.values().toList().random()
        override val location: Location = SimpleLocation(1L, 37.0, 127.0)
        override var name: String = "어떤 장소(Place)"
        override var description: String = "미리보기용 어떤 장소(Place)."
        override val createdAt: Instant = Instant.now().minus(1L, ChronoUnit.DAYS)
        override val updatedAt: Instant = Instant.now()
        override fun toString() =
            "{id=$id, level=$level, location=$location, name=$name, description=$description, createdAt=$createdAt, updatedAt=$updatedAt}"
    }

    val PLACE2 = object : Place {
        override val id: UUID = UlidCreator.getMonotonicUlid().toUuid()
        override val level: PlaceLevel = PlaceLevel.values().random()
        override val location: Location = SimpleLocation(2L, BigDecimal("10.0"), BigDecimal("100.0"))
        override var name: String = "place #1"
        override var description: String = "dummy place #$id"
        override val createdAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
        override val updatedAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
        override fun toString() =
            "{id=$id, level=$level, location=$location, name=$name, description=$description, createdAt=$createdAt, updatedAt=$updatedAt}"
    }
    val PLACE3 = object : Place {
        override val id: UUID = UlidCreator.getMonotonicUlid().toUuid()
        override val level: PlaceLevel = PlaceLevel.values().random()
        override val location: Location = SimpleLocation(3L, BigDecimal("18.0"), BigDecimal("180.0"))
        override var name: String = "place #2"
        override var description: String = "dummy place #$id"
        override val createdAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
        override val updatedAt: Instant = Instant.now().truncatedTo(ChronoUnit.MILLIS)
        override fun toString() =
            "{id=$id, level=$level, location=$location, name=$name, description=$description, createdAt=$createdAt, updatedAt=$updatedAt}"
    }
}