package com.github.hemoptysisheart.parking.app.viewmodel

import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.parking.core.util.Logger
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(
    private val wizard: WizardPreferences
) : ViewModel() {
    companion object {
        private const val TAG = "LauncherViewModel"
        private val LOGGER = Logger(TAG)
    }

    val gotoWizard = wizard.bootUpShow

    init {
        LOGGER.i("#init : gotoWizard=$gotoWizard")
    }
}
