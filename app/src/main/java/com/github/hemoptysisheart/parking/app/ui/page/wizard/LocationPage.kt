package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.wizard.LocationInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.theme.Typography

/**
 * [마법사](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-649)
 */
@Composable
fun LocationPage(interaction: LocationInteraction) {
    LOGGER.v("#LocationPage args : interaction=$interaction")

    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1F))
        Text(
                text = """
                1. 위치정보 권한을 요청한다.
                2. 위치정보를 얻지 못한 경우, 앱 설정으로 안내한다.
                3. 마법사를 종료한다.
                """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                style = Typography.bodyLarge
        )
        EasyButton(onClick = interaction::requestPermission, label = "시스템 위치 권한 요청")
        EasyButton(onClick = interaction::openAppSetting, label = "앱 설정 열기")
        EasyButton(onClick = interaction::close, label = "마법사 종료")
        Spacer(modifier = Modifier.weight(1F))
    }
}

@Composable
@PagePreview
fun Preview_LocationPage() {
    PagePreviewContainer {
        LocationPage(LocationInteraction(it))
    }
}
