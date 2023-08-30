package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.SettingsInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.Divider
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.setting.Header
import com.github.hemoptysisheart.parking.app.ui.template.setting.SettingItem

/**
 * `main/settings`
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54310-34798&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54406-992&mode=design
 */
@Composable
fun SettingsPageContent(interaction: SettingsInteraction) {
    Header(R.string.page_settings_title, interaction::goBack)
    Column(
            modifier = Modifier
                    .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        SettingItem(text = R.string.page_search_setting_title, onClick = interaction::gotoSearchSetting)
        Divider()
        SettingItem(text = R.string.page_wizard_title, onClick = interaction::gotoWizard)
        // Divider()
        // SettingItem(text = R.string.page_developer_setting_title, onClick = interaction::gotoDeveloperSetting)
        // Divider()
        // SettingItem(text = R.string.page_about_app_title, onClick = interaction::gotoAboutApp)
    }
}


@Composable
@PagePreview
//@Preview(showSystemUi = true)
fun Preview_SettingsPageContent() {
    PagePreviewContainer {
        SettingsPageContent(SettingsInteraction(it))
    }
}
