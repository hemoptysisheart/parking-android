package com.github.hemoptysisheart.util

import java.math.BigDecimal
import java.math.BigInteger

@Suppress("UNCHECKED_CAST")
inline fun <reified N : Number> nonNegative(value: N): NonNegative<N> = when (value) {
    is Int -> NonNegativeInt(value)
    is Long -> NonNegativeLong(value)
    is Float -> NonNegativeFloat(value)
    is Double -> NonNegativeDouble(value)
    is BigInteger -> NonNegativeBigInteger(value)
    is BigDecimal -> NonNegativeBigDecimal(value)
    else -> NonNegativeNumber(value)
} as NonNegative<N>

interface NonNegative<N> {
    val value: N
}

@JvmInline
value class NonNegativeNumber(
        override val value: Number
) : NonNegative<Number> {
    init {
        if (0.0 > value.toDouble()) {
            throw IllegalArgumentException("value is negative : value=$value")
        }
    }
}

@JvmInline
value class NonNegativeInt(
        override val value: Int
) : NonNegative<Int> {
    init {
        if (0 > value) {
            throw IllegalArgumentException("value is negative : value=$value")
        }
    }
}

@JvmInline
value class NonNegativeLong(
        override val value: Long
) : NonNegative<Long> {
    init {
        if (0L > value) {
            throw IllegalArgumentException("value is negative : value=$value")
        }
    }
}

@JvmInline
value class NonNegativeFloat(
        override val value: Float
) : NonNegative<Float> {
    init {
        if (0F > value) {
            throw IllegalArgumentException("value is negative : value=$value")
        }
    }
}

@JvmInline
value class NonNegativeDouble(
        override val value: Double
) : NonNegative<Double> {
    init {
        if (0.0 > value) {
            throw IllegalArgumentException("value is negative : value=$value")
        }
    }
}

@JvmInline
value class NonNegativeBigInteger(
        override val value: BigInteger
) : NonNegative<BigInteger> {
    init {
        if (BigInteger.ZERO > value) {
            throw IllegalArgumentException("value is negative : value=$value")
        }
    }
}

@JvmInline
value class NonNegativeBigDecimal(
        override val value: BigDecimal
) : NonNegative<BigDecimal> {
    init {
        if (BigDecimal.ZERO > value) {
            throw IllegalArgumentException("value is negative : value=$value")
        }
    }
}
