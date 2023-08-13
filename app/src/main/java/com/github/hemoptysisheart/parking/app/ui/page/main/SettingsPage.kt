package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.app.interaction.main.SettingsInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer

/**
 * `main/settings`
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54310-34798&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54406-992&mode=design
 */
@Composable
fun SettingsPage(interaction: SettingsInteraction) {
    SettingsPageContent(interaction)
}

@Composable
@PagePreview
fun Preview_SettingsPage() {
    PagePreviewContainer {
        SettingsPage(SettingsInteraction(it))
    }
}
