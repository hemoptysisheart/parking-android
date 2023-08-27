package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer

/**
 */
@Composable
fun SelectRoutePageContent(interaction: SelectRouteInteraction) {

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = """
                주차장을 거쳐가는 경로를 비교해보고 선택할 수 있다.
            """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
        )

        EasyButton(onClick = interaction::goBack, label = "돌아가기")
        EasyButton(onClick = interaction::gotoRouteNavigation, label = "안내 시작")
    }
}


@Composable
@ComponentPreview
fun Preview_SelectRoutePageContent() {
    ComponentPreviewContainer {
        SelectRoutePageContent(SelectRouteInteraction(it))
    }
}
