package com.github.hemoptysisheart.parking.core.model.dto

import com.github.hemoptysisheart.parking.core.client.google.dto.PlaceDto
import com.github.hemoptysisheart.parking.domain.RecommendItem

/**
 * Google Places API 검색 결과용 추천 정보.
 */
class RecommendItemGmpPlace(
    override val item: PlaceDto
) : RecommendItem<PlaceDto> {
    companion object {
        private val TAG = PlaceDto::class.simpleName!!
    }

    /**
     * 추천정보 표시에 사용할 수 있는 내용 목록.
     * 이 중에서 `null`이 아닌 것을 찾아서 사용한다.
     */
    private val contents = listOf(
        item.name,
        item.formattedAddress,
        item.vicinity,
        item.geometry?.location.toString()
    )

    override val id = "$TAG:${item.placeId}"

    /**
     * TODO [contents]에서 필요한 내용을 찾지 못했을 때 사용할 문자열 리소스로 빼기.
     */
    override val summary = contents.firstOrNull { null != it }
        ?: "No summary"

    override val detail: String?
        get() {
            val idx = contents.indexOfFirst { null != it }
            return if (idx < contents.size - 1) {
                contents.subList(idx + 1, contents.size)
                    .firstOrNull { null != it }
            } else {
                null
            }
        }

    override fun equals(other: Any?) = this === other ||
            null != other &&
            other is RecommendItemGmpPlace &&
            id == other.id

    override fun hashCode() = id.hashCode()

    override fun toString() = "$TAG(id='$id', summary='$summary', detail=$detail, item=$item)"
}