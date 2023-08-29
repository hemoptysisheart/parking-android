package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.annotation.StringRes
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.TextUnit
import com.github.hemoptysisheart.parking.R.string.global_duration_hour
import com.github.hemoptysisheart.parking.R.string.global_duration_minute
import com.github.hemoptysisheart.parking.R.string.global_duration_second
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import java.time.Duration

/**
 * [java.time.Duration]
 */
@Composable
fun Duration(
        duration: Duration,
        modifier: Modifier = Modifier,
        separator: String = " ",
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
    val text = listOfNotNull(
            duration.toHoursPart().format(global_duration_hour),
            duration.toMinutesPart().format(global_duration_minute),
            duration.toSecondsPart().format(global_duration_second)
    ).joinToString(separator)
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
private fun Int.format(@StringRes id: Int) = if (0 < this) {
    stringResource(id, this)
} else {
    null
}

@Composable
@ComponentPreview
fun Preview_Duration(@PreviewParameter(DurationParamProvider::class) duration: Duration) {
    ComponentPreviewContainer {
        Duration(duration)
    }
}

class DurationParamProvider : PreviewParameterProvider<Duration> {
    override val values = listOf(
            Duration.ofHours(12),
            Duration.ofMinutes(123),
            Duration.ofSeconds(12345)
    ).asSequence()
}
