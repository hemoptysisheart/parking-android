package com.github.hemoptysisheart.parking.app.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.interaction.*

@Composable
@OptIn(ExperimentalComposeUiApi::class)
@Preview
fun commonInteraction() = CommonInteraction(
    context = LocalContext.current,
    navController = rememberNavController(),
    softwareKeyboardController = LocalSoftwareKeyboardController.current
)
