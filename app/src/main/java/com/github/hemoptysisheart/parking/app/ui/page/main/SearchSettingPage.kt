package com.github.hemoptysisheart.parking.app.ui.page.main

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.SearchSettingInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.InputDropdown
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewPage
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.template.setting.DistanceSetting
import com.github.hemoptysisheart.parking.app.ui.template.setting.SettingItemDetail
import com.github.hemoptysisheart.parking.app.viewmodel.DistanceSettingViewModelet
import com.github.hemoptysisheart.parking.app.viewmodel.main.SearchSettingViewModel
import com.github.hemoptysisheart.parking.core.domain.common.NullLocale
import com.github.hemoptysisheart.parking.core.domain.common.SystemLocale
import com.github.hemoptysisheart.parking.domain.common.Locale

@Composable
fun SearchSettingPage(
        interaction: SearchSettingInteraction,
        viewModel: SearchSettingViewModel = hiltBaseViewModel()
) {
    SearchSettingPage(
            interaction = interaction,
            destination = viewModel.destination,
            parking = viewModel.parking,
            language = viewModel.language.collect(),
            onChangeLanguage = viewModel::onChangeLanguage
    )
}

@Composable
internal fun SearchSettingPage(
        interaction: SearchSettingInteraction,
        destination: DistanceSettingViewModelet,
        parking: DistanceSettingViewModelet,
        language: Locale,
        onChangeLanguage: (Locale) -> Unit = { }
) {
    var languageExpand by remember { mutableStateOf(false) }

    SettingItemDetail(
            title = R.string.template_setting_item_distance_title,
            onBack = interaction::goBack
    ) {
        DistanceSetting(destination)
        Divider(Modifier.padding(10.dp, 20.dp))
        DistanceSetting(parking)
        Divider(Modifier.padding(10.dp, 20.dp))
        InputDropdown(
                label = "검색 언어",
                selected = language,
                values = listOf(
                        NullLocale to "(미지정)",
                        SystemLocale to "OS 설정"
                ),
                expanded = languageExpand,
                onToggleExpendRequest = { languageExpand = it },
                onValueSelected = {
                    if (null != it) {
                        onChangeLanguage(it)
                    }
                    languageExpand = false
                }
        )

        Divider(Modifier.padding(10.dp, 20.dp))
        Text(
                text = """
                - 검색 언어
                    - 위치 기반
                    - 지정
                - 검색 결과 없을 때 재검색 여부
                - 날짜 포맷
            """.trimIndent(),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onBackground
        )
        Divider(Modifier.padding(10.dp, 20.dp))
        (1..20).forEach { Text(text = "$it", color = MaterialTheme.colorScheme.onBackground) }
    }
}

@Composable
@Preview(name = "light theme", showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
fun PreviewApp_SearchSettingPage() {
    PreviewPage {
        SearchSettingPage(SearchSettingInteraction(it))
    }
}
