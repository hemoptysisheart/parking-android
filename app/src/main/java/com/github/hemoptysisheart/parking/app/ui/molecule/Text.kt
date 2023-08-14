package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.theme.Typography

/**
 * [`text/display/large`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-573&mode=design)
 */
@Composable
fun TextDisplayLarge(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.displayLarge
    )
}

/**
 * [`text/display/medium`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-574&mode=design)
 */
@Composable
fun TextDisplayMedium(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.displayMedium
    )
}

/**
 * [`text/display/small`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-575&mode=design)
 */
@Composable
fun TextDisplaySmall(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.displaySmall
    )
}

/**
 * [`style/headline/large`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-569&mode=design)
 */
@Composable
fun TextHeadlineLarge(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.headlineLarge
    )
}

/**
 * [`style/headline/medium`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-570&mode=design)
 */
@Composable
fun TextHeadlineMedium(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.headlineMedium
    )
}

/**
 * [`style/headline/small`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-571&mode=design)
 */
@Composable
fun TextHeadlineSmall(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.headlineSmall
    )
}

/**
 * [`text/title/large`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-559&mode=design)
 */
@Composable
fun TextTitleLarge(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.titleLarge
    )
}

/**
 * [`style/title/medium`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-562&mode=design)
 */
@Composable
fun TextTitleMedium(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.titleMedium
    )
}

/**
 * [`style/title/small`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-565&mode=design)
 */
@Composable
fun TextTitleSmall(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.titleSmall
    )
}

/**
 * [`text/label/large`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-532&mode=design)
 */
@Composable
fun TextLabelLarge(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.labelLarge
    )
}

/**
 * [`text/label/medium`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-531&mode=design)
 */
@Composable
fun TextLabelMedium(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.labelMedium
    )
}

/**
 * [`text/label/small`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54321-530&mode=design)
 */
@Composable
fun TextLabelSmall(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.labelSmall
    )
}

/**
 * [`text/body/large`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54320-746&mode=design)
 */
@Composable
fun TextBodyLarge(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.bodyLarge
    )
}

/**
 * [`text/body/medium`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54320-747&mode=design)
 */
@Composable
fun TextBodyMedium(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.bodyMedium
    )
}

/**
 * [`text/body/small`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54320-748&mode=design)
 */
@Composable
fun TextBodySmall(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        textAlign: TextAlign? = null,
        overflow: TextOverflow = TextOverflow.Clip,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1
) {
    Text(
            text = text,
            modifier = modifier,
            color = color,
            fontWeight = fontWeight,
            textAlign = textAlign,
            overflow = overflow,
            maxLines = maxLines,
            minLines = minLines,
            style = Typography.bodySmall
    )
}

@Composable
@ComponentPreview
fun TextDisplay() {
    ComponentPreviewContainer {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            TextDisplayLarge(text = "Display Large", color = MaterialTheme.colorScheme.onBackground)
            TextDisplayMedium(text = "Display Medium", color = MaterialTheme.colorScheme.onBackground)
            TextDisplaySmall(text = "Display Small", color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
@ComponentPreview
fun TextHeadline() {
    ComponentPreviewContainer {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            TextHeadlineLarge(text = "Headline Large", color = MaterialTheme.colorScheme.onBackground)
            TextHeadlineMedium(text = "Headline Medium", color = MaterialTheme.colorScheme.onBackground)
            TextHeadlineSmall(text = "Headline Small", color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
@ComponentPreview
fun TextTitle() {
    ComponentPreviewContainer {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            TextTitleLarge(text = "Title Large", color = MaterialTheme.colorScheme.onBackground)
            TextTitleMedium(text = "Title Medium", color = MaterialTheme.colorScheme.onBackground)
            TextTitleSmall(text = "Title Small", color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
@ComponentPreview
fun TextLabel() {
    ComponentPreviewContainer {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            TextLabelLarge(text = "Label Large", color = MaterialTheme.colorScheme.onBackground)
            TextLabelMedium(text = "Label Medium", color = MaterialTheme.colorScheme.onBackground)
            TextLabelSmall(text = "Label Small", color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
@ComponentPreview
fun TextBody() {
    ComponentPreviewContainer {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            TextBodyLarge(text = "Body Large", color = MaterialTheme.colorScheme.onBackground)
            TextBodyMedium(text = "Body Medium", color = MaterialTheme.colorScheme.onBackground)
            TextBodySmall(text = "Body Small", color = MaterialTheme.colorScheme.onBackground)
        }
    }
}
