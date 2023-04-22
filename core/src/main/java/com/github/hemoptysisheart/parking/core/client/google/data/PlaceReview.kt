package com.github.hemoptysisheart.parking.core.client.google.data

import java.net.URL
import java.time.Instant
import java.util.*

data class PlaceReview(
    val authorName: String,
    val rating: Double,
    val relativeTimeDescription: String,
    val time: Instant,
    val author: URL? = null,
    val language: Locale? = null,
    val originalLanguage: Locale? = null,
    val profilePhoto: URL? = null,
    val text: String? = null,
    val translated: Boolean = false
)
