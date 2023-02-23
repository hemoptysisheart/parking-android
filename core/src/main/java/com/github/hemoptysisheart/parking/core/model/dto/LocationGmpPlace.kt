package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.core.client.google.dto.Place
import com.github.hemoptysisheart.parking.domain.Location

class LocationGmpPlace(
    val place: Place
) : Location {
    companion object {
        private val TAG = LocationGmpPlace::class.simpleName!!
    }

    /**
     * 추천정보 표시에 사용할 수 있는 내용 목록.
     * 이 중에서 `null`이 아닌 것을 찾아서 사용한다.
     */
    private val contents = listOf(
        place.name,
        place.formattedAddress,
        place.vicinity,
        place.geometry?.location.toString()
    )

    override val id = Location.ID_VALIDATOR.validate("$TAG/${place.placeId}")

    override val name: String = contents.firstOrNull()
        ?: id

    override val description: String?
        get() {
            val idx = contents.indexOfFirst { null != it }
            return if (idx < contents.size - 1) {
                contents.subList(idx + 1, contents.size)
                    .firstOrNull { null != it }
            } else {
                null
            }
        }
    override val latitude = place.geometry!!.location.latitude

    override val longitude = place.geometry!!.location.longitude

    override fun equals(other: Any?) = this === other ||
            null != other &&
            other is LocationGmpPlace &&
            id == other.id

    override fun hashCode() = id.hashCode()

    override fun toString() = "$TAG(id='$id', name='$name', description=$description, place=$place)"
}
