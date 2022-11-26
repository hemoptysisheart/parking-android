package com.github.hemoptysisheart.util

/**
 * 인스턴스가 사용할 수 있는지 검사한다.
 */
interface Validator<T> {
    /**
     * @param value 검사할 인스턴스.
     * @return `value` 인스턴스.
     * @throws ValidationFailException 사용할 수 없을 때.
     */
    @Throws(ValidationFailException::class)
    fun validate(value: T): T
}