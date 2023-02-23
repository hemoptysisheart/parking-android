package com.github.hemoptysisheart.parking.core.client.google.dto

data class LabeledNumber(
    val label: String?,
    val number: Double?
) {
    init {
        when {
            !label.isNullOrEmpty() && null != number ->
                throw IllegalArgumentException("can not set both : label=$label, number=$number")
        }
    }
}
