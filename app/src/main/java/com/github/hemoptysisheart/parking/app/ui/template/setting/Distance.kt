package com.github.hemoptysisheart.parking.app.ui.template.setting

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.support.KEYBOARD_NUMBER
import com.github.hemoptysisheart.parking.app.ui.molecule.InputDropdown
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelLarge
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.resource.DistanceUnitRes
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.theme.Typography
import com.github.hemoptysisheart.parking.app.viewmodel.DistanceSettingViewModelet
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit
import com.github.hemoptysisheart.util.NonNegativeInt
import java.util.UUID

/**
 * [`setting/search/distance`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54316-25212&mode=design)
 */
@Composable
fun Distance(viewModelet: DistanceSettingViewModelet) {
    Distance(
            key = viewModelet.key,
            label = viewModelet.label,
            description = viewModelet.description,
            enable = viewModelet.enable.collect(),
            distance = viewModelet.distance.collect(),
            unit = viewModelet.unit.collect(),
            distanceRange = viewModelet.distanceRange,
            onToggleEnable = viewModelet::onToggleEnable,
            onChangeDistance = viewModelet::onChangeDistance,
            onChangeUnit = viewModelet::onChangeUnit
    )
}

/**
 * [`setting/search/distance`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54316-25212&mode=design)
 */
@Composable
fun Distance(
        key: UUID,
        @StringRes label: Int,
        @StringRes description: Int,
        enable: Boolean,
        distance: NonNegativeInt,
        unit: DistanceUnit,
        distanceRange: IntRange,
        onToggleEnable: (Boolean) -> Unit = {},
        onChangeDistance: (String) -> Unit = {},
        onChangeUnit: (DistanceUnit?) -> Unit = {}
) {
    var expand by remember(key) { mutableStateOf(false) }

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Row(
                modifier = Modifier.padding(0.dp, 5.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            TextLabelLarge(
                    text = stringResource(id = label),
                    modifier = Modifier.weight(1F),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
            )
            Switch(checked = enable, onCheckedChange = onToggleEnable)
        }
        TextBodyMedium(
                text = stringResource(description, DistanceUnitRes[unit].format(distance.value), unit.label),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5F)
        )
        Row(
                modifier = Modifier.padding(0.dp, 5.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                    value = DistanceUnitRes[unit].format(distance.value),
                    onValueChange = onChangeDistance,
                    modifier = Modifier.weight(1F),
                    enabled = enable,
                    textStyle = Typography.labelLarge.copy(textAlign = TextAlign.End),
                    keyboardOptions = KEYBOARD_NUMBER,
                    colors = OutlinedTextFieldDefaults.colors()
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
        Slider(
                value = distance.value.toFloat(),
                onValueChange = {
                    onChangeDistance("${it.toInt()}")
                },
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 5.dp),
                enabled = enable,
                valueRange = distanceRange.first.toFloat()..distanceRange.last.toFloat()
        )
    }
}

@Composable
@ComponentPreview
fun Preview_Distance() {
    ComponentPreviewContainer {
        Distance(
                DistanceSettingViewModelet(
                        previewBaseViewModel(),
                        true,
                        NonNegativeInt(123456789),
                        DistanceUnit.values().random(),
                        R.string.preview_template_distance_setting_label,
                        R.string.preview_template_distance_setting_description,
                        NonNegativeInt(12345),
                        0..Int.MAX_VALUE
                )
        )
    }
}
