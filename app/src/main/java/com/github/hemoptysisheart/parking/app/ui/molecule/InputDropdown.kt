package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.preview.LOGGER_PREVIEW
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewComponent
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

@Composable
fun <E> InputDropdown(
        label: String,
        selected: E?,
        values: List<Pair<out E?, String>>,
        expanded: Boolean,
        onToggleExpendRequest: (Boolean) -> Unit,
        onValueChanged: (E?) -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        selectedUi: @Composable ((E?) -> Unit)? = null,
        itemUi: @Composable ((String) -> Unit)? = null
) {
    Row(
            modifier = modifier
                    .clickable {
                        if (enabled) {
                            onToggleExpendRequest(!expanded)
                        }
                    },
            verticalAlignment = Alignment.CenterVertically
    ) {
        TextLabelMedium(text = label, modifier = Modifier.weight(1F))
        Spacer(modifier = Modifier.width(10.dp))
        OutlinedTextField(
                value = values.first { it.first == selected }.second,
                onValueChange = { },
                enabled = true,
                readOnly = true,
                placeholder = if (selectedUi == null) {
                    { TextBodyMedium(text = values.first { it.first == selected }.second) }
                } else {
                    { selectedUi(selected) }
                },
                trailingIcon = {
                    if (expanded) {
                        DropUpButton()
                    } else {
                        DropDownButton()
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface,
                        focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface,
                        disabledPlaceholderColor = MaterialTheme.colorScheme.onSurface
                )
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { onToggleExpendRequest(false) }) {
            values.forEach {
                DropdownMenuItem(
                        text = {
                            if (itemUi == null) {
                                TextLabelMedium(it.second)
                            } else {
                                itemUi(it.second)
                            }
                        },
                        onClick = { onValueChanged(it.first) }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_InputDropdown() {
    var expanded by remember {
        mutableStateOf(false)
    }
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
    var selected by remember {
        mutableStateOf(values.random().first)
    }

    PreviewComponent {
        Column(Modifier.padding(10.dp)) {
            InputDropdown(
                    label = "dropdown 입력",
                    selected = null,
                    values = values,
                    expanded = expanded,
                    onToggleExpendRequest = {
                        LOGGER_PREVIEW.d("#onToggleExpendRequest args : expend=$it")
                        expanded = it
                    },
                    onValueChanged = {
                        LOGGER_PREVIEW.d("#onValueChanged args : value=$it")
                        selected = it
                    }
            )

            Divider(modifier = Modifier.padding(10.dp, 15.dp), thickness = 1.dp)

            InputDropdown(
                    label = "dropdown 입력",
                    selected = selected,
                    values = values,
                    expanded = expanded,
                    onToggleExpendRequest = {
                        LOGGER_PREVIEW.v("#onToggleExpendRequest args : expend=$it")
                        expanded = it
                    },
                    onValueChanged = {
                        LOGGER_PREVIEW.d("#onValueChanged args : value=$it")
                        selected = it
                    }
            )
        }
    }
}
