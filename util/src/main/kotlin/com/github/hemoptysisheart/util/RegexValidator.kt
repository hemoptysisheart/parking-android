package com.github.hemoptysisheart.util

class RegexValidator(
    val regex: Regex
) : Validator<String> {
    constructor(pattern: String) : this(pattern.toRegex())

    override fun validate(text: String) = if (!regex.matches(text)) {
        throw ValidationFailException("text does not match : text='$text', regex=$regex")
    } else {
        text
    }

    override fun toString() = "${RegexValidator::class.simpleName}(regex=$regex)"
}