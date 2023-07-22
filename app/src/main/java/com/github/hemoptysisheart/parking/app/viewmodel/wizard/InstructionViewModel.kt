package com.github.hemoptysisheart.parking.app.viewmodel.wizard

import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.domain.WizardPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InstructionViewModel @Inject constructor(
    private val wizardPreferences: WizardPreferences
) : BaseViewModel() {
    init {
        wizardPreferences.bootUpShow = false
        wizardPreferences.increaseShowCount()
    }
}
