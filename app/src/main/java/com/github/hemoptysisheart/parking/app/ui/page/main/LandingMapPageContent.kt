package com.github.hemoptysisheart.parking.app.ui.page.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.main.LandingMapInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.GEOLOCATION_시부야역
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.LandingMap
import com.github.hemoptysisheart.parking.app.ui.template.LandingMapHeader
import com.github.hemoptysisheart.parking.domain.place.Geolocation

/**
 * [``]()
 */
@Composable
fun LandingMapPageContent(
        interaction: LandingMapInteraction,
        headerText: String,
        center: Geolocation,
        zoom: Float
) {
    Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
    ) {
        LandingMap(center = center, zoom = zoom)
        LandingMapHeader(
                text = headerText,
                gotoDestinationSearch = interaction::gotoDestinationSearch,
                gotoSetting = interaction::gotoSetting
        )
    }
}


@Composable
@PagePreview
fun Preview_LandingMapPageContent() {
    PagePreviewContainer {
        LandingMapPageContent(
                LandingMapInteraction(it),
                stringResource(R.string.page_landingmap_header_label),
                GEOLOCATION_시부야역,
                17F
        )
    }
}
