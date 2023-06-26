package com.github.hemoptysisheart.parking.domain

/**
 * 추천 항목.
 */
interface RecommendItem {
    /**
     * 추천항목([RecommendItem.item])의 ID.
     *
     * `"[Class 이름]:[item ID]"` 형식.
     */
    val id: String

    /**
     * 요약.
     */
    val summary: String

    /**
     * 상세. 기본 `null`.
     */
    val detail: String?
}