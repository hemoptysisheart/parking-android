package com.github.hemoptysisheart.parking.core.dummy.domain

import com.github.f4b6a3.ulid.UlidCreator
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Place
import com.github.hemoptysisheart.parking.domain.PlaceLevel
import com.github.hemoptysisheart.parking.domain.SimpleLocation
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

/**
 * 미리보기(`@Preview`)에 사용할 [Place]와 하위 타입의 인스턴스.
 */
object DummyPlace {
    val PLACE = object : Place {
        override val id: UUID = UlidCreator.getMonotonicUlid().toUuid()

        override val level: PlaceLevel = PlaceLevel.values().toList().random()

        override val location: Location = SimpleLocation(37.0, 127.0)

        override var name: String = "어떤 장소(Place)"

        override var description: String = "미리보기용 어떤 장소(Place)."

        override val createdAt: Instant = Instant.now().minus(1L, ChronoUnit.DAYS)

        override val updatedAt: Instant = Instant.now()
    }
}