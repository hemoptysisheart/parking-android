package com.github.hemoptysisheart.parking.client.google.data

import com.github.hemoptysisheart.parking.client.google.data.*
import java.util.*

data class AutocompleteParams(
        val input: String,
        val radius: Int = RADIUS_DEFAULT,
        val components: List<Locale>? = null,
        val language: Locale? = null,
        val location: LatLng? = null,
        val locationBias: LocationBias? = null,
        val locationRestriction: LocationRestriction? = null,
        val offset: Int? = null,
        val origin: LatLng? = null,
        val region: String? = null,
        val sessionToken: String? = null,
        val strictBounds: Boolean? = null,
        val types: List<PlaceType>? = null
) {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        const val NON_WHITESPACE_PATTERN = "\\S.*"
        val NON_WHITESPACE_REGEX = NON_WHITESPACE_PATTERN.toRegex()

        const val RADIUS_DEFAULT = 50_000
    }

    init {
        when {
            input.isEmpty() ->
                throw IllegalArgumentException("input is empty.")

            !input.matches(NON_WHITESPACE_REGEX) -> {
                throw IllegalArgumentException("illegal input pattern : input=$input, pattern=$NON_WHITESPACE_PATTERN")
            }
        }

        when {
            0 >= radius ->
                throw IllegalArgumentException("radius is not positive : radius=$radius")
        }

        offset?.let {
            if (0 >= it) {
                throw IllegalArgumentException("offset is not positive : offset=$it")
            }
        }

        region?.also {
            when {
                it.isEmpty() ->
                    throw IllegalArgumentException("region is empty.")

                !it.matches(NON_WHITESPACE_REGEX) ->
                    throw IllegalArgumentException("illegal region pattern : region=$region, pattern=$NON_WHITESPACE_PATTERN")
            }
        }

        types?.also {
            when {
                it.isEmpty() ->
                    throw IllegalArgumentException("types is empty.")
            }
        }
    }
}
