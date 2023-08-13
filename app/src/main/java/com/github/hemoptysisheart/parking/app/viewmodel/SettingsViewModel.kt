package com.github.hemoptysisheart.parking.app.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * `main/settings`
 *
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54310-34798&mode=design
 * - https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54406-992&mode=design
 */
@HiltViewModel
class SettingsViewModel @Inject constructor() : BaseViewModel() {
    init {
        logger.d("#init complete.")
    }
}
