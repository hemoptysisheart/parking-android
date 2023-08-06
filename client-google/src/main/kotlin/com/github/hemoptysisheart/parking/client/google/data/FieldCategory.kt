package com.github.hemoptysisheart.parking.client.google.data

enum class FieldCategory(
        val code: String
) {
    /**
     * The Basic category includes the following fields.
     */
    BASIC("Basic"),

    /**
     * The Contact category includes the following fields.
     */
    CONTACT("Contact"),

    /**
     * The Atmosphere category includes the following fields.
     */
    ATMOSPHERE("Atmosphere");

    companion object {
        private val CODE_MAP = values().associateBy { it.code }

        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(code: String) = CODE_MAP[code]!!
    }

    val fields: List<Field> = Field.CATEGORY_GROUP[this]!!
}
