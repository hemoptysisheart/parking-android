package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.SearchSettingInteraction
import com.github.hemoptysisheart.parking.app.ui.page.LOGGER
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage
import com.github.hemoptysisheart.parking.app.ui.state.setting.DistanceSettingState
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.template.setting.DistanceSetting
import com.github.hemoptysisheart.parking.app.ui.template.setting.SettingItemDetail
import com.github.hemoptysisheart.parking.app.viewmodel.DistanceSettingViewModelet
import com.github.hemoptysisheart.parking.app.viewmodel.main.SearchSettingViewModel
import com.github.hemoptysisheart.parking.domain.common.DistanceUnit

@Composable
fun SearchSettingPage(
        interaction: SearchSettingInteraction,
        viewModel: SearchSettingViewModel = hiltBaseViewModel()
) {
    LOGGER.v("#SearchSettingPage args : interaction=$interaction")

    val parking by viewModel.parking.collectAsStateWithLifecycle()

    SearchSettingPage(
            interaction = interaction,
            destination = viewModel.destination,
            parking = parking,
            onChangeEnable = viewModel::onChangeEnable,
            onChangeDestinationDistance = viewModel::onChangeDestinationDistance,
            onChangeDestinationDistanceUnit = viewModel::onChangeDestinationDistanceUnit
    )
}

@Composable
internal fun SearchSettingPage(
        interaction: SearchSettingInteraction,
        destination: DistanceSettingViewModelet,
        parking: DistanceSettingState,
        onChangeEnable: (DistanceSettingState, Boolean) -> Unit = { s, b -> },
        onChangeDestinationDistance: (String) -> Unit = { },
        onChangeDestinationDistanceUnit: (DistanceUnit?) -> Unit = { }
) {
    SettingItemDetail(
            title = R.string.template_setting_item_distance_title,
            onBack = interaction::goBack
    ) {
        DistanceSetting(
                destination.key,
                destination.label,
                destination.description,
                destination.enable.collect(),
                destination.distance.collect(),
                destination.unit.collect(),
                onToggleEnable = destination::onChangeEnable,
                onChangeDistance = destination::onChangeDistance,
                onChangeUnit = destination::onChangeUnit
        )

        DistanceSetting(state = parking, onToggleEnable = { onChangeEnable(parking, it) })

        Divider(Modifier.padding(10.dp, 20.dp))

        Text(
                text = """
                - 검색 언어
                    - 미지정
                    - 시스템 언어
                    - 위치 기반
                    - 지정
                - 검색 결과 없을 때 재검색 여부
                - 날짜 포맷
            """.trimIndent(),
                modifier = Modifier.fillMaxWidth()
        )

        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
        Text(text = "aaaaaaaa", Modifier.padding(20.dp))
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_SearchSettingPage() {
    PreviewPage {
        SearchSettingPage(SearchSettingInteraction(it))
    }
}
