package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R.string.page_search_setting_search_language
import com.github.hemoptysisheart.parking.R.string.page_search_setting_title
import com.github.hemoptysisheart.parking.app.interaction.main.SearchSettingInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.InputDropdown
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.previewSearchSettingViewModel
import com.github.hemoptysisheart.parking.app.ui.resource.LocaleRes
import com.github.hemoptysisheart.parking.app.ui.support.collect
import com.github.hemoptysisheart.parking.app.ui.support.hiltBaseViewModel
import com.github.hemoptysisheart.parking.app.ui.template.setting.Distance
import com.github.hemoptysisheart.parking.app.ui.template.setting.SettingItemDetail
import com.github.hemoptysisheart.parking.app.viewmodel.main.DistanceSettingViewModelet
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
            title = page_search_setting_title,
            onBack = interaction::goBack
    ) {
        Distance(destination)
        Divider(Modifier.padding(10.dp, 20.dp))
        Distance(parking)
        Divider(Modifier.padding(10.dp, 20.dp))
        InputDropdown(
                label = stringResource(page_search_setting_search_language),
                selected = language,
                values = listOf(NullLocale, SystemLocale).map {
                    it to stringResource(LocaleRes[it].languageLabel)
                },
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
        SearchSettingPage(SearchSettingInteraction(it), previewSearchSettingViewModel())
    }
}
