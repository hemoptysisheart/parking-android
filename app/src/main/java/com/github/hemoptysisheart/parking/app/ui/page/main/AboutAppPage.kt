package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.runtime.Composable
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.AboutAppInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.setting.Header

@Composable
fun AboutAppPage(
        interaction: AboutAppInteraction
) {
    Header(title = R.string.page_about_app_title, onClickBack = interaction::goBack)
}


@Composable
@PagePreview
fun Preview_AboutAppPage() {
    PagePreviewContainer {
        AboutAppPage(AboutAppInteraction(it))
    }
}
