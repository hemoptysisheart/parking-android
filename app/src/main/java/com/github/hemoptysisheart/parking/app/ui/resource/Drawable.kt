package com.github.hemoptysisheart.parking.app.ui.resource

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

@Composable
fun Drawable.toBitmapDescriptor(): BitmapDescriptor {
    setBounds(0, 0, intrinsicWidth, intrinsicHeight)
    val bm = Bitmap.createBitmap(
            intrinsicWidth,
            intrinsicHeight,
            Bitmap.Config.ARGB_8888
    )

    val canvas = android.graphics.Canvas(bm)
    draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}
