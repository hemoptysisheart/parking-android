package com.github.hemoptysisheart.parking.app.viewmodel.launcher

import androidx.lifecycle.LifecycleOwner
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.activity.WizardActivity
import com.github.hemoptysisheart.parking.app.viewmodel.BaseViewModel
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.app.WizardPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.Duration
import javax.inject.Inject
import kotlin.reflect.KClass

/**
 * [스플래시](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=526-641)
 */
@HiltViewModel
class LauncherViewModel @Inject constructor(
        private val executionPreferences: ExecutionPreferences,
        private val wizardPreferences: WizardPreferences,
        private val locationModel: LocationModel
) : BaseViewModel() {
    companion object {
        private val LOGGER = AndroidLogger(LauncherViewModel::class)

        const val LAUNCHER_DELAY = 3_000L
    }

    private val _target = MutableStateFlow<KClass<*>?>(null)
    val target: StateFlow<KClass<*>?> = _target

    init {
        LOGGER.i("#init called.")
    }

    override fun onStart(owner: LifecycleOwner) {
        LOGGER.d("#onStart args : owner=$owner")
        super.onStart(owner)

        launch {
            val before = timeProvider.instant()

            val target = if (
                    0L == executionPreferences.coldStartCount ||
                    !locationModel.granted ||
                    wizardPreferences.bootUpShow
            ) {
                WizardActivity::class
            } else {
                MainActivity::class
            }

            val remain = Duration.between(before, timeProvider.instant())
            if (LAUNCHER_DELAY > remain.toMillis()) {
                delay(LAUNCHER_DELAY - remain.toMillis())
            }
            _target.emit(target)
        }
    }
}
