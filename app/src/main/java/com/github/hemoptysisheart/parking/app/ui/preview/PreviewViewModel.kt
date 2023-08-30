package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.GlobalHeaderViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.LandingMapViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.SettingsViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.launcher.LauncherViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.DestinationSearchViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.RouteNavigationViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SearchSettingViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SelectParkingViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.main.SelectRouteViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.InstructionViewModel
import com.github.hemoptysisheart.parking.app.viewmodel.wizard.LocationViewModel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.model.RouteModel
import com.github.hemoptysisheart.parking.domain.app.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.app.SearchPreferences
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import com.github.hemoptysisheart.util.TruncatedTimeProvider

@Composable
fun previewGlobalHeaderViewModel(
        globalChannelConsumer: GlobalChannelConsumer = previewGlobalChannelConsumer()
) = GlobalHeaderViewModel(globalChannelConsumer)

@Composable
fun previewBaseViewModel(): BaseViewModel {
    val vm = BaseViewModel()
    vm.timeProvider = TruncatedTimeProvider()
    vm.globalChannel = previewGlobalChannel()
    return vm
}

fun previewDestinationSearchViewModel(
        searchPreferences: SearchPreferences = previewPreferencesModel().search,
        locationModel: LocationModel = previewLocationModel(),
        placeModel: PlaceModel = previewPlaceModel()
) = DestinationSearchViewModel(searchPreferences, locationModel, placeModel)

fun previewInstructionViewModel() = InstructionViewModel(previewPreferencesModel().wizard)

fun previewLandingMapViewModel(locationModel: LocationModel = previewLocationModel()) =
        LandingMapViewModel(locationModel)

fun previewLauncherViewModel(
        executionPreferences: ExecutionPreferences = previewPreferencesModel().execution,
        wizardPreferences: WizardPreferences = previewPreferencesModel().wizard,
        locationModel: LocationModel = previewLocationModel()
) = LauncherViewModel(executionPreferences, wizardPreferences, locationModel)

fun previewLocationViewModel(
        locationModel: LocationModel = previewLocationModel()
) = LocationViewModel(locationModel, previewPreferencesModel().wizard)

fun previewSearchSettingViewModel(
        searchPreferences: SearchPreferences = previewPreferencesModel().search
) = SearchSettingViewModel(searchPreferences)

fun previewSettingsViewModel() = SettingsViewModel()

fun previewSelectParkingViewModel(
        savedStateHandle: SavedStateHandle = SavedStateHandle(),
        placeModel: PlaceModel = previewPlaceModel(),
        locationModel: LocationModel = previewLocationModel(),
        searchPreferences: SearchPreferences = previewPreferencesModel().search
) = SelectParkingViewModel(savedStateHandle, placeModel, locationModel, searchPreferences)

fun previewSelectRouteViewModel(
        savedStateHandle: SavedStateHandle = SavedStateHandle(),
        locationModel: LocationModel = previewLocationModel(),
        placeModel: PlaceModel = previewPlaceModel(),
        routeModel: RouteModel = previewRouteModel()
) = SelectRouteViewModel(savedStateHandle, locationModel, placeModel, routeModel)

fun previewRouteNavigationViewModel(
        savedStateHandle: SavedStateHandle,
        routeModel: RouteModel = previewRouteModel()
) = RouteNavigationViewModel(savedStateHandle, routeModel)
