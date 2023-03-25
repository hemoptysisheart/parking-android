package com.github.hemoptysisheart.parking.app.ui.support

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_SUPPORT as LOGGER

/**
 * 이미지 리소스를 구글 맵에서 쓸 수 있는 [BitmapDescriptor]로 변환한다.
 *
 * @param context 언제나 `LocalContext.current`.
 * @param drawableId `R.drawable`중 하나.
 */
fun bitmapDescriptor(context: Context, @DrawableRes drawableId: Int): BitmapDescriptor {
    Log.v("resource", "#bitmapDescriptor args : context=$context, drawableId=$drawableId")

    val bitmap = ContextCompat.getDrawable(context, drawableId)!!.let {
        it.setBounds(0, 0, it.intrinsicWidth, it.intrinsicHeight)

        val bm = Bitmap.createBitmap(it.intrinsicWidth, it.intrinsicHeight, Bitmap.Config.ARGB_8888)!!
        val canvas = Canvas(bm)
        it.draw(canvas)
        bm
    }
    val descriptor = BitmapDescriptorFactory.fromBitmap(bitmap)

    LOGGER.v("#bitmapDescriptor return : $descriptor")
    return descriptor
}