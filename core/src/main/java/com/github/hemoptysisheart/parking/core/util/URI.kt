package com.github.hemoptysisheart.parking.core.util

import android.net.Uri
import java.net.URI

fun URI.toUri(): Uri = Uri.fromParts(scheme, "$host$path", fragment)
