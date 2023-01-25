package com.github.hemoptysisheart.parking.domain

/**
 * 추천 항목.
 */
interface RecommendItem<T> {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        /**
         * 유효한 [id] 형식.
         */
        const val ID_PATTERN = "\\S+"

        /**
         * 유효한 [id] 정규 표현식.
         */
        val ID_REGEX = ID_PATTERN.toRegex()
    }

    /**
     * 추천 항목의 ID.
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

    /**
     * 추천 내용.
     */
    val item: T
}