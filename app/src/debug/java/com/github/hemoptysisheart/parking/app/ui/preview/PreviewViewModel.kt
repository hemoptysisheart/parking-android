package com.github.hemoptysisheart.parking.app.ui.preview

import android.annotation.SuppressLint
import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.ui.interaction.main.NavigationInteraction
import com.github.hemoptysisheart.parking.app.ui.interaction.main.SelectRouteInteraction
import com.github.hemoptysisheart.parking.app.viewmodel.*
import com.github.hemoptysisheart.parking.domain.Location
import com.github.hemoptysisheart.parking.domain.Route
import kotlinx.coroutines.flow.MutableStateFlow

val LAUNCHER_VM = LauncherViewModel(WIZARD_PREFERENCES_MODEL)

val MAIN_VM = MainViewModel(SENSOR_MODEL)

val SEARCH_VM = SearchViewModel(SENSOR_MODEL, LOCATION_MODEL)

val SELECT_ROUTE_VM = @SuppressLint("StaticFieldLeak") object : SelectRouteViewModel(
    SavedStateHandle(
        mapOf(SelectRouteInteraction.ARG_DESTINATION_ID to LOCATION_株式会社ＡＡＡ.id)
    ),
    SENSOR_MODEL,
    LOCATION_MODEL
) {
    override val origin = LOCATION_신주쿠역

    override val destination = MutableStateFlow<Location?>(LOCATION_패밀리마트_카부키쵸키타점)

    override val focusedRoute = MutableStateFlow<Route?>(ROUTE_新宿駅_패밀리마트_카부키쵸키타점)

    override val routeList = MutableStateFlow(listOf(ROUTE_新宿駅_패밀리마트_카부키쵸키타점))
}

val NAVIGATION_VM = NavigationViewModel(
    SavedStateHandle(
        mapOf(NavigationInteraction.ARG_ROUTE_ID to "${ROUTE_新宿駅_패밀리마트_카부키쵸키타점.id}")
    ),
    SENSOR_MODEL, LOCATION_MODEL
)

val LOCATION_PERMISSION_VIEW_MODEL = LocationPermissionViewModel(PERMISSION_MODEL)