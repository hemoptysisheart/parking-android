package com.github.hemoptysisheart.parking.domain

/**
 * 위치 정보.
 */
interface Location {
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
     * 위치 ID.
     */
    val id: String

    /**
     * 위치 이름.
     */
    val name: String

    /**
     * 설명. 기본 `null`.
     */
    val description: String?
}