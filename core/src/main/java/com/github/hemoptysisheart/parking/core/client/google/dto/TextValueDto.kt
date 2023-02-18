package com.github.hemoptysisheart.parking.core.client.google.dto

data class TextValueDto(
    val text: String?,
    val number: Double?
) {
    init {
        when {
            !text.isNullOrEmpty() && null != number ->
                throw IllegalArgumentException("can not set both : text=$text, number=$number")
        }
    }
}
