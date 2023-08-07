package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

@Composable
fun <E> InputDropdown(
        label: String?,
        selected: E?,
        values: List<Pair<E?, String>>,
        expanded: Boolean,
        onToggleExpendRequest: (Boolean) -> Unit,
        onValueSelected: (E?) -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true
) {
    Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
    ) {
        label?.run {
            TextLabelMedium(
                    text = this,
                    modifier = Modifier.weight(1F),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(10.dp))
        }

        Column(horizontalAlignment = Alignment.End) {
            OutlinedButton(
                    onClick = { onToggleExpendRequest(!expanded) },
                    enabled = enabled
            ) {
                TextBodyMedium(text = values.first { it.first == selected }.second)

                if (expanded) {
                    Icon(imageVector = Icons.Default.ArrowDropUp, contentDescription = null)
                } else {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }

            DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { onToggleExpendRequest(false) }
            ) {
                values.forEach {
                    DropdownMenuItem(
                            text = { TextLabelMedium(text = it.second) },
                            onClick = {
                                onValueSelected(it.first)
                                onToggleExpendRequest(false)
                            }
                    )
                }
            }
        }
    }
}

@Composable
@ComponentPreview
fun Preview_InputDropdown() {
    val values = listOf<Pair<TemporalUnit?, String>>(
            null to "(미설정)",
            ChronoUnit.CENTURIES to "세기",
            ChronoUnit.YEARS to "년",
            ChronoUnit.MONTHS to "월",
            ChronoUnit.DAYS to "일",
            ChronoUnit.HOURS to "시",
            ChronoUnit.MINUTES to "분",
            ChronoUnit.SECONDS to "초"
    )

    ComponentPreviewContainer {
        var expanded by remember { mutableStateOf(false) }
        var selected by remember { mutableStateOf<TemporalUnit?>(null) }
        InputDropdown(
                label = "dropdown 입력",
                selected = selected,
                values = values,
                expanded = expanded,
                onToggleExpendRequest = { expanded = it },
                onValueSelected = { selected = it }
        )
    }
}
