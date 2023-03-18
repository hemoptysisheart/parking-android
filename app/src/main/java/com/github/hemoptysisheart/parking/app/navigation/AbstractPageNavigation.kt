package com.github.hemoptysisheart.parking.app.navigation

import androidx.navigation.NavController
import com.github.hemoptysisheart.parking.core.util.Logger

abstract class AbstractPageNavigation(
    protected val navController: NavController
) {
    companion object {
        private const val TAG = "Navigation"
        val LOGGER = Logger(TAG)
    }

    fun back() = navController.popBackStack()
}