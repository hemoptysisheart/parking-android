package com.github.hemoptysisheart.parking.domain.route

/**
 * 이동수단.
 */
enum class Transportation {
    /**
     * 차량
     */
    DRIVING,

    /**
     * 도보
     */
    WALKING;

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}
