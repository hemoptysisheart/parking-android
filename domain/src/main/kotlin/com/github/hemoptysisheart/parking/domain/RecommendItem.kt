package com.github.hemoptysisheart.parking.domain

import com.github.hemoptysisheart.util.RegexValidator

/**
 * 추천 항목.
 */
interface RecommendItem<T> {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        /**
         * 유효한 [id] 형식.
         */
        const val ID_PATTERN = "\\S+/\\S+"

        /**
         * 유효한 [id] 정규 표현식.
         */
        val ID_REGEX = ID_PATTERN.toRegex()

        val ID_VALIDATOR = RegexValidator(ID_REGEX)
    }

    /**
     * 추천 항목의 ID.
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

    /**
     * 추천 내용.
     */
    val item: T
}