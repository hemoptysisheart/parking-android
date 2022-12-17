package com.github.hemoptysisheart.parking.core.client.google.dto

import java.net.URL
import java.time.Instant
import java.util.*

data class PlaceReviewDto(
    val authorName: String,
    val rating: Double,
    val relativeTimeDescription: String,
    val time: Instant,
    val author: URL?,
    val language: Locale?,
    val originalLanguage: Locale?,
    val profilePhoto: URL?,
    val text: String?,
    val translated: Boolean
)
