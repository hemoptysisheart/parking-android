package com.github.hemoptysisheart.util

object NumberValidators {
    val LONG_NOT_NEGATIVE_VALIDATOR: Validator<Long> = object : Validator<Long> {
        override fun validate(value: Long) = when {
            0L > value ->
                throw ValidationFailException("value is negative : value=$value")
            else ->
                value
        }
    }

    val LONG_POSITIVE_VALIDATOR: Validator<Long> = object : Validator<Long> {
        override fun validate(value: Long): Long = when {
            0L > value ->
                throw ValidationFailException("value is negative : value=$value")
            0L == value ->
                throw ValidationFailException("value is zero : value=$value")
            else ->
                value
        }
    }

    /**
     * 위도 검증기.
     */
    @Deprecated("deprecated")
    val LATITUDE_VALIDATOR = RangeValidator(min = -90.0, max = 90.0, includeMin = true, includeMax = true)

    /**
     * 경도 검증기
     */
    @Deprecated("deprecated")
    val LONGITUDE_VALIDATOR = RangeValidator(min = -180.0, max = 180.0, includeMin = true, includeMax = true)
}