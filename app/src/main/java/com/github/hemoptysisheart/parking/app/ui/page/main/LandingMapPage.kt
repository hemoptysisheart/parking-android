package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.app.interaction.main.LandingMapInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.LandingMapViewModel

/**
 * [랜딩 맵](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-645)
 */
@Composable
fun LandingMapPage(
        interaction: LandingMapInteraction,
        viewModel: LandingMapViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#LandingMapPage args : interaction=$interaction, viewModel=$viewModel")

    val count by viewModel.count.collectAsStateWithLifecycle()

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = """
                지도, 현재 위치, 오버레이 표시.
                
                목적지를 선택했을 경우와 비슷한 오버레이를 활용해서 사용자에게 정보를 전달하고 다음 행동을 유도한다.
            """.trimIndent(),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
        )

        EasyButton(onClick = interaction::gotoDestinationSearch, label = "목적지 검색")
        EasyButton(onClick = interaction::gotoSetting, label = "설정")

        Spacer(modifier = Modifier.height(30.dp))

        Text(
                text = "onResume : $count 회", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        EasyButton(onClick = viewModel::onProgress, label = "작업 시작")

        Spacer(modifier = Modifier.height(30.dp))

        EasyButton(onClick = viewModel::onError, label = "에러 발생")
    }
}

@Composable
@Preview(showSystemUi = true)
fun LandingMapPage() {
    PreviewPage {
        LandingMapPage(LandingMapInteraction(it))
    }
}
