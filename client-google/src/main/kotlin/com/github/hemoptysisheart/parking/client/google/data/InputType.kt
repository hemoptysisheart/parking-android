package com.github.hemoptysisheart.parking.client.google.data

enum class InputType(
        val code: String
) {
    TEXT_QUERY("textquery"),
    PHONE_NUMBER("phonenumber");

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)
    }
}
