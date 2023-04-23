package com.github.hemoptysisheart.parking.app.ui.preview

import android.annotation.SuppressLint
import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.ui.navigation.SelectRoutePageNavigation
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_株式会社ＡＡＡ
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_신주쿠역
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewLocation.LOCATION_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.GEO_SEARCH_MODEL
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewModel.LOCATION_MODEL
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewRoute.ROUTE_新宿駅_패밀리마트_카부키쵸키타점
import com.github.hemoptysisheart.parking.app.viewmodel.MainViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.SearchViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.SelectRouteViewModel
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Route
import kotlinx.coroutines.flow.MutableStateFlow

object PreviewViewModel {
    val MAIN_VM = MainViewModel(LOCATION_MODEL)

    val SEARCH_VM = SearchViewModel(LOCATION_MODEL, GEO_SEARCH_MODEL)

    @SuppressLint("StaticFieldLeak")
    val SELECT_ROUTE_VM = object : SelectRouteViewModel(
        SavedStateHandle(
            mapOf(
                SelectRoutePageNavigation.ARG_DESTINATION_ID to LOCATION_株式会社ＡＡＡ.id
            )
        ),
        LOCATION_MODEL,
        GEO_SEARCH_MODEL
    ) {
        override val origin = LOCATION_신주쿠역

        override val destination = MutableStateFlow<Location?>(LOCATION_패밀리마트_카부키쵸키타점)

        override val focusedRoute = MutableStateFlow<Route?>(ROUTE_新宿駅_패밀리마트_카부키쵸키타점)

        override val routeList = MutableStateFlow<List<Route>>(listOf(ROUTE_新宿駅_패밀리마트_카부키쵸키타점))
    }
}