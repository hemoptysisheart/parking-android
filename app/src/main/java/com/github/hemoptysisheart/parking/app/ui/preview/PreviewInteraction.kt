package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.PreviewActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.interaction.BaseInteraction

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun previewBaseInteraction(
    navController: NavHostController = rememberNavController(),
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current
) = remember {
    BaseInteraction(PreviewActivity(), navController, keyboardController)
}
