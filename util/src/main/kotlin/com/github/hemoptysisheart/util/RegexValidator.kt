package com.github.hemoptysisheart.util

class RegexValidator(
    val regex: Regex
) : Validator<String> {
    constructor(pattern: String) : this(pattern.toRegex())

    override fun validate(value: String) = if (!regex.matches(value)) {
        throw ValidationFailException("text does not match : value='$value', regex=$regex")
    } else {
        value
    }

    override fun toString() = "${RegexValidator::class.simpleName}(regex=$regex)"
}