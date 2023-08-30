package com.github.hemoptysisheart.parking.app.ui.molecule

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.TextUnit
import com.github.hemoptysisheart.parking.R.string.global_distance_format_far
import com.github.hemoptysisheart.parking.R.string.global_distance_format_near
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import java.text.DecimalFormat

/**
 * @param distance 거리. meter 단위.
 */
@Composable
fun Distance(
        distance: Long,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onBackground,
        fontSize: TextUnit = TextUnit.Unspecified,
        fontStyle: FontStyle? = null,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        letterSpacing: TextUnit = TextUnit.Unspecified,
        textDecoration: TextDecoration? = null,
        textAlign: TextAlign? = null,
        lineHeight: TextUnit = TextUnit.Unspecified,
        overflow: TextOverflow = TextOverflow.Clip,
        softWrap: Boolean = true,
        onTextLayout: (TextLayoutResult) -> Unit = {},
        style: TextStyle = LocalTextStyle.current
) {
    val text = if (1000 < distance) {
        DecimalFormat(stringResource(global_distance_format_far)).format(distance.toDouble() / 1000L) + " Km"
    } else {
        DecimalFormat(stringResource(global_distance_format_near)).format(distance) + " m"
    }

    Text(
            text,
            modifier,
            color,
            fontSize,
            fontStyle,
            fontWeight,
            fontFamily,
            letterSpacing,
            textDecoration,
            textAlign,
            lineHeight,
            overflow,
            softWrap,
            1,
            1,
            onTextLayout,
            style
    )
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun Preview_Distance(@PreviewParameter(DistanceParamProvider::class) distance: Long) {
    ComponentPreviewContainer {
        Distance(distance)
    }
}

class DistanceParamProvider : PreviewParameterProvider<Long> {
    override val values = listOf(1L, 12L, 123L, 1234L, 12345L, 1234567L).asSequence()
}
