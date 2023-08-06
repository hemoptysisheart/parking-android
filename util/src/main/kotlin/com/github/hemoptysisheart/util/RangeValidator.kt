package com.github.hemoptysisheart.util

@Suppress("MemberVisibilityCanBePrivate")
open class RangeValidator<T : Comparable<T>>(
        val min: T,
        val max: T,
        val includeMin: Boolean = true,
        val includeMax: Boolean = false
) : Validator<T> {
    override fun validate(value: T): T {
        if (includeMin) {
            if (min > value) {
                throw ValidationFailException("value less than min : value=$value, min=$min")
            }
        } else {
            if (min >= value) {
                throw ValidationFailException("value less than or equal to min : value=$value, min=$min")
            }
        }

        if (includeMax) {
            if (max < value) {
                throw ValidationFailException("value greater than max : value=$value, max=$max")
            }
        } else {
            if (max <= value) {
                throw ValidationFailException("value greater than or equal to max : value=$value, max=$max")
            }
        }

        return value
    }

    override fun toString() =
            "${RangeValidator::class.simpleName}(min=$min, max=$max, includeMin=$includeMin, includeMax=$includeMax)"
}