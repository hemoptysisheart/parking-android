package com.github.hemoptysisheart.parking.app.ui.resource

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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

@Composable
fun drawableResource(@DrawableRes id: Int): Drawable {
    val context = LocalContext.current

    return context.getDrawable(id)
            ?: throw IllegalArgumentException("drawable does not exist.")
}
