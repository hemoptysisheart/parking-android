package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.SearchSettingInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.InputDropdown
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
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
    }
}

@Composable
@PagePreview
fun PreviewApp_SearchSettingPage() {
    PagePreviewContainer {
        SearchSettingPage(SearchSettingInteraction(it))
    }
}