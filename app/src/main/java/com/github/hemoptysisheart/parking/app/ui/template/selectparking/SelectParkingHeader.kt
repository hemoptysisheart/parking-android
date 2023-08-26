package com.github.hemoptysisheart.parking.app.ui.template.selectparking

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.SelectParkingInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.BackButton
import com.github.hemoptysisheart.parking.app.ui.molecule.SettingsButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodySmall
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.PLACE_로손편의점_스미요시_2_22
import com.github.hemoptysisheart.parking.domain.place.Place

/**
 * 선택한 목적지에 관한 정보와 지도 조작을 제공한다.
 *
 * 1. TODO 목적지가 지도에 보일 때 혹은 보이지 않을 때 목적지 버튼 강조.
 * 2. TODO 현재 위치가 보일 때 혹은 보이지 않을 때 현재 위치 버튼을 강조.
 */
@Composable
fun SelectParkingHeader(
        interaction: SelectParkingInteraction,
        destination: Place
) {
    Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(onClick = interaction::goBack, color = MaterialTheme.colorScheme.onBackground)
        Column(
                modifier = Modifier
                        .weight(1F)
                        .background(MaterialTheme.colorScheme.background, RoundedCornerShape(30.dp))
                        .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(30.dp))
                        .padding(20.dp, 10.dp),
                verticalArrangement = Arrangement.Center
        ) {
            TextLabelMedium(
                    text = destination.name,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
            )
            TextBodySmall(
                    text = destination.address,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
            )
        }

        SettingsButton(color = MaterialTheme.colorScheme.onBackground, onClick = interaction::gotoSetting)
    }
}


@Composable
@ComponentPreview
@OptIn(ExperimentalComposeUiApi::class)
fun Preview_SelectParkingHeader() {
    ComponentPreviewContainer {
        SelectParkingHeader(SelectParkingInteraction(it), PLACE_로손편의점_스미요시_2_22)
    }
}