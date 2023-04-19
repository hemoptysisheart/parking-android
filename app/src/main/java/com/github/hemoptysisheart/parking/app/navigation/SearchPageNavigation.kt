package com.github.hemoptysisheart.parking.app.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavController
import com.github.hemoptysisheart.parking.domain.RecommendItem

class SearchPageNavigation(
    navController: NavController
) : AbstractPageNavigation(navController) {
    companion object {
        const val NAME = "SearchPage"
        const val ROUTE = NAME
    }

    @OptIn(ExperimentalComposeUiApi::class)
    val hideSoftKeyboard: (SoftwareKeyboardController?) -> Unit = {
        if (null != it) {
            it.hide()
        } else {
            LOGGER.e("#hideSoftKeyboard controller is null.")
        }
    }

    val gotoSelectRoute: (RecommendItem<*>) -> Unit = {
        LOGGER.d("#gotoSelectRoute args : item=$it")
        navController.navigate("${SelectRoutePageNavigation.NAME}/${it.id}")
    }
}
