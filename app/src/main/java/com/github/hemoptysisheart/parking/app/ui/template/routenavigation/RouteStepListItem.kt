package com.github.hemoptysisheart.parking.app.ui.template.routenavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.Distance
import com.github.hemoptysisheart.parking.app.ui.molecule.Duration
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.resource.ManeuverRes
import com.github.hemoptysisheart.parking.domain.route.RouteStep
import com.ireward.htmlcompose.HtmlText

@Composable
fun RouteStepListItem(step: RouteStep) {
    val res = step.maneuver?.let { ManeuverRes[it] }

    if (null == res) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.size(40.dp))
            Column(
                    modifier = Modifier
                            .weight(1F)
                            .padding(10.dp)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Text("", Modifier.weight(3F))
                    Distance(
                            distance = step.distance ?: 0L,
                            modifier = Modifier
                                    .weight(1F)
                                    .padding(3.dp),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                    Duration(
                            duration = step.duration ?: java.time.Duration.ZERO,
                            modifier = Modifier
                                    .weight(1F)
                                    .padding(3.dp),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                }
                HtmlText(
                        text = step.guide,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.onSurface)
                )

                Row(
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    TextBodyMedium(
                            text = step.start.toSimpleString(),
                            modifier = Modifier.weight(1F),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                    TextBodyMedium("➡️")
                    TextBodyMedium(
                            text = step.end.toSimpleString(),
                            modifier = Modifier.weight(1F),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                }
            }
        }
    } else {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                    painter = painterResource(res.icon),
                    contentDescription = stringResource(res.label),
                    tint = MaterialTheme.colorScheme.onSurface
            )
            Column(
                    modifier = Modifier
                            .weight(1F)
                            .padding(10.dp)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    TextLabelMedium(
                            text = stringResource(res.label),
                            modifier = Modifier
                                    .weight(3F)
                                    .padding(0.dp, 3.dp),
                            color = MaterialTheme.colorScheme.onSurface
                    )
                    Distance(
                            distance = step.distance ?: 0L,
                            modifier = Modifier
                                    .weight(1F)
                                    .padding(3.dp),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                    Duration(
                            duration = step.duration ?: java.time.Duration.ZERO,
                            modifier = Modifier
                                    .weight(1F)
                                    .padding(3.dp),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                }
                HtmlText(
                        text = step.guide,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.onSurface)
                )
                Row(
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    TextBodyMedium(
                            text = step.start.toSimpleString(),
                            modifier = Modifier.weight(1F),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                    TextBodyMedium("➡️")
                    TextBodyMedium(
                            text = step.end.toSimpleString(),
                            modifier = Modifier.weight(1F),
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
@ComponentPreview
fun Preview_RouteStepListItem() {
    ComponentPreviewContainer {
        // RouteStepListItem()
    }
}
