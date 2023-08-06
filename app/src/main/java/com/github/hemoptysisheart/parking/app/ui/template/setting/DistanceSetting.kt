package com.github.hemoptysisheart.parking.app.ui.template.setting

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.InputDropdown
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewComponent
import com.github.hemoptysisheart.parking.app.ui.preview.previewDistanceSettingState
import com.github.hemoptysisheart.parking.app.ui.state.setting.DistanceSettingState
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt
import java.util.UUID

@Composable
fun DistanceSetting(
        state: DistanceSettingState,
        onToggleEnable: (Boolean) -> Unit = {},
        onChangeDistance: (String) -> Unit = {},
        onChangeUnit: (DistanceUnit?) -> Unit = {}
) {
    var expand by remember(DistanceSettingState::class, state.key) { mutableStateOf(false) }

    Column(modifier = Modifier.padding(20.dp, 10.dp)) {
        Row(
                modifier = Modifier.padding(0.dp, 5.dp),
                verticalAlignment = Alignment.CenterVertically) {
            TextLabelMedium(text = stringResource(id = state.label), modifier = Modifier.weight(1F))
            Switch(checked = state.enable, onCheckedChange = onToggleEnable)
        }
        state.description?.run {
            TextBodyMedium(
                    text = stringResource(this, state.distance?.value ?: 0, state.unit.label),
                    color = MaterialTheme.colorScheme.onSurface)
        }
        Row(
                modifier = Modifier.padding(0.dp, 5.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                    value = "${state.distance?.value ?: ""}",
                    onValueChange = onChangeDistance,
                    modifier = Modifier.weight(1F),
                    enabled = state.enable
            )
            Spacer(modifier = Modifier.width(10.dp))
            InputDropdown(
                    label = null,
                    selected = state.unit,
                    values = DistanceUnit.values().map { it to it.label },
                    expanded = expand,
                    onToggleExpendRequest = {
                        expand = it
                    },
                    onValueSelected = { onChangeUnit(it) },
                    enabled = state.enable
            )
        }
    }
}

@Composable
fun DistanceSetting(
        key: UUID,
        @StringRes label: Int,
        @StringRes description: Int?,
        enable: Boolean,
        distance: NonNegativeInt,
        unit: DistanceUnit,
        onToggleEnable: (Boolean) -> Unit = {},
        onChangeDistance: (String) -> Unit = {},
        onChangeUnit: (DistanceUnit?) -> Unit = {}
) {
    var expand by remember(DistanceSettingState::class, key) { mutableStateOf(false) }

    Column(modifier = Modifier.padding(20.dp, 10.dp)) {
        Row(
                modifier = Modifier.padding(0.dp, 5.dp),
                verticalAlignment = Alignment.CenterVertically) {
            TextLabelMedium(text = stringResource(id = label), modifier = Modifier.weight(1F))
            Switch(checked = enable, onCheckedChange = onToggleEnable)
        }
        description?.run {
            TextBodyMedium(
                    text = stringResource(this, distance.value ?: 0, unit.label),
                    color = MaterialTheme.colorScheme.onSurface)
        }
        Row(
                modifier = Modifier.padding(0.dp, 5.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                    value = "${distance.value}",
                    onValueChange = onChangeDistance,
                    modifier = Modifier.weight(1F),
                    enabled = enable
            )
            Spacer(modifier = Modifier.width(10.dp))
            InputDropdown(
                    label = null,
                    selected = unit,
                    values = DistanceUnit.values().map { it to it.label },
                    expanded = expand,
                    onToggleExpendRequest = {
                        expand = it
                    },
                    onValueSelected = { onChangeUnit(it) },
                    enabled = enable
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_DistanceSetting() {
    PreviewComponent {
        DistanceSetting(previewDistanceSettingState())
    }
}
